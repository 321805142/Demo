package com.chen.dao;

import com.chen.domain.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author chenjingquan
 * @create 2020/9/18
 */
@SpringBootTest
public class testDAO {

    private CityMapper cityMapper;

    @Autowired
    public testDAO(CityMapper cityMapper){
        this.cityMapper = cityMapper;
    }

    @Test
    public void testCityDAO(){

//        City city = new City();
//        city.setProvinceId(2);
//        city.setCityName("遵义市");
//        city.setDescription("遵义会址");
//        cityMapper.saveCity(city);

//        City city = new City();
//        city.setId(2);
//        city.setDescription("凉快");
//        cityMapper.updateCity(city);

        Long aLong = cityMapper.deleteCity(6);
        System.out.println(aLong);


//        city = cityMapper.findCityById(2);
//        System.out.println(city);
    }
}
