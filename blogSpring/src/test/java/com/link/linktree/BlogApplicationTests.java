package com.link.linktree;

import com.link.blog.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class BlogApplicationTests {

	@Resource
	private UserMapper userMapper;
	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Test
	void contextLoads() {
		System.out.println(userMapper.findAll());
	}

	@Test
	void getIndex(){
		stringRedisTemplate.opsForValue().set("xiaomi", "888");
		String res = stringRedisTemplate.opsForValue().get("xiaomi");
		System.out.println(res);
	}

	@Test
	void getToken(){

	}
}
