package com.itheima.raggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.raggie.entity.AddressBook;
import com.itheima.raggie.mapper.AddressBookMapper;
import com.itheima.raggie.service.AddressBookService;
import org.springframework.stereotype.Service;

/**
 * @Author : Dpeng
 * @Date : 2022/5/16  19:26
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
