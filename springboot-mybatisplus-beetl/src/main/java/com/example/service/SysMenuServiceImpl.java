package com.example.service;

import com.example.dao.SysMenuMapper;
import com.example.entity.SysMenu;
import com.example.util.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SysMenuService")
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuMapper,SysMenu> implements SysMenuService{

    public List<SysMenu> geList() {
        return baseMapper.getMenuList();
    }

}
