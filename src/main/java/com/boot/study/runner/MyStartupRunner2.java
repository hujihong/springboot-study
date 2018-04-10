package com.boot.study.runner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 服务启动执行
 *
 * @Order 注解的执行优先级是按value值从小到大顺序
 */
@Component
@Order(value=2)
public class MyStartupRunner2 implements CommandLineRunner {

    // 这里的args就是程序启动的时候进行设置的,
    // SpringApplication.run(SpringbootStudyApplication.class, args)
    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 22222222<<<<<<<<<<<<<");
    }

}