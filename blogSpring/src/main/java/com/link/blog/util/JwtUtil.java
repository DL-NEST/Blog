package com.link.blog.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author dl-nest
 * @apiNote
 * @date 2021/11/25 21:36
 */
@Component
public class JwtUtil {

    /**
     * @return string
     * @apiNote 生成token令牌
     * @author dl-nest
     * @date 2021/11/25 17:49
     */
    public String getToken(String aud, String sub, String jti){
        return JWT.create()
                .withAudience(aud)   //令牌的用处
                .withSubject(sub)      //主题
                .withIssuedAt(new Date())    //发出时间
                //.withExpiresAt(exp)    //过期时间
                .withJWTId(jti)        //令牌的标识符
                .sign(Algorithm.HMAC256(jti));
    }

    public JSONObject parseToken(){
        return new JSONObject();
    }
}
