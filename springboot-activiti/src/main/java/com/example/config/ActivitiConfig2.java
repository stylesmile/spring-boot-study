//package com.example.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.activiti.spring.SpringProcessEngineConfiguration;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.transaction.PlatformTransactionManager;
//
///**
// * @author: chenye.
// * @createTime: 2018/10/29
// */
//@Configuration
//public class ActivitiConfig2 {
//
//    @Autowired
//    PlatformTransactionManager transactionManager;
//
//    //@Autowired
//    DruidDataSource druidDataSource;
//
//    //@Autowired
//    //UserEntityFactory userEntityFactory;
//
//    //@Autowired
//    //GroupEntityFactory groupEntityFactory;
//
//    @Bean
//    public SpringProcessEngineConfiguration getProcessEngineConfiguration(){
//        SpringProcessEngineConfiguration config =
//                new SpringProcessEngineConfiguration();
//        config.setDataSource(druidDataSource);
//        config.setTransactionManager(transactionManager);
//        config.setDatabaseType("mysql");
//        config.setDatabaseSchemaUpdate("true");
//
//        // 使用slife的用户表
//        //config.setCustomSessionFactories(Arrays.asList(userEntityFactory, groupEntityFactory));
//
//        // 流程图字体
//        config.setActivityFontName("宋体");
//        config.setAnnotationFontName("宋体");
//        config.setLabelFontName("黑体");
//
//        // 替换activiti自带主键策略
//        //config.setIdGenerator(new IdGenerator());
//        return config;
//    }
//
////    @Primary
////    @Bean
////    public TaskExecutor primaryTaskExecutor() {
////        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
////        return executor;
////    }
//}