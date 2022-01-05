package com.link.blog.service;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import com.link.blog.mapper.UserMapper;
import com.link.blog.enums.CodeReturn;
import com.link.blog.exception.CodeExec;
import com.link.blog.util.RedisUtil;
import com.link.blog.util.StrUtil;
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
    private RedisUtil redisUtil;

    public JSONObject Login(JSONObject jsonParam){
        String UserName = jsonParam.getString("UserName");
        String UserPassword = jsonParam.getString("PassWord");
        String Mac = jsonParam.getString("Mac");
        String Ip = jsonParam.getString("Ip");
        JSONObject re = new JSONObject();
        // 判断是否登录
        if (userMapper.existsByUserNameAndUserPassword(UserName,UserPassword)){
            if(redisUtil.getLoginNum(userMapper.readFirstByUserNameAndUserPassword(UserName,UserPassword).getUid()) >= 5){
                throw new CodeExec(CodeReturn.USER_NUM_LOG);
            }
            // 获取token随机的uuid<String>的参数
            String token = IdUtil.randomUUID();
            // 把用户的uid和token存取到redis数据库
            String value = StrUtil.strForm(userMapper.readFirstByUserNameAndUserPassword(UserName,UserPassword).getUid(), Mac,Ip);
            redisUtil.setTokenKey(token,value,7);
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
