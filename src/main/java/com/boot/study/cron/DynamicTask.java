package com.boot.study.cron;

import java.util.Date;

import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * （a）我们首先了一个类DynamicTask;
 （b）定义了两个变量，threadPoolTaskScheduler和future 其中future是treadPoolTaskScheduler执行方法schedule的返回值，主要用于定时任务的停止。
 （c）编写启动定时器的方法startCron()；
 （d）编写停止方法stopCron(),这里编码的时候，需要注意下需要判断下future为null的时候，不然就很容易抛出NullPointerException；
 （e）编写修改定时任务执行周期方法changeCron10（），这里的原理就是关闭之前的定时器，创新在创建一个新的定时器。
 */

@RestController
@Component
public class DynamicTask {


    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture<?> future;

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }


    @RequestMapping("/startCron")
    public String startCron() {
        future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger("0/5 * * * * *"));
        System.out.println("DynamicTask.startCron()");
        return "startCron";
    }


    @RequestMapping("/stopCron")
    public String stopCron() {
        if (future != null) {
            future.cancel(true);
        }
        System.out.println("DynamicTask.stopCron()");
        return "stopCron";
    }

    @RequestMapping("/changeCron10")
    public String startCron10() {
        stopCron();// 先停止，在开启.
        future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger("*/10 * * * * *"));
        System.out.println("DynamicTask.startCron10()");
        return "changeCron10";
    }



    private class MyRunnable implements Runnable {

        @Override

        public void run() {

            System.out.println("DynamicTask.MyRunnable.run()，" + new Date());

        }

    }



}