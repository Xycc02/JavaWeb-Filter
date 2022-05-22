package com.xuyuchao;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @auther xuyuchao
 * @create 2022-04-14-21:47
 */
public class Filter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter2前置代码");
        System.out.println("Filter2中当前线程名:"+Thread.currentThread().getName());
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter2中当前线程名:"+Thread.currentThread().getName());
        System.out.println("Filter2后置代码");
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
