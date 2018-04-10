package com.boot.study.shiro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hujh on 2018/4/10.
 */
@RestController
public class Hello2Controller {

    @RequestMapping("/hello2")
    public String hello(String params1,String params2){
        return "hello,Andy,params1="+params1+",params1="+params2;
    }

}
