package com.chen;

import com.chen.bean.Employee;
import com.chen.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @Author chenjingquan
 * @create 2020/9/19
 */
@SpringBootTest
public class TestRedis {

    @Resource
    private RedisTemplate<String,Employee> redisTemplate;

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void test1() throws JsonProcessingException {
//        Employee emp = employeeService.getEmp(1);
//        redisTemplate.opsForValue().set("emp-01", emp);
        Employee employee = (Employee) redisTemplate.opsForValue().get("emp-01");
//        System.out.println(redisTemplate.getValueSerializer());
//        Employee employee = new ObjectMapper().readValue(str, Employee.class);
        System.out.println(employee);

    }


}
