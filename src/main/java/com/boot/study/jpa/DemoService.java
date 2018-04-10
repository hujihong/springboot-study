package com.boot.study.jpa;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
    public class DemoService {

        @Resource
        private DemoRepository demoRepository;

        @Resource
        private DemoDao demoDao;

        public void save(Demo demo){
            demoRepository.save(demo);
        }

        public Demo getById(long id){
            //demoRepository.findOne(id);//在demoRepository可以直接使用findOne进行获取.
            return demoDao.getById(id);
        }
    }