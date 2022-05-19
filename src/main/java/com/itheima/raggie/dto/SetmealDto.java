package com.itheima.raggie.dto;

import com.itheima.raggie.entity.Setmeal;
import com.itheima.raggie.entity.SetmealDish;
import com.itheima.raggie.entity.Setmeal;
import com.itheima.raggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
