package com.boot.study.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hujh on 2018/3/26.
 */
@Component
@ConfigurationProperties(prefix = "wisely2")
public class Wisely2Settings {

    private String name;
    private String gender;

    private List<String> employs = new ArrayList<String>();

    private String value;
    private Integer number;
    private Long bignumber;
    private int test1;
    private int test2;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getEmploys() {
        return employs;
    }

    public void setEmploys(List<String> employs) {
        this.employs = employs;
    }

    @Override
    public String toString() {
        return "Wisely2Settings{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", employs=" + employs +
                ", value='" + value + '\'' +
                ", number=" + number +
                ", bignumber=" + bignumber +
                ", test1=" + test1 +
                ", test2=" + test2 +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getBignumber() {
        return bignumber;
    }

    public void setBignumber(Long bignumber) {
        this.bignumber = bignumber;
    }

    public int getTest1() {
        return test1;
    }

    public void setTest1(int test1) {
        this.test1 = test1;
    }

    public int getTest2() {
        return test2;
    }

    public void setTest2(int test2) {
        this.test2 = test2;
    }
}
