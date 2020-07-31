package com.muheda.notice.controller;

import com.muheda.notice.utils.TestBaseController;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: Sorin
 * @Descriptions:
 * @Date: Created in 2018/3/22
 */
public class DemoControllerTest extends TestBaseController{

    @Test
    public void save() throws Exception {
        mvc.perform(post("/demo/save")
				.param("id", "1")
				.param("content", "李四")
				.param("avg", "69"))
		        .andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testGetBean() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/demo/get/" + "1").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}