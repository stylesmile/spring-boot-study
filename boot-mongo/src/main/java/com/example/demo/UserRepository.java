package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author chenye
 */
public interface UserRepository extends MongoRepository<User, String> {

    /**
     * 通过名称  查找所有
     *
     * @param pageable 分页
     * @param name     名称
     * @return page
     */
    Page<User> findAllByName(Pageable pageable, String name, Boolean status);

    /**
     * 通过名称查找所有
     *
     * @param name 名称
     * @return page
     */
    List<User> findAllByNameLike(String name);
}