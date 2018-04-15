package com.boot.study.cron;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;


/**
 * CRON表达式 含义
 "0 0 12 * * ?"      每天中午十二点触发
 "0 15 10 ? * *"    每天早上10：15触发
 "0 15 10 * * ?"    每天早上10：15触发
 "0 15 10 * * ? *"   每天早上10：15触发
 "0 15 10 * * ? 2005"    2005年的每天早上10：15触发
 “0 * 14 * * ?"    每天从下午2点开始到2点59分每分钟一次触发
 "0 0/5 14 * * ?"    每天从下午2点开始到2：55分结束每5分钟一次触发
 "0 0/5 14,18 * * ?"     每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发
 "0 0-5 14 * * ?"    每天14:00至14:05每分钟一次触发
 "0 10,44 14 ? 3 WED"    三月的每周三的14：10和14：44触发
 "0 15 10 ? * MON-FRI"   每个周一、周二、周三、周四、周五的10：15触发
 */
@Configuration
@EnableScheduling
public class MyTask {

    /**
     * 我们希望这个方法每10秒打印一次.
     * cron: 定时任务表达式.
     *
     * 指定：秒，分钟，小时，日期，月份，星期，年（可选）.
     * *：任意.
     *
     */
    @Scheduled(cron="0/10 * * * * *")
  //@Scheduled(cron="0/10 * * * * ?")
    public void tast1(){
       System.out.println("MyTask.tast1(),"+new Date());
    }

    /**
     * 我们希望这个方法每1分钟打印一次.
     */
    @Scheduled(cron="0 0/1 * * * *")
    public void tast2(){
       System.out.println("MyTask.tast2(),"+new Date());
    }


    // 固定等待时间@Scheduled(fixedDelay = 时间间隔 )
    /**
     * ①程序启动的时候，会执行第一次；
     ②第二次执行的前提是上一次任务执行完毕之后才会执行。
     ③如果，间隔时间>=程序执行时间，每次时间差=间隔时间+程序执行时间}
     ④如果，间隔时间<程序执行时间，时间差可能是=程序执行时间（这是大部分的情况）；也可能是=间隔时间+程序执行时间；
     */
    @Scheduled(fixedDelay = 3000)
    public void tast3(){
        Date d = new Date();
        System.out.println("MyTask.tast3(),"+d);
        try {
            Thread.sleep(6000);
            System.out.println("MyTask.tast3(),"+d+".end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 固定间隔时间@Scheduled(fixedRate = 时间间隔 )
    /**
     *（a）程序启动之后，就会启动第一次；
     （b）如果，间隔时间>=程序执行时间，每次时间差=间隔时间；
     （c）如果，间隔时间<程序执行时间，每次时间差=间隔时间+程序执行时间；
     */
    @Scheduled(fixedRate  = 3000)
    public void tast4(){
        Date d = new Date();
        System.out.println("MyTask.tast4(),"+d);
        try {
            Thread.sleep(2000);
            System.out.println("MyTask.tast4(),"+d+".end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}