package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.Role;
import com.example.springbootjpa.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户角色
 *
 * @author chenye
 */
@Repository
public interface UserRoleRepository extends
        JpaRepository<UserRole, String> {

}
