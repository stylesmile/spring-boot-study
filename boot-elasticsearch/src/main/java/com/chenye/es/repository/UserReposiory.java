package com.chenye.es.repository;

import com.chenye.es.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author chenye
 */
public interface UserReposiory extends CrudRepository<UserEntity, String> {

}