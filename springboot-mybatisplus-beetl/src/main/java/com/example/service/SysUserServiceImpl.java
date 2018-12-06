package com.example.service;

import com.example.dao.SysUserMapper;
import com.example.entity.SysUser;
import com.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("SysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper,SysUser> implements SysUserService{


    public Result<String> getSysUserByNameAndPassword(String loginName, String password) {
        SysUser user = baseMapper.getSysUserByNameAndPassword(loginName,password);
        if(user!=null){
            return Result.success("登陆成功");
        }else{
            return Result.fail("用户名或者密码错误");
        }
    }

    public List<SysUser> geList() {
        return baseMapper.getUserList();
    }

}
