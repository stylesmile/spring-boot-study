package com.example.userGroup;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chenye
 * @date 2017/4/21
 * Describe: 系统用户service
 */
@Service
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class SysUserService extends ServiceImpl<UserMapper,SysUser> implements ISysUserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser getById(String id) {
        return userMapper.selectById(Long.parseLong(id));
    }
    /**
     * 查询某个用户的所有信息
     * @return
     */
    @Override
    public SysUser selectUserAllInfoById(Long id) {
        return null;
        //return this.baseMapper.selectUserAllInfoById(id);
    }

    @Override
    public List<SysRole> getUserRoles(String userId) {
        return userMapper.getUserRoles(Long.parseLong(userId));
    }
}
