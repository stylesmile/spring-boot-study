package com.example.demo;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configure {
//    @Bean
//    public Redisson redisson() {
//        Config config = new Config();
//        config.useSentinelServers()
//                .addSentinelAddress("redis://127.0.0.1:6379")
//                .setConnectTimeout(2000)
//                .setDatabase(0);
//
//        return (Redisson) Redisson.create(config);
//    }

    @Bean
    public Redisson redisson() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379")
                .setDatabase(1);
        RedissonClient redisson = Redisson.create(config);
        return (Redisson) redisson;
    }

//    //单机
//    RedissonClient redisson = Redisson.create();
//    Config config = new Config();
//    config.useSingleServer().setAddress("myredisserver:6379");
//    RedissonClient redisson = Redisson.create(config);
//
//
////主从
//
//    Config config = new Config();
//    config.useMasterSlaveServers()
//        .setMasterAddress("127.0.0.1:6379")
//    .addSlaveAddress("127.0.0.1:6389", "127.0.0.1:6332", "127.0.0.1:6419")
//    .addSlaveAddress("127.0.0.1:6399");
//    RedissonClient redisson = Redisson.create(config);
//
//
//    //哨兵
//    Config config = new Config();
//    config.useSentinelServers()
//        .setMasterName("mymaster")
//    .addSentinelAddress("127.0.0.1:26389", "127.0.0.1:26379")
//    .addSentinelAddress("127.0.0.1:26319");
//    RedissonClient redisson = Redisson.create(config);
//
//
//    //集群
//    Config config = new Config();
//    config.useClusterServers()
//        .setScanInterval(2000) // cluster state scan interval in milliseconds
//    .addNodeAddress("127.0.0.1:7000", "127.0.0.1:7001")
//    .addNodeAddress("127.0.0.1:7002");
//    RedissonClient redisson = Redisson.create(config);
}
