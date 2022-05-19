package com.itheima.raggie.filter;

import com.alibaba.fastjson.JSON;
import com.itheima.raggie.common.BaseContext;
import com.itheima.raggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : Dpeng
 * @Date : 2022/4/26  14:38
 */
@Slf4j
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    //路径匹配器，支持通配符
    public static  final AntPathMatcher PATH_MATCHER=new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        //本次请求的url
        String requestURI = request.getRequestURI();
        log.info("拦截到请求{}",requestURI);
        //不需要处理的请求路径
        String[] urls=new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/dish/**",
                "/user/sendMsg",
                "/user/login"
        };
        boolean check = check(urls, requestURI);
        if(check){
            log.info("本次请求{}不需要处理",requestURI);
            filterChain.doFilter(request,response);
            return;
        }
        //判断网页端用户登录状态
       if(request.getSession().getAttribute("employee")!=null){
           log.info("用户已登录，id为{}",request.getSession().getAttribute("employee"));
           Long  empId = (Long) request.getSession().getAttribute("employee");
           BaseContext.setCurrentId(empId);
           filterChain.doFilter(request,response);
           return;
       }
       //判断移动端用户登录状态
        if(request.getSession().getAttribute("user")!=null){
            log.info("用户已登录，id为{}",request.getSession().getAttribute("user"));
            Long  userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);
            filterChain.doFilter(request,response);
            return;
        }
        log.info("用户未登录");
        //通过输出流方式向客户端响应数据
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;

    }

    /**
     * 路径匹配，检查本次请求是否需要放行
     * @param urls
     * @param requestUrl
     * @return
     */
    public boolean check(String[] urls,String requestUrl){
        for (String url :urls){
            boolean math=PATH_MATCHER.match(url,requestUrl);
            if (math){
                return true;
            }
        }
        return false;
    }
}
