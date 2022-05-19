package com.itheima.raggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.raggie.entity.Category;

/**
 * @Author : Dpeng
 * @Date : 2022/4/27  20:18
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
