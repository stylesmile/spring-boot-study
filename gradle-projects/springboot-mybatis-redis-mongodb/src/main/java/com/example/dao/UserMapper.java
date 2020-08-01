package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author chenye
 * @date 2018/11/04
 */
@Mapper
public interface UserMapper {
    /**
     * 查询
     *
     * @return List
     */
    @Select("select * from user ")
    List<User> query();

    List<User> getUserList();

    /**
     * 插入数据
     *
     * @return int
     */
    @Insert("insert into user(name, password) values (#{name},#{password})")
    int insert(User user);

}
