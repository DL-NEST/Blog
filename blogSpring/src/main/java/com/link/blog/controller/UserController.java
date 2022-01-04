package com.link.blog.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.alibaba.fastjson.JSONObject;
import com.link.blog.dao.UserMapper;
import com.link.blog.entiy.User;
import com.link.blog.enums.CodeReturn;
import com.link.blog.exception.CodeExec;
import com.link.blog.service.UserService;
import com.link.blog.util.RedisUtil;
import com.link.blog.util.TokenUtil;
import com.link.blog.annotation.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @Resource
    private TokenUtil tokenUtil;

    /**
     * @return List<User>
     * @apiNote 获取所有用户
     * @author dl-nest
     * @date 2021/11/25 17:33
     */
    @GetMapping(path = "/All")
    public List<User> All() {
        return userMapper.findAll();
    }

    @GetMapping(path = "/pre")
    public List<User> pre() {
        List<User> sd = userMapper.findByUserName("dl-nest");
        throw new CodeExec(CodeReturn.PARAM_TYPE_BIND_ERROR);
    }

    @GetMapping(path = "/set")
    public boolean set() {
        return redisUtil.setKey("haa","dwf",3,TimeUnit.MINUTES);
    }

    /**
     * @return string token
     * @apiNote 获取token
     * @author dl-nest
     * @date 2021/11/25 17:32
     */
    @GetMapping(path = "/getToken")
    public String getToken(){
        return tokenUtil.getToken("audience","subject","tyr");
    }

    /**
     * @return org.springframework.boot.configurationprocessor.json.JSONObject
     * @apiNote 解析token
     * @author dl-nest
     * @date 2021/11/25 17:34
     */
    @ResponseBody
    @PostMapping(path = "/login")
    public JSONObject Login(@RequestBody JSONObject jsonParam, HttpServletResponse response){
        return userService.Login(jsonParam.getString("UserName"),jsonParam.getString("PassWord"));
    }
    @PostMapping(path = "/cvv")
    public JSONObject cvv(){
        JSONObject re = new JSONObject();
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(180, 100);
        re.put("img",lineCaptcha.getImageBase64Data());
        re.put("value",lineCaptcha.getCode());
        return re;
    }

}
