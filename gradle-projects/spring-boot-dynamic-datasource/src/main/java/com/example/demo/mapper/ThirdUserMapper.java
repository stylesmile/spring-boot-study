package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ThirdUserMapper {


    int deleteSrcUser(Integer userNum);

    int addSrcUser(User user);

    @Select("select * from third_user")
    List<User> query();
}