package com.example.userGroup;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.util.DataTable;

import java.util.List;
import java.util.Map;

/**
 *
 * @author chen
 * @date 2017/11/6
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
public interface ISysUserService extends IService<SysUser> {


     SysUser getById(String id);


    /**
     * 查询某个用户的所有信息
     *
     * @param id
     * @return
     */
     SysUser selectUserAllInfoById(Long id) ;


    List<SysRole> getUserRoles(String userId);
}
