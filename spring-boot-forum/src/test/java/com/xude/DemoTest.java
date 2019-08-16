package com.xude;

import com.xude.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {

    @Resource
    private RedisUtil redisUtil;
    @Autowired
    private StringRedisTemplate redisTemplate;
   @Test
    public void demo1(){
       boolean set = redisUtil.set("test", "testChange");
       System.out.println(set);
   }
   @Test
    public void demo2(){
       Object test = redisUtil.get("test");
       System.out.println(test.toString());
   }

    @Test
    public void test1() {
        //向集合中插入元素，并设置分数
        redisTemplate.opsForZSet().add("ranking-list", "p1", 1);

        DefaultTypedTuple<String> tuple1 = new DefaultTypedTuple<String>("p2", 1.0);
        DefaultTypedTuple<String> tuple2 = new DefaultTypedTuple<String>("p3", 2.0);
        redisTemplate.opsForZSet().add("ranking-list", new HashSet<>(Arrays.asList(tuple1, tuple2)));

        printZSet("ranking-list");
    }

    @Test
    public void test3() {
        //为指定元素加分
        Double score = redisTemplate.opsForZSet().incrementScore("ranking-list", "p1", 2);
        System.out.println(score);//返回加分后的得分
        printZSet("ranking-list");
    }

    private void printZSet(String key) {
        //按照排名先后(从小到大)打印指定区间内的元素, -1为打印全部
        Set<String> range = redisTemplate.opsForZSet().range(key, 0, -1);
        //reverseRange 从大到小
        System.out.println(range);
    }


}
