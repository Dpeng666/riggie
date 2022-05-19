package com.itheima.raggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.raggie.dto.DishDto;
import com.itheima.raggie.entity.Dish;

/**
 * @Author : Dpeng
 * @Date : 2022/4/27  20:55
 */
public interface DishService extends IService<Dish> {
    //新增菜品，同时插入菜品对应的口味数据
    public void saveWithFlavor(DishDto dishDto);
    //根据id查询菜品信息和口味信息
    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);
}
