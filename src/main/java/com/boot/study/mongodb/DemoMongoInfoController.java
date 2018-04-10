package com.boot.study.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hujh on 2018/4/7.
 */
@RestController
public class DemoMongoInfoController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("find2")
    public List<DemoMongoInfo> find2(){
        return mongoTemplate.findAll(DemoMongoInfo.class);
    }

    @Autowired
    private DemoMongoInfoRepository demoMongoInfoRepository;

    @RequestMapping("save")
    public String save(){
        DemoMongoInfo demoInfo = new DemoMongoInfo();
        demoInfo.setName("张三");
        demoInfo.setAge(20);
        demoMongoInfoRepository.save(demoInfo);

        demoInfo = new DemoMongoInfo();

        demoInfo.setName("李四");

        demoInfo.setAge(30);

        demoMongoInfoRepository.save(demoInfo);
        return "ok";
    }


    @RequestMapping("find")
    public List<DemoMongoInfo> find(){
        return demoMongoInfoRepository.findAll();
    }


    @RequestMapping("findByName")
    public DemoMongoInfo findByName(){
        return demoMongoInfoRepository.findByName("张三");

    }
}
