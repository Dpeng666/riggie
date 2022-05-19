package com.itheima.raggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.raggie.common.R;
import com.itheima.raggie.entity.User;
import com.itheima.raggie.service.UserService;
import com.itheima.raggie.utils.SMSUtils;
import com.itheima.raggie.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Queue;

/**
 * @Author : Dpeng
 * @Date : 2022/5/17  19:33
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 手机验证码
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session){
        //1.获取手机号
        String phone = user.getPhone();
        if(StringUtils.isNotEmpty(phone)){
            //2.生成验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("生成的验证码为:{}",code);
            //3.调用短信服务API
            //SMSUtils.sendMessage("瑞吉外卖","",phone,code);
            //4.保存生成的验证码
            session.setAttribute(phone,code);
            return R.success("短信发送成功");
        }
    return R.error("短信发送失败");
    }

    /**
     * 移动端用户登录
     * @param map
     * @param session
     * @return
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session){

        //获取手机号
        String phone = map.get("phone").toString();
        //获取验证码
        String code = map.get("code").toString();
        //获取session验证码
        Object codeInSession = session.getAttribute(phone);
        //验证码比对
        if(codeInSession!=null&&codeInSession.equals(code)){
            //判断是否为新用户
            LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper();
            queryWrapper.eq(User::getPhone,phone);
            User user = userService.getOne(queryWrapper);
            if (user==null){
                user=new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            session.setAttribute("user",user.getId());
            return R.success(user);
        }

        return R.error("登录失败");
    }
}
