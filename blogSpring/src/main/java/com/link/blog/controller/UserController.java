package com.link.blog.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.alibaba.fastjson.JSONObject;
import com.link.blog.mapper.UserMapper;
import com.link.blog.entiy.User;
import com.link.blog.enums.CodeReturn;
import com.link.blog.exception.CodeExec;
import com.link.blog.service.UserService;
import com.link.blog.util.RedisUtil;
import com.link.blog.annotation.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@ResponseResult
@RestController
@RefreshScope
@RequestMapping(path = "/user")
public class UserController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private UserService userService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Object test() {
        return redisUtil.getKeyBool("ef");
    }


    /**
     * @return org.springframework.boot.configurationprocessor.json.JSONObject
     * @apiNote 登录redis中的列表
     * @author dl-nest
     * @date 2021/11/25 17:34
     */
    @GetMapping(path = "/userLoginList")
    public JSONObject[] userLoginList(HttpServletRequest request) {
        return redisUtil.getLoginList(redisUtil.getuid(request.getHeader("Token")));
    }

    /**
     * @return org.springframework.boot.configurationprocessor.json.JSONObject
     * @apiNote 登录的接口
     * @author dl-nest
     * @date 2021/11/25 17:34
     */
    @ResponseBody
    @PostMapping(path = "/login")
    public JSONObject Login(@RequestBody JSONObject jsonParam, HttpServletResponse response){
        return userService.Login(jsonParam);
    }

    /**
     * @param jsonParam-s
     * @return com.alibaba.fastjson.JSONObject
     * @apiNote 用户注册的接口
     * @author dl-nest
     * @date 2022/1/6 1:30
     */
    @ResponseBody
    @PostMapping(path = "/signUp")
    public JSONObject signUp(@RequestBody JSONObject jsonParam, HttpServletResponse response){
        return userService.Login(jsonParam);
    }

    /**
     * @return com.alibaba.fastjson.JSONObject
     * @apiNote 随机的验证码
     * @author dl-nest
     * @date 2022/1/6 1:27
     */
    @PostMapping(path = "/cvv")
    public JSONObject cvv(){
        JSONObject re = new JSONObject();
        LineCaptcha lineCaptcha =   CaptchaUtil.createLineCaptcha(180, 100);
        re.put("img",lineCaptcha.getImageBase64Data());
        re.put("value",lineCaptcha.getCode());
        return re;
    }

}
