package com.chen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.chen.mapper")
@EnableCaching 	// 开启基于注解的缓存
public class SpringbootCacheLeifengyangApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCacheLeifengyangApplication.class, args);
    }

}
