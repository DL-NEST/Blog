package com.link.blog.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.link.blog.mapper.UserMapper;
import com.link.blog.enums.CodeReturn;
import com.link.blog.exception.CodeExec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author pmd
 * @version v0.1.0
 */
public class UserFilter implements HandlerInterceptor {

    @Value("${global.jwt.key}")
    private String jwtKey;

    @Resource
    private UserMapper userMapper;
    /**
     * @apiNote 拦截，判断为true的时候放行
     * @author dl-nest
     * @date 2021/11/25 17:46
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Token");
        String userId,userUid;
        //token不为空
        if (token == null) {
            System.out.println("token为空，请携带正确的token");
            return false;
        }
        // 测试环境跳过拦截器的token的检查
        if (token.equals("test")) {
            return  true;
        }
        // 获取jwt的值
        try {
            userId = JWT.decode(token).getAudience().get(0);
            userUid = JWT.decode(token).getSubject();
        } catch (JWTVerificationException e) {
            //获取失败，值不匹配
            throw new CodeExec(CodeReturn.USER_NOT_EXIST);
        }
        //匹配userid的值(用户名),验证密钥是否正确
        if (userMapper.existsByUserName(userId)){
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(userMapper.findByUserName(userId).get(0).getUserPassword())).build();
            try {
                jwtVerifier.verify(token);
                System.out.println("密匙正确");
                return true;
            } catch (JWTVerificationException e) {
                throw new CodeExec(CodeReturn.USER_PASSWORD_ERROR);
            }
        }else{
            throw new CodeExec(CodeReturn.USER_NOT_EXIST);
        }
        //response.addHeader("Content-Test","123"); 添加返回头
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // throw new RuntimeException("401");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}