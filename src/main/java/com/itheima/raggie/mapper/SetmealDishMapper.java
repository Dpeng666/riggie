package com.itheima.raggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.raggie.entity.Dish;
import com.itheima.raggie.entity.Setmeal;
import com.itheima.raggie.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author : Dpeng
 * @Date : 2022/4/25  16:52
 */
@Mapper
public interface SetmealDishMapper extends BaseMapper<SetmealDish>{
}
