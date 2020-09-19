package com.chen.controller;

import com.chen.domain.City;
import com.chen.service.CityService;
import com.chen.service.impl.CityServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author chenjingquan
 * @create 2020/9/18
 */
@RestController
@Slf4j
@RequestMapping("/city")
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityServiceImpl cityServiceImpl){
        this.cityService = cityServiceImpl;
    }


    @GetMapping("findCityById/{id}")
    public City findfindCityById(@PathVariable("id") Integer id){
        return cityService.findCityById(id);
    }

    @GetMapping("findAll")
    public List<City> findAll(){
        return (List<City>) cityService.findAll();
    }

    @PostMapping("addCity")
    public Long addCity(City city){
        return cityService.saveCity(city);
    }

    // 只能修改描述
    @PutMapping("updataCity")
    public Long updateCity(City city){
        return cityService.updateCity(city);
    }

    @DeleteMapping("deleteCity/{id}")
    public Long deleteCity(@PathVariable("id") Integer id){
        return cityService.deleteCity(id);
    }
}
