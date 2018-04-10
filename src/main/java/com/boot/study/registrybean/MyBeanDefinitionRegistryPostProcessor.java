package com.boot.study.registrybean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.Configuration;


/**
 * 实现自己实例化bean并注册为Spring管理

 这个类里的代码比较多，在这里简单的介绍下：方法postProcessBeanDefinitionRegistry()是用来注册bean的；而具体注册的代码比较是通用的，我们定义一个私有的方法进行注册。

 postProcessBeanFactory()是bean配置的工厂方法，在这个方法中可以获取到我们所有在postProcessBeanDefinitionRegistry方法中注册的所有bean，在这里我们可以进行属性的设置等操作。

 // 这里可以设置属性，例如

 BeanDefinition beanDefinition = beanFactory.getBeanDefinition("dataSourceA");

 MutablePropertyValues mutablePropertyValues = beanDefinition.getPropertyValues();

 //加入属性.

 mutablePropertyValues.addPropertyValue("driverClassName", "com.mysql.jdbc.Driver");

 mutablePropertyValues.addPropertyValue("url", "jdbc:mysql://localhost:3306/test");

 mutablePropertyValues.addPropertyValue("username", "root");

 mutablePropertyValues.addPropertyValue("password", "123456");
 */

// @Configuration
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    //bean 的名称生成器.
    private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory()");
    }


    /**
     * 先执行：postProcessBeanDefinitionRegistry()方法，
     * 在执行：postProcessBeanFactory()方法。
     */

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()");

       /*
        * 在这里可以注入bean.
        */
        registerBean(registry, "shanyA", ShanhyA.class);
        registerBean(registry, "shanyB", ShanhyB.class);
    }


    private void registerBean(BeanDefinitionRegistry registry, String name, Class<?> beanClass) {
        AnnotatedBeanDefinition annotatedBeanDefinition = new AnnotatedGenericBeanDefinition(beanClass);
        //可以自动生成name
        String beanName = (name != null ? name : this.beanNameGenerator.generateBeanName(annotatedBeanDefinition, registry));
        System.out.println("beanName:" + beanName);
        //bean注册的holer类.
        BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(annotatedBeanDefinition, beanName);
        //使用bean注册工具类进行注册.
        BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder, registry);
    }

}
