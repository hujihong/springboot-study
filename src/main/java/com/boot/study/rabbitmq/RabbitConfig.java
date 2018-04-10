package com.boot.study.rabbitmq;

import org.springframework.amqp.core.Queue;;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * Created by hujh on 2018/4/7.
 */
// @Configuration
// @EnableScheduling  //启用任务调度.
// @RabbitListener(queues="foo")//启用Rabbit队列监听foo key.
public class RabbitConfig {

    //rabbit操作类;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay=3000)//3s执行1次此方法;
    public void send(){
        rabbitTemplate.convertAndSend("foo","zhang");
    }

    @Bean
    public Queue fooQueue(){
        return new Queue("foo");
    }


    //接收到消息处理.
    @RabbitHandler
    public void onMessage(@Payload String foo){
        System.out.println(" >>> "+new Date() + ": " + foo);
    }

    //接收到消息处理.
    // 很有意思的是，这个方法还可以在简化下，将类上的@RabbitListener直接转移到方法上，
    // 去掉@RabbitHandler注解，直接为如下：
//    @RabbitListener(queues = "foo")
//    public void onMessage(@Payload String foo){
//        System.out.println(" >new>> "+new Date() + ": " + foo);
//    }
}
