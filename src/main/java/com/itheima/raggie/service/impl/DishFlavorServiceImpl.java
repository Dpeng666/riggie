package com.itheima.raggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.raggie.entity.Dish;
import com.itheima.raggie.entity.DishFlavor;
import com.itheima.raggie.mapper.DishFlavorMapper;
import com.itheima.raggie.mapper.DishMapper;
import com.itheima.raggie.service.DishFlavorService;
import com.itheima.raggie.service.DishService;
import org.springframework.stereotype.Service;

/**
 * @Author : Dpeng
 * @Date : 2022/4/27  20:56
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
