package com.boot.study.thymeleaf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.Map;

/**
 * Created by hujh on 2018/3/25.
 * thymeleaf和freemarker是可以共存的
 */
@Controller
public class TemplateController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    // 从 application.properties 中读取配置，如取不到默认值为Hello Shanhy
    @Value("${application.hello:HelloAngel}")
    private String hello;

    // 国际化
    @Autowired
    private MessageSource messageSource;

    @Autowired  // 封装后
    private LocaleMessageSourceService localeMessageSourceService;

    // 会话区域解析器之SessionLocaleResolver
    /**
     * @Bean
    public LocaleResolver localeResolver() {
    SessionLocaleResolver slr = new SessionLocaleResolver();
    //设置默认区域,
    slr.setDefaultLocale(Locale.CHINA);
    return slr;
    }

    request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("en", "US"));
    // 这部分代码最核心的部分就是如何设置会话的区域

    LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
    获取当前使用的区域解析器LocaleResolver 调用里面的方法
    setLocale 设置即可，这样的代码就是不管是会话还是cookie区域解析器都是一样的代码了


    Cookie区域解析器也就是说，你设置完针对cookie生效，session失效。那么这个具体怎么操作呢？我们需要在我们的启动类App.java（按你的实际情况进行修改）配置区域解析器为CookieLocaleResolver（SessionLocaleResolver部分请注释掉），具体代码如下：
     @Bean
     public LocaleResolver localeResolver() {
     CookieLocaleResolver slr = new CookieLocaleResolver();
     //设置默认区域,
     slr.setDefaultLocale(Locale.CHINA);
     slr.setCookieMaxAge(3600);//设置cookie有效期.
     returnslr;
     }


     使用参数修改用户的区域；
     除了显式调用LocaleResolver.setLocale()来修改用户的区域之外，还可以将LocaleChangeInterceptor拦截器应用到处理程序映射中，它会发现当前HTTP请求中出现的特殊参数。其中的参数名称可以通过拦截器的paramName属性进行自定义。如果这种参数出现在当前请求中，拦截器就会根据参数值来改变用户的区域。
     只需要在App.java中加入：
     @Bean
     public LocaleChangeInterceptor localeChangeInterceptor() {
     LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
     // 设置请求地址的参数,默认为：locale
     //          lci.setParamName(LocaleChangeInterceptor.DEFAULT_PARAM_NAME);
     returnlci;
     }
     @Override
     public void addInterceptors(InterceptorRegistry registry) {
     registry.addInterceptor(localeChangeInterceptor());
     }
     注意这个是可以和会话区域解析器以及Cookie区域解析器一起使用的，但是不能和FixedLocaleResolver一起使用，否则会抛出异常信息。
     */
    /**
     * 返回html模板. 默认html
     */
    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, Map<String,Object> map){
        map.put("hello","fromTemplateController.hello");
        // 两种方式
        Locale locale = LocaleContextHolder.getLocale();
        Locale locale1= RequestContextUtils.getLocale(request);

        String msg = messageSource.getMessage("welcome", null,locale);
        String msg2= messageSource.getMessage("welcome", null,locale1);

        String msg3 = localeMessageSourceService.getMessage("welcome");

        logger.info(msg);
        logger.info(msg2);
        logger.info(msg3);

        return "/hello";
    }

    @RequestMapping("/helloFtl")
    public String helloFtl(Map<String,Object> map){
        map.put("hello","fromTemplateController.helloFtl");
        return "/helloFtl";
    }


    /**
     * 多模板共享
     * @param map
     * @return
     */
    @RequestMapping("/helloJsp")
    public String helloJsp(Map<String,Object> map){
        System.out.println("HelloController.helloJsp().hello="+hello);
        map.put("hello", hello);
        return "helloJsp";
    }



}
