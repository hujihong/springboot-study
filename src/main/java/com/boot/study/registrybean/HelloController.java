package com.boot.study.registrybean;


import com.boot.study.jpa.DemoService;
import com.boot.study.mail.SendMailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.HashMap;

/**
 * Created by hujh on 2018/3/29.
 */

@RestController
public class HelloController {

    @Resource(name="demoService")
    private DemoService demoService;

    @Resource
    public Hello hello;

    @Resource(name = "world")
    private World world;

    @Resource(name = "world2")
    private World world2;

    @Resource
    private Myservice myservice;

    @Resource
    private SendMailer sendMailer;

    @RequestMapping("/testbean")
    public String testHello() throws Exception {
        hello.say();
        world.say();
        world2.say();
        myservice.say();
        // sendMailer.send();
        // sendMailer.sendAttachmentsEmail();
        HashMap map = new HashMap<>();
        sendMailer.sendInlineMail();
        return "ok";
    }


}
