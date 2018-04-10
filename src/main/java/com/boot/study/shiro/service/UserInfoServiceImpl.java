package com.boot.study.shiro.service;

import com.boot.study.shiro.entity.UserInfo;
import com.boot.study.shiro.repository.UserInfoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService{  
     
    @Resource
    private UserInfoRepository userInfoRepository;
     
    @Override  
    public UserInfo findByUsername(String username) {
       System.out.println("UserInfoServiceImpl.findByUsername()");  
       return userInfoRepository.findByUsername(username);  
    }  
     
}  