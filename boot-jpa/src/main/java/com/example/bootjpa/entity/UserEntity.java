package com.example.bootjpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author chenye
 * @date 2019-06-12
 */
@Entity
@Table(name = "user", indexes = {@Index(columnList = "username", name = "IDX_USERNAME")})
@Data
@EntityListeners(AuditingEntityListener.class)
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 50, name = "uid", nullable = false)
    private String uid;

    @Column(length = 20)
    private String username;

    @Column(length = 50)
    private String password;

    @Column(length = 50)
    private String nickname;

    @Column(length = 50)
    private String email;


    @Column(updatable = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    private Date createtime;
}
