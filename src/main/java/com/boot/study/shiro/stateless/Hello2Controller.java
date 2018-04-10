package com.boot.study.shiro.stateless;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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

    /**
     * 如果是无状态的话，那么在调用代码：currentUser.getSession()是会抛出异常的
     * 此方法执行的时候，会抛出异常：
     * Session creation has been disabled for the current subject.
     */

    @RequestMapping("/hello3")
    public String hello3(){
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        System.out.println(session);
        return "hello3,Andy";

    }

}
