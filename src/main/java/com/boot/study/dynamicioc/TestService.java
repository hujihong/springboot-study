package com.boot.study.dynamicioc;

/**
 *
 <1>. 获取ApplicationContext;
 <2>. 通过ApplicationContext获取到BeanFacotory;
 <3>. 通过BeanDefinitionBuilder构建BeanDefiniton;
 <4>. 调用beanFactory的registerBeanDefinition注入beanDefinition；
 <5>. 使用ApplicationContext.getBean获取bean进行测试；
 *
 */
public class TestService {
    private String name;  
    public String getName() {  
       return name;  
    }  
    public void setName(String name) {  
       this.name = name;  
    }  
    public void print(){  
       System.out.println("动态载入bean,name="+name);  
    }  
} 