package com.example.bootsolr;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * @author chenye
 */
public class User implements Serializable {
    //必须实现可序列化接口，要在网络上传输
    //使用这个注释，里面的名字是根据你在solr数据库中配置的来决定

    @Field("id")
    private String id;
    @Field("item_name")
    private String name;
    @Field("item_age")
    private Integer age;

    public User(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}