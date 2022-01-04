package com.link.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.link.blog.annotation.ResponseResult;
import com.link.blog.util.ConfigUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dl-nest
 * @apiNote 用户设置类
 * @date 2021/12/5 20:09
 */
@Slf4j
@ResponseResult
@RestController
@RefreshScope
@RequestMapping(path = "/config")
public class ConfigController {
    @Resource
    private ConfigUtil configUtil;
    @Value("${config.evn.name}")
    private String testName;

    @GetMapping(path = "/getTest")
    public JSONObject getTestName() {
        JSONObject result = new JSONObject();
        result.put("test", testName);
        //configUtil.setConfig();
        return result;
    }

    @GetMapping(path = "/setTest")
    public boolean setTestName() {
        testName = "dd";
        return true;
    }

}
