package com.boot.study.registrybean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Spring框架有3个主要的Hook类，分别是：
 org.springframework.context.ApplicationContextAware
 它的setApplicationContext 方法将在Spring启动之前第一个被调用。我们用来同时启动Jdon框架。
 org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor
 它的postProcessBeanDefinitionRegistry 和 postProcessBeanFactory 方法是第二和第三被调用，它们在Bean初始化创建之前启动，如果Spring的bean需要的其他第三方中的组件，我们在这里将其注入给Spring。
 org.springframework.context.ApplicationListener
 用于在初始化完成后做一些事情，当Spring所有XML或元注解的Bean都启动被创建成功了，这时会调用它的唯一方法onApplicationEvent。
 下面我们来完成一个，自己通过java代码创建bean，并注册为Spring管理。

 本例中，我们创建一个接口，然后创建该接口的2个实现类，分别命名不同的名字，然后在需要注入的地方使用@Qualifier 指定注入对应的实例。

 */
@Configuration
@Import(MyImportBeanDefinitionRegistrar.class)
public class RegistryBeanConfig {


    @Bean
    public CustomBeanDefinitionRegistry customBeanDefinitionRegistry() {
        return new CustomBeanDefinitionRegistry();
    }

    /**
     *  这里只是测试使用，没有实际的意义.
     *  使用@Resource 或者 @Autowired并指定@Qualifier 也可以：
     */
//    @Bean(name="testHelloService")
//    public HelloService filterRegistrationBean(@Qualifier("shanhyB") Shanhy shanhy){
//        HelloService helloService = new HelloService();
//        shanhy.display();
//        // 其它处理代码.
//        return helloService;
//
//    }


    @Bean
    public MyBeanDefinitionRegistryPostProcessor myBeanDefinitionRegistryPostProcessor() {
        return new MyBeanDefinitionRegistryPostProcessor();
    }

}
