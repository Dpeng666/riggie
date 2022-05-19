package com.itheima.raggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.raggie.common.CustomExcepction;
import com.itheima.raggie.entity.Category;
import com.itheima.raggie.entity.Dish;
import com.itheima.raggie.entity.Setmeal;
import com.itheima.raggie.mapper.CategoryMapper;
import com.itheima.raggie.service.CategoryService;
import com.itheima.raggie.service.DishService;
import com.itheima.raggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : Dpeng
 * @Date : 2022/4/27  20:19
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;
    /**
     * 根据id删除分类,删除前判断是否关联菜品
     * @param id
     */
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        //1.是否关联菜品
        lambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int count = dishService.count(lambdaQueryWrapper);
        if (count>0){
            throw new CustomExcepction("当前分类关联了菜品，无法删除");
        }
        //2.是否关联套餐
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper=new LambdaQueryWrapper<>();
        //1.是否关联菜品
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);
        if (count2>0){
            throw new CustomExcepction("当前分类关联了套餐，无法删除");
        }
        super.removeById(id);
    }
}
