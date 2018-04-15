package com.boot.study.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 任务类.
 */
public class HelloJob implements Job{

    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 执行响应的任务.
        System.out.println("context: " + context);
       System.out.println("HelloJob.execute,"+new Date());
    }

}