package com.flypiggyyoyoyo.redispracdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flypiggyyoyoyo.redispracdemo.data.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class RedisStringTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testStoreUser() throws JsonProcessingException {
        User user = new User("团长", 27);
        String json = mapper.writeValueAsString(user);
        stringRedisTemplate.opsForValue().set("user:300", json);
        String json2 = stringRedisTemplate.opsForValue().get("user:300");
        User user2 = mapper.readValue(json2, User.class);
        System.out.println(user2);
    }
}
