package com.chen;

import com.chen.bean.Employee;
import com.chen.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootCacheLeifengyangApplicationTests {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Test
	void contextLoads() {
		Employee empById = employeeMapper.getEmpById(1);
		System.out.println(empById);
	}

}
