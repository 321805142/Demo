package com.chen.service.impl;

import com.chen.dao.CityMapper;
import com.chen.domain.City;
import com.chen.service.CityService;
import com.chen.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author chenjingquan
 * @create 2020/9/18
 */
@Service
@Slf4j
public class CityServiceImpl implements CityService {

    private RedisUtil redisUtil;
    private CityMapper cityMapper;

    @Autowired
    public CityServiceImpl(RedisUtil redisUtil,
                           CityMapper cityMapper) {
        this.redisUtil = redisUtil;
        this.cityMapper = cityMapper;
    }


    /**
     * 获取城市：
     * 如果缓存存在，从缓存中获取城市信息
     * 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
     */
    @Override
    public City findCityById(Integer id) {
        // 从缓存中获取城市信息
        String key = "city_" + id;  //生成唯一key，以便修改和删除时找到此值

        // 缓存存在
        boolean hasKey = redisUtil.hasKey(key);
        if (hasKey) {
            City city = (City) redisUtil.get(key);

            log.info("------从缓存中获取了城市>>>>>  {}", city.toString());
            return city;
        }
        // 从 DB 中获取城市信息
        City city = cityMapper.findCityById(id);
        // 插入缓存
        redisUtil.set(key, city, 100);
        log.info("------获取城市插入缓存>>>>  {}", city.toString());

        return city;
    }

    /**
     * 获取全部城市信息
     *
     * @return
     */
    @Override
    public List<?> findAll() {
        String key = "citys";
        if (redisUtil.hasKey(key)) {
            //
            return redisUtil.lGet(key, 0, -1);
        }
        List<City> all = cityMapper.findAll();
        redisUtil.lSet(key, all);
        return all;
    }

    /**
     * 新增记录
     *
     * @param city
     * @return
     */
    @Override
    public Long saveCity(City city) {
        Long city1 = cityMapper.saveCity(city);
        // 新增成功之后需要刷新redis缓存中的数据
        String key = "citys";

        List<City> allCity = cityMapper.findAll();
        if (redisUtil.hasKey(key)) {
            redisUtil.del(key);
        }
        redisUtil.lSet(key, allCity);
        return city1;
    }

    /**
     * 修改City的描述  一般都会根据id修改
     *
     * @param city
     * @return
     */
    @Override
    public Long updateCity(City city) {
        String key = "city_" + city.getId();    //生成唯一key
        Long city1 = cityMapper.updateCity(city);

        redisUtil.set(key, city);

        return city1;
    }

    @Override
    public Long deleteCity(Integer id) {
        String key = "city_" + id;      //生成唯一key

        Long city1 = cityMapper.deleteCity(id);
        if (redisUtil.hasKey(key) && city1 == 1) {
            redisUtil.del(key);
        }
        return city1;
    }
}
