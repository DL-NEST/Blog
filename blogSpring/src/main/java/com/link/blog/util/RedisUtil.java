package com.link.blog.util;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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



}
