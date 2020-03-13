package com.example.springbootjpa;

import com.example.springbootjpa.repository.JpaRepositoryReBuild;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 启动类
 *
 * @author chenye
 * @date 2020-0313
 */
@EnableJpaAuditing
@SpringBootApplication
@EnableJpaRepositories(
        value = {"com.example.springbootjpa.repository"},
        repositoryBaseClass = JpaRepositoryReBuild.class)//最好添加
@EntityScan(basePackages = {"com.example.springbootjpa.entity"})//最好添加
public class SpringbootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaApplication.class, args);
    }

}
