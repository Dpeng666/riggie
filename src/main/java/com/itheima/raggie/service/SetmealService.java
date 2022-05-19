package com.itheima.raggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.raggie.dto.SetmealDto;
import com.itheima.raggie.entity.Setmeal;


import java.util.List;

/**
 * @Author : Dpeng
 * @Date : 2022/4/27  20:55
 */
public interface SetmealService extends IService<Setmeal> {

    public void saveWithDish(SetmealDto setmealDto);
    public void removeWithDish(List<Long> ids);

    public void updateSetmealStatusById(Integer status,List<Long> ids);
    public SetmealDto  getData(Long id);
}
