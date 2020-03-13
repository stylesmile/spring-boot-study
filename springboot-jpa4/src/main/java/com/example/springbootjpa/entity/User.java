package com.example.springbootjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

//使用JPA注解配置映射关系
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "sys_user") //@Table来指定和哪个数据表对应;如果省略默认表名就是user；
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {

    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @Column(name = "name", length = 50)
    private String name;
    /**
     * 省略默认列名就是属性名
     */
    @Column
    private String email;

}