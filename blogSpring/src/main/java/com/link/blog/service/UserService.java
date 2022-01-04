package com.link.blog.service;

import com.alibaba.fastjson.JSONObject;
import com.link.blog.dao.UserMapper;
import com.link.blog.enums.CodeReturn;
import com.link.blog.exception.CodeExec;
import com.link.blog.util.TokenUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * @author dl-nest
 * @apiNote 用户的服务类
 * @date 2021/11/25 16:03
 */
@Component
public class UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private TokenUtil tokenUtil;

    public JSONObject Login(String UserName, String UserPassword){
        JSONObject re = new JSONObject();
        // 判断是否登录
        if (userMapper.existsByUserNameAndUserPassword(UserName,UserPassword)){
            // 获取token/aud:用户名/sub:主题作用/jti:密码
            String token = tokenUtil.getToken(UserName,"Token",UserPassword);
            // 返回的数据
            re.put("state",true);
            re.put("token",token);
        }else {
            re.put("state",false);
            throw new CodeExec(CodeReturn.USER_PASSWORD_ERROR);
        }
        return re;
    }
}
