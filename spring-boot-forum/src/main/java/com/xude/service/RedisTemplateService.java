package com.xude.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


public interface RedisTemplateService {

    public <T> boolean set(String key ,T value);
    public <T> T get(String key,Class<T> clazz);
    public <T> T stringToBean(String value, Class<T> clazz);
    public <T> String beanToString(T value);

}
