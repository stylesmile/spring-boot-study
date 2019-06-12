package com.example.springbootjpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends
		JpaRepository<User,Integer> {
	List<User> findByEmail(String email);
}
