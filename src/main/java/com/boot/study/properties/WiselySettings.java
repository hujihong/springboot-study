package com.boot.study.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by hujh on 2018/3/26.
 */
@Component
@ConfigurationProperties(prefix = "wisely")
@PropertySource("classpath:config/wisely.properties")
public class WiselySettings {
    private String name;
    private String gender;

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
}
