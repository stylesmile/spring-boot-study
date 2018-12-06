package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * activiti配置文件
 * AbstractProcessEngineAutoConfiguration在activiti-spring-boot-starter-basic下
 *
 * @author chenye
 * @date 2018/11/04
 */
@Configuration
public class ActivitiConfig {

    @Autowired
    PlatformTransactionManager transactionManager;
    @Autowired
    DruidDataSource druidDataSource;
//    @Autowired
//    UserEntityFactory userEntityFactory;
//    @Autowired
//    GroupEntityFactory groupEntityFactory;

    @Bean
    public SpringProcessEngineConfiguration getProcessEngineConfiguration(){
        SpringProcessEngineConfiguration config =
                new SpringProcessEngineConfiguration();
        config.setDataSource(druidDataSource);
        config.setTransactionManager(transactionManager);
        config.setDatabaseType("mysql");
        config.setDatabaseSchemaUpdate("true");

        //替换activiti的用户表
        //config.setCustomSessionFactories(Arrays.asList(userEntityFactory, groupEntityFactory));

        // 流程图字体
        config.setActivityFontName("宋体");
        config.setAnnotationFontName("宋体");
        config.setLabelFontName("黑体");
        return config;
    }
}
