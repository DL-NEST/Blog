package com.link.blog.controller;

import com.link.blog.annotation.ResponseResult;
import com.link.blog.enums.CodeReturn;
import com.link.blog.exception.CodeExec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dl-nest
 * @apiNote 系统测试类（自检）
 * @date 2021/12/5 19:45
 */
@Slf4j
@ResponseResult
@RestController
@RefreshScope
@RequestMapping(path = "/system")
public class SystemController {

    @GetMapping(path = "/exec")
    public void CodeExec() {
        throw new CodeExec(CodeReturn.PARAM_TYPE_BIND_ERROR);
    }

}
