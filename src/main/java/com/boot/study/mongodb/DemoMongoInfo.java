package com.boot.study.mongodb;

import org.springframework.data.annotation.Id;

/**
 * Created by hujh on 2018/4/7.
 */
public class DemoMongoInfo {
    //id属性是给mongodb用的，用@Id注解修饰

    @Id
    private String id;

    private String name;

    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
