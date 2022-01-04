package com.link.blog.dao;

import com.link.blog.entiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
  * @apiNote 用户表的查询map
  * @author dl-nest
  * @date 2021/11/24 19:06
 */
public interface UserMapper extends JpaRepository<User,Integer> {
    /**
     * @apiNote 查询Username
     * @return List
     * @author dl-nest
     */
    List<User> findByUserName(String username);

    List<User> findByUid(Integer uid);

    // 检测账户密码是否匹配
    boolean existsByUserNameAndUserPassword(String UserName,String UserPassword);
    // 检测账户是否存在
    boolean existsByUserName(String UserName);
    // 获取账户的密码
}
