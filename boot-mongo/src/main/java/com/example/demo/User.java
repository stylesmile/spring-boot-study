package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author chenye
 */
@Data
@Document(collection = "user")
public class User {

    @Id
    private String id;
    @Field("name")
    private String name;
    @Field("password")
    private String password;
    private String phone;
    private String sex;
    private String age;

}