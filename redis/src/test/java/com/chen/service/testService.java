package com.chen.service;

import com.chen.RedisApplication;
import com.chen.domain.City;
import com.chen.service.CityService;
import com.chen.service.impl.CityServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author chenjingquan
 * @create 2020/9/18
 */
@SpringBootTest(classes = {RedisApplication.class})// 指定启动类
public class testService {

    private CityService cityService;

    @Autowired
    public testService(CityServiceImpl cityServiceImpl) {
        this.cityService = cityServiceImpl;
    }

    @Test
    public void test(){
        City city = cityService.findCityById(2);
        System.out.println(city);

    }
}
