package com.example.chenye.controller;

import com.example.chenye.entity.SysUser;
import com.example.chenye.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    public static final String model ="/";

    @Autowired
    SysUserService sysUserService;

    @GetMapping(model+"/list")
    @ResponseBody
    public List<SysUser> list(){
        return sysUserService.getList();
    }
}
