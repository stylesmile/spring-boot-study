package com.Stylesmile.system.query;

import com.Stylesmile.common.PageQuery;
import com.Stylesmile.common.QueryPara;
import com.Stylesmile.system.entity.SysUser;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author chenye
 * @date 2018/12/10
 */
@Data
public class SysUserQuery extends Page<SysUser> {

    private String id;
    private String username;
    private String nickname;
    private String phone;
    private String email;

}
