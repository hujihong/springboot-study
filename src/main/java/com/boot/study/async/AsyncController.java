package com.boot.study.async;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by hujh on 2018/4/2.
 */

@RestController
public class AsyncController {

    @Resource
    private Task1 task1;

    @Resource
    private Task2 task2;

    @RequestMapping("/task1")
    public String task1() throws Exception{
        task1.doTaskOne();
        task1.doTaskTwo();
        task1.doTaskThree();
        return  "task1";
    }

    @RequestMapping("/task2")
    public String task2() throws Exception{
        task2.doTaskOne();
        task2.doTaskTwo();
        task2.doTaskThree();
        return  "task2";
    }

}
