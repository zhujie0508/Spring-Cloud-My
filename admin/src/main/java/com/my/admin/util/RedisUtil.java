package com.my.admin.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author lianjie Zhu
 * @Date 2020/2/26 19:10
 * @Version 1.0
 */
@Component
public class RedisUtil {
    @SuppressWarnings("rawtypes")
    @Resource
    private RedisTemplate< String, Object > redisTemplate;

    @Bean("redisStringTemplate")
    public ValueOperations opsForValue(){
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        ValueOperations operations = redisTemplate.opsForValue();
        return operations;
    }
}
