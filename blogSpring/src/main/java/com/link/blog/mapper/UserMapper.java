package com.link.blog.mapper;

import com.link.blog.entiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
  * @apiNote 用户表的查询map
  * @author dl-nest
  * @date 2021/11/24 19:06
 */
public interface UserMapper extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
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
    User readFirstByUserName(String UserName);

    // jpql的查询方式
    @Query(value = "from User where userName = ?2 and userName = ?1")
    User jpql(String name, int id);

    // 本地sql的查询方式
    @Query(value = "select * from blog_user;",nativeQuery = true)
    User sql(String name, int id);
}
