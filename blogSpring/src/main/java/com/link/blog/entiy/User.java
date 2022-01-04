package com.link.blog.entiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
  * @apiNote 用户表的实体化
  * @author dl-nest
  * @date 2021/11/24 18:49
 */
@Entity
@Table(name = "blog_user")
@Getter
@Setter
public class User {

    @Id
    private Integer uid;

    @Column(length = 10)
    private String userName;

    @Column(length = 50)
    private String userPassword;

    @Column(length = 1)
    private int userPermissions;

    @Column
    private String userPortrait;

    @Column(nullable = true)
    private String gender;

    @Column(nullable = true)
    private String qq;

    @Column(nullable = true)
    private String wx;

    @Column
    private String signUpTime;



}
