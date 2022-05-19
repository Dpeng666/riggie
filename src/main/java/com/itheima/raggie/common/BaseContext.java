package com.itheima.raggie.common;

/**
 * 封装ThreadLocal的工具类，用于保存和获取当前用户的id
 * @Author : Dpeng
 * @Date : 2022/4/27  15:41
 */
public class BaseContext {
    private static  ThreadLocal<Long> threadLocal=new ThreadLocal<>();

    /**
     * 设置值
     * @param id
     */
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    /**
     * 获取值
     * @return
     */
    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
