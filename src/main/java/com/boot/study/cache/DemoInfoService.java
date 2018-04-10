package com.boot.study.cache;


import javassist.NotFoundException;


public interface DemoInfoService {

    public DemoInfo findById(long id);

    public void deleteFromCache(long id);

    void test();


    void delete(Long id);


    DemoInfo update(DemoInfo updated) throws NotFoundException;


    DemoInfo save(DemoInfo demoInfo);

    DemoInfo findById1(Long id);
}