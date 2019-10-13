package com.example.bootswagger.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenye
 */
@RestController
@RequestMapping("test")
@Api(value = "测试接口Controller")
public class TestController {

    @ApiOperation(value = "测试用接口", notes = "测试用接口", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户姓名", dataType = "String", required = true, paramType = "form", example = "zhangsan"),
            @ApiImplicitParam(name = "id", value = "id", dataType = "int", required = false, paramType = "form", example = "123")
    })
    @RequestMapping("word")
    public String hello(String name, Integer id) {
        return "Hello Word";
    }


}