package com.chen.dao;

import com.chen.domain.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author chenjingquan
 * @create 2020/9/18
 */
@Mapper
public interface CityMapper {

    // 通过id获取城市
    @Select("select * from city where id=#{id}")
    public City findCityById(@Param("id") Integer id);

    //获取全部信息
    @Select("select * from city")
    public List<City> findAll();

    //保存城市
    @Insert("insert into city (province_id, city_name, description) values ( #{provinceId}, #{cityName}, #{description})")
    public Long saveCity(City city);

    //更新城市
    @Update("update city SET description = #{description} WHERE id = #{id}")
    public Long updateCity(City city);

    //删除城市 返回0表示失败   1表示成功
    @Delete("delete from city where id = #{id}")
    public Long deleteCity(@Param("id") Integer id);

}
