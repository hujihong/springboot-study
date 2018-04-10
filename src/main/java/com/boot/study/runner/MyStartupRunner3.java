package com.boot.study.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 *
 1. CommandLineRunner和ApplicationRunner，他们的执行时机为容器启动完成的时候。
 2. 共同点和区别；
 共同点：其一执行时机都是在容器启动完成的时候进行执行；其二这两个接口中都有一个run()方法；
 不同点：ApplicationRunner中run方法的参数为ApplicationArguments，而CommandLineRunner接口中run方法的参数为String数组
 */
@Component
@Order(value=3)
public class MyStartupRunner3 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("<<<<<<<<<<<<这个是测试ApplicationRunner接口>>>>>>>>>>>>>>");

    }
}
