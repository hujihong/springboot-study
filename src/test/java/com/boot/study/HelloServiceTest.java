package com.boot.study;

import com.boot.study.test.HelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;

/**
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
**/
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {

    @Resource
    private HelloService helloService;

    @Test
    public void testGetName(){
        Assert.assertEquals("hello",helloService.getName());
    }

}
