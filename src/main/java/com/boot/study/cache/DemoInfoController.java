package com.boot.study.cache;


import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoInfoController {

    @Autowired
    DemoInfoService demoInfoService;


    @RequestMapping("/test")
    public @ResponseBody
    String test() {
        DemoInfo loaded = demoInfoService.findById(1);
        System.out.println("loaded=" + loaded);
        DemoInfo cached = demoInfoService.findById(1);
        System.out.println("cached=" + cached);
        loaded = demoInfoService.findById(2);
        System.out.println("loaded2=" + loaded);
        return "ok";
    }


    @RequestMapping("/delete")
    public @ResponseBody
    String delete(long id) {
        demoInfoService.deleteFromCache(id);
        return "ok";
    }

    @RequestMapping("/test1")
    public @ResponseBody
    String test1() {
        demoInfoService.test();
        System.out.println("DemoInfoController.test1()");
        return "ok";
    }


    @RequestMapping("/test2")
    @ResponseBody
    public String test2(){

        //存入两条数据.
        DemoInfo demoInfo = new DemoInfo();
        demoInfo.setName("abc3");
        demoInfo.setPwd("123456");
        DemoInfo demoInfo2 = demoInfoService.save(demoInfo);

        //不走缓存.
        System.out.println(demoInfoService.findById1(demoInfo2.getId()));
        //走缓存.
        System.out.println(demoInfoService.findById1(demoInfo2.getId()));


        demoInfo = new DemoInfo();
        demoInfo.setName("abc4");
        demoInfo.setPwd("123456");
        DemoInfo demoInfo3 = demoInfoService.save(demoInfo);

        //不走缓存.
        System.out.println(demoInfoService.findById1(demoInfo3.getId()));
        //走缓存.
        System.out.println(demoInfoService.findById1(demoInfo3.getId()));

        System.out.println("============修改数据=====================");
        //修改数据.
        DemoInfo updated = new DemoInfo();
        updated.setName("abc4-updated");
        updated.setPwd("123456");
        updated.setId(demoInfo3.getId());
        try {
            System.out.println(demoInfoService.update(updated));
        }catch(NotFoundException e) {
            e.printStackTrace();
        }

        //不走缓存.
        System.out.println(demoInfoService.findById1(updated.getId()));

        return "ok";
    }

}