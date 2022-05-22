package com.xuyuchao;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * FilterChain.doFilter()的作用
 * 1.执行下一个Filter过滤器(如果有Filter)
 * 2.执行目标资源(没有Filter)
 *
 * 在多个Filter过滤器执行的时候,他们的执行的优先顺序实在web.xml中从上到下配置的顺序决定
 *
 * 多个Filter过滤器执行的特点
 * 1.所有Filter和目标资源默认都执行在同一线程中
 * 2.多个Filter共同执行的时候,他们公用一个Request对象
 * @auther xuyuchao
 * @create 2022-04-14-21:47
 */
public class Filter1 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter1前置代码");
        System.out.println("Filter1中当前线程名:"+Thread.currentThread().getName());
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter1中当前线程名:"+Thread.currentThread().getName());
        System.out.println("Filter1后置代码");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
