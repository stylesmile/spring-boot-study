package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author chenye
 */
@Mapper
public interface UserMapper {


    @Select("select * from user")
    List<User> query();
}