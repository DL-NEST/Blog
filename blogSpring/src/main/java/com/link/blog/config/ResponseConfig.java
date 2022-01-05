package com.link.blog.config;

import com.link.blog.util.RUtils;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @apiNote 请求接口输出的装饰类
 * @author dl-nest
 * @date 2021/12/2 16:59
 */

@Component
@ControllerAdvice(basePackages = "com.link.blog.controller")
public class ResponseConfig implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        // 装饰器的开关
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //对输出的数据进行统一的装饰-- body（输出的数据）
        // 当controller的输出不为json的时候
        if(MediaType.TEXT_PLAIN.equals(selectedContentType)){
            JSONObject re = new JSONObject();
            return body;
        }
        return RUtils.success(body);
    }
}
