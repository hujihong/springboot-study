package com.boot.study.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hujh on 2018/3/24.
 */
@Controller
public class WebController {

    @RequestMapping("/login1")
    public String login1() {
        System.out.println("login.html");
        return "login1";
    }

}
