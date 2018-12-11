package com.Stylesmile.service;

import com.Stylesmile.dao.SysMenuMapper;
import com.Stylesmile.entity.SysMenu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SysMenuService")
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuMapper,SysMenu> implements SysMenuService{

    public List<SysMenu> geList() {
        return baseMapper.getMenuList();
    }

}
