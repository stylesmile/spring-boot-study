package com.example.dao.second;

import com.example.model.SrcUser;
import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jason.tang
 * @create 2019-02-13 14:08
 * @description
 */
@Mapper
public interface SrcUserDao {

    SrcUser getSrcUser(Integer userNum);

    int deleteSrcUser(Integer userNum);

    int addSrcUser(User user);

    @Select("select * from src_user")
    List<User> query();
}