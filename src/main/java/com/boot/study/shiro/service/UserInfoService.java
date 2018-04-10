package com.boot.study.shiro.service;

import com.boot.study.shiro.entity.UserInfo;

public interface UserInfoService {
     
    /**通过username查找用户信息;*/  
    public UserInfo findByUsername(String username);
     
}  