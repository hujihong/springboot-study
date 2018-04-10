package com.boot.study.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by hujh on 2018/4/2.
 */

@Component
@ConfigurationProperties(prefix = "com.kfit")
@PropertySource("classpath:config/employ.properties")
public class EmployProperty {

    private CompanyEmployeeInfo employForzs;

    private CompanyEmployeeInfo employForls;

    public CompanyEmployeeInfo getEmployForzs() {
        return employForzs;
    }

    public void setEmployForzs(CompanyEmployeeInfo employForzs) {
        this.employForzs = employForzs;
    }

    public CompanyEmployeeInfo getEmployForls() {
        return employForls;
    }

    public void setEmployForls(CompanyEmployeeInfo employForls) {
        this.employForls = employForls;
    }


    public static class CompanyEmployeeInfo {
        private String name;
        private int age;
        private String gender;

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
        public String getGender() {
            return gender;
        }
        public void setGender(String gender) {
            this.gender = gender;
        }
        @Override
        public String toString() {
            return "EmployForzs [name=" + name + ", age=" + age + ", gender=" + gender + "]";
        }
    }

    @Override
    public String toString() {
        return "CompanyEmployee [employForzs=" + employForzs + ", employForls=" + employForls + "]";
    }
}
