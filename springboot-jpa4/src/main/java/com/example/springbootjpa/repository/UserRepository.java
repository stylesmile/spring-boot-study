package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends
		JpaRepository<User,String> {
}
