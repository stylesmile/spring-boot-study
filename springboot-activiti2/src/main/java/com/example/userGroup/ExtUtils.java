package com.example.userGroup;

import com.example.util.StringUtils;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;

import java.util.List;

public class ExtUtils {
    private static ISysUserService userService = ApplicationContextRegister.getBean(ISysUserService.class);
    /**
     * 获取用户角色
     * @param userId
     * @return
     */
//    public static List<SysRole> getUserRoles(String userId) {
//        return userService.selectUserAllInfoById(Long.parseLong(userId)).getSysRoles();
//    }
    public static List<SysRole> getUserRoles(String userId) {
        return userService.getUserRoles(userId);
    }
    /**
     * 将SysRole转为activiti的entity
     * @param role
     * @return
     */
    public static GroupEntity toActivitiGroup(SysRole role){
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setId(role.getId() + "");
        groupEntity.setName(role.getName());
        groupEntity.setType(role.getType());
        groupEntity.setRevision(1);
        return groupEntity;
    }
    public static UserEntity toActivitiUser(SysUser user){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId() + "");
        userEntity.setFirstName(user.getName());
        userEntity.setLastName(StringUtils.EMPTY);
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());
        userEntity.setRevision(1);
        return userEntity;
    }
    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    public static SysUser getUserInfo(String userId) {
        return userService.getById(userId);
    }

}
