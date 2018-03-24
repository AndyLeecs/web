package com.didispace.web;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@FixMethodOrder(MethodSorters.JVM)
public class UserControllerTest {

    private MockMvc mvc;
    private RequestBuilder request = null;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getUserList() throws Exception{
        request = get("/users/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void postUser() throws Exception{
        request = post("/users/").
                param("id","1")
                .param("name","安迪")
                .param("age","20");
        mvc.perform(request).andExpect(content().string(equalTo("success")));
    }

    @Test
    public void getUser() throws Exception{
        //先get列表
        request = get("/users/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"安迪\",\"age\":20}]")));

    }

    @Test
    public void putUser() throws Exception{
        //put and get
        request = put("/users/1")
                .param("name","软件工程师")
                .param("age","30");
        mvc.perform(request).andExpect(content().string(equalTo("success")));
        request = get("/users/1");
        mvc.perform(request).andExpect(content().string(equalTo("{\"id\":1,\"name\":\"软件工程师\",\"age\":30}")));
    }

    @Test
    public void deleteUser() throws Exception{
        request = delete("/users/1");
        mvc.perform(request).andExpect(content().string(equalTo("success")));
        request = get("/users/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
    }
}