package com.itheima.raggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.raggie.entity.User;
import com.itheima.raggie.mapper.UserMapper;
import com.itheima.raggie.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author : Dpeng
 * @Date : 2022/5/17  16:10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
