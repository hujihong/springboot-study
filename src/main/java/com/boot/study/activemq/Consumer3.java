package com.boot.study.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer3 {

    @JmsListener(destination = "sample.topic")
    public void receiveQueue(String text) {
       System.out.println("Consumer3="+text);
    }

}