package com.ffzs.webflux.r2dbc_test.services;

import com.ffzs.webflux.r2dbc_test.models.Employee;
import com.ffzs.webflux.r2dbc_test.tool.GsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;

@SpringBootTest
class EmployeeServiceTest {
    @Resource
    EmployeeService employeeService;

    @Test
    public void list() {
        Flux<Employee> employeeFlux = employeeService.findAll();
        String json = GsonUtil.objectToJson(employeeFlux);
        System.out.println(json);
    }
}