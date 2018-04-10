package com.boot.study.db;

import com.boot.study.jpa.DemoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hujh on 2018/4/1.
 */
@RestController
public class DemodbController {

    @Autowired
    private DemodbService demodbService;

    @RequestMapping("/likeName")
    public List<Demo> likeName(String name, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return demodbService.likeName(name);
    }

    @RequestMapping("/findAll")
    public List<Demo> findAll(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return demodbService.findAll();
    }
}
