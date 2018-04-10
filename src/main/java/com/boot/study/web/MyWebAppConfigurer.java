package com.boot.study.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by hujh on 2018/3/24.
 */
// @Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 这样使用代码的方式自定义目录映射，并不影响Spring Boot的默认映射，可以同时使用。
         如果我们将/myres/* 修改为 /* 与默认的相同时，则会覆盖系统的配置，
         可以多次使用 addResourceLocations添加目录，优先级先添加的高于后添加的
         其中 addResourceLocations 的参数是动参，
         可以这样写 addResourceLocations(“classpath:/img1/”,“classpath:/img2/”, “classpath:/img3/”);
         */
        registry.addResourceHandler("myres/**").addResourceLocations("classpath:/myres/");
        // 外部文件
        registry.addResourceHandler("/tmp/**").addResourceLocations("file:/Users/hujh/Desktop/tmp/");
        // super.addResourceHandlers(registry);

        // registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");
        // registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
        /**
         * spring.mvc.static-path-pattern=

         # 默认值为classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/

         spring.resources.static-locations=这里设置要指向的路径，多个使用英文逗号隔开，

         使用spring.mvc.static-path-pattern 可以重新定义pattern，如修改为 /myres/** ，则访问static 等目录下的fengjing.jpg文件应该为http://localhost:8080/myres/fengjing.jpg ，修改之前为 http://localhost:8080/fengjing.jpg
         使用spring.resources.static-locations 可以重新定义 pattern 所指向的路径，支持 classpath: 和 file: （上面已经做过说明）
         注意spring.mvc.static-path-pattern 只可以定义一个，目前不支持多个逗号分割的方式。

         通过spring.mvc.static-path-pattern这种方式配置，会使Spring Boot的默认配置失效
         */
    }
}
