package com.example.springbootjpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author chenye
 */ //使用JPA注解配置映射关系
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "sys_user_role") //@Table来指定和哪个数据表对应;如果省略默认表名就是user；
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
@NoArgsConstructor
public class UserRole {

    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private Integer id;

    @Column(name = "user_id", length = 50)
    private String userId;

    /**
     * 角色id
     */
    @Column(name = "role_id", length = 50)
    private String roleId;

}