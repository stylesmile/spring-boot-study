//package com.example;
//
//import com.example.mongo.PrimaryMongoObject;
//import com.example.mongo.PrimaryRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class MuliDatabaseTest {
//
//    @Autowired
//    private PrimaryRepository primaryRepository;
//
//    @Autowired
//    private SecondaryRepository secondaryRepository;
//
//    @Test
//    public void TestSave() {
//
//        System.out.println("************************************************************");
//        System.out.println("测试开始");
//        System.out.println("************************************************************");
//
//        this.primaryRepository
//                .save(new PrimaryMongoObject(null, "第一个库的对象"));
//
//        this.secondaryRepository
//                .save(new SecondaryMongoObject(null, "第二个库的对象"));
//
//        List<PrimaryMongoObject> primaries = this.primaryRepository.findAll();
//        for (PrimaryMongoObject primary : primaries) {
//            System.out.println(primary.toString());
//        }
//
//        List<SecondaryMongoObject> secondaries = this.secondaryRepository.findAll();
//
//        for (SecondaryMongoObject secondary : secondaries) {
//            System.out.println(secondary.toString());
//        }
//
//        System.out.println("************************************************************");
//        System.out.println("测试完成");
//        System.out.println("************************************************************");
//    }
//
//}