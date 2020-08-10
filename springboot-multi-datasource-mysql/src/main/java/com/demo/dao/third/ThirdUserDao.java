package com.demo.dao.third;

import com.demo.model.SrcUser;
import com.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jason.tang
 * @create 2019-02-13 14:08
 * @description
 */
@Mapper
public interface ThirdUserDao {

    SrcUser getSrcUser(Integer userNum);

    int deleteSrcUser(Integer userNum);

    int addSrcUser(User user);

    @Select("select * from third_user")
    List<User> query();
}