package com.boot.study.cron;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ① 在定时任务类上增加@EnabledScheduling注解，并实现SchedulingConfigurer接口。
 ② 设置一个静态的cron，用于存放任务执行周期参数。
 ③ 开启一个线程，用于模拟实际业务中外部原因修改了任务执行周期。
 ④ 设置任务触发器，触发任务执行。
 */

/**
 * 这里核心的主要是使用到了ScheduledTaskRegistrar这个类有一个方法addTriggerTask（Runnable,Trigger） 两个参数，
 * 一个Runnable,一个是Trigger，在Runnable中执行业务逻辑代码，在Trigger修改定时任务的执行周期
 */
@Component
@EnableScheduling
public class TaskCronChange implements SchedulingConfigurer {

    public static String cron; 

    public TaskCronChange() {
        //默认情况是：每5秒执行一次.
        cron = "0/5 * * * * *";
        new Thread(new Runnable() {
           // 开启新线程模拟外部更改了任务执行周期.
           @Override
           public void run() {
              try {
                  // 让线程睡眠 15秒.
                  Thread.sleep(15000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }

               //修改为：每10秒执行一次.
              cron = "0/10 * * * * *";
               System.err.println("cron change to:"+cron);
           }

       }).start();;

    }

     

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
       Runnable task = new Runnable() {
           @Override

           public void run() {
              //任务逻辑代码部分.
              System.out.println("TaskCronChange task is running ... "+ new Date());
           }

       };

       Trigger trigger = new Trigger() {

           @Override
           public Date nextExecutionTime(TriggerContext triggerContext) {
              //任务触发，可修改任务的执行周期.
              CronTrigger trigger = new CronTrigger(cron);
              Date nextExec = trigger.nextExecutionTime(triggerContext);
              return nextExec;
           }
       };
       taskRegistrar.addTriggerTask(task, trigger);

    }

   

}