package com.chen.service;

import com.chen.domain.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author chenjingquan
 * @create 2020/9/18
 */
public interface CityService {


    //通过id查找一个城市
    public City findCityById(@Param("id") Integer id);

    //获取全部城市信息
    public List<? extends Object> findAll();

    //保存城市
    public Long saveCity(City city);

    //更新城市描述
    public Long updateCity(City city);

    //删除城市 返回0表示失败   1表示成功
    public Long deleteCity(@Param("id") Integer id);
}
