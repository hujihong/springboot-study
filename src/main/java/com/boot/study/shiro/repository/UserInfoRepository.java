package com.boot.study.shiro.repository;

import com.boot.study.shiro.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo,Long> {
     
    /**通过username查找用户信息;*/  
    public UserInfo findByUsername(String username);
     
}  