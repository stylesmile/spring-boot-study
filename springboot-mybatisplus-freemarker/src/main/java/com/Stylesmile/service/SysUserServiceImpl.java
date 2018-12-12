package com.Stylesmile.service;

import com.Stylesmile.dao.SysUserMapper;
import com.Stylesmile.entity.SysUser;
import com.Stylesmile.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService{


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

    @Override
    public IPage<SysUser> getUserList(Page<SysUser> page, Integer state) {
        return baseMapper.getUserList2(page,state);
    }

}
