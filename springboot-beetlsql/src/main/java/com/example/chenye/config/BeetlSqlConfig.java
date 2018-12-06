package com.example.chenye.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class BeetlSqlConfig{
//    @Autowired
//    HikariDataSource hikariDataSource;

    @Bean(name="datasource")
    public DataSource datasource(Environment env) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        return ds;
    }
    //如果你想配置主从或者指定一个已经配置好的数据源，可以自己创建一个 BeetlSqlDataSource的Bean，比如，在你的配置代码里
//    @Bean
//    public BeetlSqlDataSource beetlSqlDataSource(@Qualifier("master")  HikariDataSource dataSource, @Qualifier("slave")  DataSource slave){
//        BeetlSqlDataSource source = new BeetlSqlDataSource();
//        source.setMasterSource(hikariDataSource);
//        source.setSlaves(new DataSource[]{slave});
//        return source;
//    }

    //可以实现BeetlSqlCustomize接口来定制BeetlSQL，比如
//    @Bean
//    public BeetlTemplateCustomize beetlTemplateCustomize(){
//        return new BeetlTemplateCustomize(){
//            public void customize(GroupTemplate groupTemplate){
//
//            }
//        };
//    }

}