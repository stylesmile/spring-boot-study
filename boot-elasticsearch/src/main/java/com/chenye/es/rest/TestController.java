package com.chenye.es.rest;

import com.chenye.es.util.JsonResult;
import com.chenye.es.entity.UserEntity;
import com.chenye.es.repository.UserReposiory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author chenye
 */
@RestController
@RequestMapping("es")
@Api(value = "测试接口Controller")
public class TestController {

    @Resource
    UserReposiory userReposiory;

    /**
     * 登陆方法
     *
     * @param username 登陆用户名称
     * @param password 密码
     * @return Result
     * <p>
     * LogLoginAnnotation 为登陆日志aop
     */
/*    @ApiOperation(value = "测试用接口", notes = "测试用接口", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户登录名", example = "15002220000", dataType = "String", required = true, paramType = "form"),
            @ApiImplicitParam(name = "password", value = "密码", example = "123456", dataType = "String", required = true, paramType = "form")
    })
    @PostMapping("/test.json")
    public JsonResult<String> login(@RequestParam("username") String username,
                                    @RequestParam("password") String password) {

        return JsonResult.success(username + password);
    }*/

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserEntity user(@RequestBody UserEntity user) {
        return userReposiory.save(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Optional<UserEntity> user(String id) {
        return userReposiory.findById(id);
    }

}