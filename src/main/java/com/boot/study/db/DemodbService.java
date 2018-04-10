package com.boot.study.db;

import com.boot.study.db.mapper.DemoMappper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hujh on 2018/4/1.
 */
@Service
public class DemodbService {

    @Autowired
    private DemoMappper demoMappper;

    public List<Demo> likeName(String name){
        return demoMappper.likeName(name);
    }

    public List<Demo> findAll(){
        return demoMappper.findAll();
    }
}
