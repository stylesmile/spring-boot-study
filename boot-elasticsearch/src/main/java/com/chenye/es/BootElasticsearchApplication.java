package com.chenye.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.chenye.es.repository")
public class BootElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootElasticsearchApplication.class, args);
    }

}
