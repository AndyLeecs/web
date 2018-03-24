package com.didispace.Chapter1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private BlogProperties blogProperties;


    @Test
    public void getHello() throws Exception {
        Assert.assertEquals(blogProperties.getName(), "安迪");
        Assert.assertEquals(blogProperties.getTitle(), "测试");
    }

    @Test
    public void testMulSen() throws Exception{
        Assert.assertEquals("安迪想要一次过测试",blogProperties.getSen());
    }

}
