package com.boot.study;

import com.boot.study.dynamicioc.TestService;
import com.boot.study.properties.Wisely2Settings;
import com.boot.study.properties.WiselySettings;
import com.boot.study.quartz.HelloJob;
import com.boot.study.registrybean.MyBeanDefinitionRegistryPostProcessor;
import com.boot.study.servlet.MyServlet1;
import org.mybatis.spring.annotation.MapperScan;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.MultipartConfigElement;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
@ServletComponentScan // 这个就是扫描相应的Servlet包; WebServlet Listener Filter
// @ComponentScan(basePackages={"cn.kfit","org.kfit","com.kfit"})  // 自定义扫描包
// @EnableConfigurationProperties({WiselySettings.class,Wisely2Settings.class})

@EnableCaching
public class SpringbootStudyApplication extends SpringBootServletInitializer {

	static final Logger logger = LoggerFactory.getLogger(SpringbootStudyApplication.class);

	/**
	 <1>. 获取ApplicationContext;
	 <2>. 通过ApplicationContext获取到BeanFacotory;
	 <3>. 通过BeanDefinitionBuilder构建BeanDefiniton;
	 <4>. 调用beanFactory的registerBeanDefinition注入beanDefinition；
	 <5>. 使用ApplicationContext.getBean获取bean进行测试；
	 * @param args
	 */

	public static void main(String[] args) {

		//获取context.
		ApplicationContext ctx =  (ApplicationContext) SpringApplication.run(SpringbootStudyApplication.class, args);


		//获取BeanFactory
		DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) ctx.getAutowireCapableBeanFactory();

		//创建bean信息.
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(TestService.class);
		beanDefinitionBuilder.addPropertyValue("name","张三");

		//动态注册bean.
		defaultListableBeanFactory.registerBeanDefinition("testService", beanDefinitionBuilder.getBeanDefinition());

		// 多次注入同一个bean的，如果beanName不一样的话，那么会产生两个Bean；如果beanName一样的话，后面注入的会覆盖前面的
		beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(TestService.class);
		beanDefinitionBuilder.addPropertyValue("name","李四");
		defaultListableBeanFactory.registerBeanDefinition("testService", beanDefinitionBuilder.getBeanDefinition());


		// beanName不一样的代码
		beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(TestService.class);
		beanDefinitionBuilder.addPropertyValue("name","李四1");
		defaultListableBeanFactory.registerBeanDefinition("testService1", beanDefinitionBuilder.getBeanDefinition());

		//获取动态注册的bean.
		// TestService testService =ctx.getBean(TestService.class); // 多次注入同一bean,但名字不同，会报错，需要用名字获取
		TestService testService = (TestService)ctx.getBean("testService");
		testService.print();

		testService = (TestService)ctx.getBean("testService1");
		testService.print();

		//删除bean.
		// defaultListableBeanFactory.removeBeanDefinition("testService");

		// quartz
		scheduler();
	}

	@Bean
	public MyBeanDefinitionRegistryPostProcessor myBeanDefinitionRegistryPostProcessor() {
		return new MyBeanDefinitionRegistryPostProcessor();
	}

	/**
	 * 注册Servlet
	 * @return
	 */
	@Bean
	public ServletRegistrationBean MyServlet1(){
		return new ServletRegistrationBean(new MyServlet1(),"/myServlet1/*");
	}



	/** 注入Bean : HttpMessageConverters，以支持fastjson
	@Configuration
	public class BeanConfig {

		@Bean
		public HttpMessageConverters fastJsonHttpMessageConverters() {
			FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
			FastJsonConfig fastJsonConfig = new FastJsonConfig();
			fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
			fastConvert.setFastJsonConfig(fastJsonConfig);
			return new HttpMessageConverters((HttpMessageConverter<?>) fastConvert);
		}
	}
	**/


	// 上传文件设置
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
		factory.setMaxFileSize("128KB"); //KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("256KB");
		//Sets the directory location wherefiles will be stored.
		//factory.setLocation("路径地址");
		return factory.createMultipartConfig();
	}

	/**
	 * ImportResouce有两种常用的引入方式：classpath和file，具体查看如下的例子：
	 classpath路径：locations={"classpath:application-bean1.xml",
	 "classpath:application-bean2.xml"
	 }
	 file路径：
	 locations= {"file:d:/test/application-bean1.xml"};
	 */


	public static void scheduler() {
		try {
			// 获取Scheduler实例
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
			System.out.println("scheduler.start");

			System.out.println(scheduler.getSchedulerName());

			//具体任务.
			JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();

			//触发时间点. (每5秒执行1次.)
			SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
			// 触发时间点
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startNow().withSchedule(simpleScheduleBuilder).build();

			// CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 * * * * ? *");
			// Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(cronScheduleBuilder).build();

			// 交由Scheduler安排触发
			scheduler.scheduleJob(jobDetail, trigger);

			//睡眠20秒.
			TimeUnit.SECONDS.sleep(20);
			scheduler.shutdown(); //关闭定时任务调度器.
			System.out.println("scheduler.shutdown");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
