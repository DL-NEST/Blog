package com.link.blog.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author dl-nest
 * @apiNote
 * @date 2021/11/25 15:45
 */
@Component
public class RedisUtil {
    @Resource
    private StringRedisTemplate stringredisTemplate;

    /**
      * @param key（键）value（值）time（时间）
      * @return 返回boolean
      * @apiNote 设置键值对，时间默认是分钟
      * @author dl-nest
      * @date 2021/11/25 16:05
     */
    public Boolean setKey(String key,String value,int time,TimeUnit unit){
        // set(K key, V value, long timeout, [SECOND_SCALE-秒,MINUTE_SCALE-分,HOUR_SCALE-小时,DAY_SCALE-天]||null{MINUTE_SCALE});
        stringredisTemplate.opsForValue().set(key,value,time,unit);
        return true;
    }

    public Boolean setTokenKey(String key,String value,int time){
        stringredisTemplate.opsForValue().set(key, value,time,TimeUnit.DAYS);
        return true;
    }
    // 获取key的过期时间
    public Long getKeyExpire(){
        return stringredisTemplate.getExpire("5bc1b2df-6114-48c8-a671-9bd05532eea5",TimeUnit.DAYS);
    }
    // 通过value返回用户的记录,最多五个
    public JSONObject[] getLoginList(String uid){
        JSONObject[] list = new JSONObject[5];
        int i = 0;
        for (String x : Objects.requireNonNull(stringredisTemplate.keys("*"))){
            String value = stringredisTemplate.opsForValue().get(x);
            if(Objects.equals(StrUtil.parsForm(value,0), String.valueOf(uid))){
                JSONObject re = new JSONObject();
                re.put(x,StrUtil.parsJson(value));
                list[i] = re;
                i++;
            }
        }
        return list;
    }
    // 通过token获取uid
    public String getuid(String token){
        String value = stringredisTemplate.opsForValue().get(token);
        return StrUtil.parsForm(value,0);
    }
    // 获取用户的已登录数
    public int getLoginNum(int uid){
        int i = 0;
        for (String x : Objects.requireNonNull(stringredisTemplate.keys("*"))){
            String value = stringredisTemplate.opsForValue().get(x);
            if(Objects.equals(StrUtil.parsForm(value,0), String.valueOf(uid))){
                i++;
            }
        }
        return i;
    }
    // 检测用户是否登录
    public boolean getKeyBool(String Token){
        String value = stringredisTemplate.opsForValue().get(Token);
        return value != null;
    }
}
