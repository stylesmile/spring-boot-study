package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 继承JpaRepository来完成对数据库的操作
 *
 * @author chenye
 */
@Repository
public interface RoleRepository extends
        JpaRepository<Role, String> {

}
