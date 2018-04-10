package com.boot.study.jpa;

import com.boot.study.SpringUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by hujh on 2018/3/24.
 */
@RestController
@RequestMapping("/demo2")
public class DemoJpaController {

    @Resource
    private DemoService demoService;

    //地址：http://127.0.0.1:8080/demo2/getById?id=1
    @RequestMapping("/getById")
    public Demo getById(long id){

        DemoService demoService1 = (DemoService)SpringUtil.getBean("demoService");
        System.out.println(demoService1.getById(id));
        return demoService.getById(id);
    }

    @RequestMapping("/save")
    public String save(){
        Demo d = new Demo();
        d.setName("Angel");
        demoService.save(d);//保存数据.
        return "ok.Demo2Controller.save";
    }

}
