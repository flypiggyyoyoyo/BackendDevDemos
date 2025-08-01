package com.flypiggyyoyoyo.redispracdemo;

import com.flypiggyyoyoyo.redispracdemo.data.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisPracDemoApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void TestString() {
        redisTemplate.opsForValue().set("place", "沈阳大街");
        Object place = redisTemplate.opsForValue().get("place");
        System.out.print(place);
    }

    @Test
    void TestStoreUser() {
        redisTemplate.opsForValue().set("user111", new User("团长", 24));
        Object user = redisTemplate.opsForValue().get("user111");
        System.out.print(user);
    }
}
