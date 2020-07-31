package com.muheda.notice.utils;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Author: Sorin
 * @Descriptions:
 * @Date: Created in 2018/3/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBaseController {

    @Autowired
    WebApplicationContext context;

    public MockMvc mvc;

    @Before
    public void initTests() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
}
