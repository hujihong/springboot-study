package com.boot.study.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * Created by hujh on 2018/3/29.
 */

/**
 * @EnableRedisHttpSession来开启spring session支持，
 * 而@EnableRedisHttpSession这个注解是由spring-session-data-redis提供的，
 * 所以在pom.xml文件中spring-session-data-redis
 * @EnableRedisHttpSession(maxInactiveIntervalInSeconds= 60) //1分钟失效
 * 或者 spring.session.store-type=redis
 * 命名空间设置：
 * spring.session.redis.namespace=xxxx
 * 或 @EnableRedisHttpSession(redisNamespace="xxxx")
 */
@Configuration
@EnableRedisHttpSession  //
public class RedisSessionConfig {

    @Bean
    public CookieHttpSessionStrategy cookieHttpSessionStrategy(){
        CookieHttpSessionStrategy strategy = new CookieHttpSessionStrategy();
        DefaultCookieSerializer cookieSerializer=new DefaultCookieSerializer();
        cookieSerializer.setCookieName("MYSESSIONID");//cookies名称
        cookieSerializer.setCookieMaxAge(1800);//过期时间(秒)
        strategy.setCookieSerializer(cookieSerializer);
        return strategy;
    }

}
