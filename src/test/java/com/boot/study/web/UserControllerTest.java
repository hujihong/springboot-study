package com.boot.study.web;


import com.boot.study.web.api.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
// @SpringApplicationConfiguration(classes=MockServletContext.class)//MockServletContext.class
@SpringBootTest
@WebAppConfiguration
public class UserControllerTest extends MockMvcResultMatchers {

    //模拟mvc对象类.
    private MockMvc mvc;

    @Before
    public void setup(){

       /*
        * MockMvcBuilders使用构建MockMvc对象.
        */
       mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }


    @Test
    public void testUserController() throws Exception{
       RequestBuilder request = null;
       //1. get 以下user列表，应该为空》
       //1、构建一个get请求.
       request = MockMvcRequestBuilders.get("/users");
       mvc.perform(request)
           .andExpect(status().isOk())
           .andExpect(content().string("[]"))
           ;
       System.out.println("UserControllerTest.testUserController().get");
       // 2、post提交一个user
       request = MockMvcRequestBuilders.post("/users")
                                   .param("id","1")
                                   .param("name","林峰")
                                   .param("age","20")
              ;
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("success"));
       // 3、get获取user列表，应该有刚才插入的数据
       request = MockMvcRequestBuilders.get("/users");
    mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("[{\"id\":1,\"name\":\"林峰\",\"age\":20}]"));
       // 4、put修改id为1的user
        request = MockMvcRequestBuilders.put("/users/1")
                .param("name", "林则徐")
                .param("age", "30");
        mvc.perform(request)
                .andExpect(content().string("success"));
        // 5、get一个id为1的user
        request = MockMvcRequestBuilders.get("/users/1");
        mvc.perform(request)
                .andExpect(content().string("{\"id\":1,\"name\":\"林则徐\",\"age\":30}"));
        // 6、del删除id为1的user
        request = MockMvcRequestBuilders.delete("/users/1");
        mvc.perform(request)
                .andExpect(content().string("success"));
        // 7、get查一下user列表，应该为空
        request = MockMvcRequestBuilders.get("/users");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

   

}