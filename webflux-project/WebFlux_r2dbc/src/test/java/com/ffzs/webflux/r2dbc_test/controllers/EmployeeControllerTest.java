package com.ffzs.webflux.r2dbc_test.controllers;

import com.ffzs.webflux.r2dbc_test.tool.GsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;

@SpringBootTest
class EmployeeControllerTest {
    @Resource
    EmployeeController employeeController;

    @Test
    public void list() {
        Flux flux = employeeController.findAll();
        String json = GsonUtil.objectToJson(flux);
        System.out.println(json);
    }
}