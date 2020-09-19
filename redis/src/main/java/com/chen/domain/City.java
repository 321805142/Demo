package com.chen.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author chenjingquan
 * @create 2020/9/18
 */
@Data
@NoArgsConstructor
public class City implements Serializable {

    /**
     * 城市编号
     */
    private Integer id;

    /**
     * 省份编号
     */
    private Integer provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;
}
