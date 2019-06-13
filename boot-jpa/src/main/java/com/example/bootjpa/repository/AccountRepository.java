package com.example.bootjpa.repository;

import com.example.bootjpa.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * 用户帐号数据操作相关接口类
 *
 * @author chenye
 * @date 2019-06-12
 */
@Repository
public interface AccountRepository extends BaseJpaRepository<UserEntity, String> {

}
