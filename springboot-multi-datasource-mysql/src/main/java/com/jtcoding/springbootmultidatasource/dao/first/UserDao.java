package com.jtcoding.springbootmultidatasource.dao.first;

import com.jtcoding.springbootmultidatasource.model.User;
import lombok.Setter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jason.tang
 * @create 2019-02-13 14:08
 * @description
 */

@Mapper
public interface UserDao {

    User getUser(Integer userNum);

    int deleteUser(Integer userNum);

    int addUser(User user);

    @Select("select * from user")
    List<User> query();
}