package com.xuyuchao;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @auther xuyuchao
 * @create 2022-04-14-12:36
 */
public class AdminFilter implements Filter {
    /**
     * 用于拦截请求(权限检查),过滤响应
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        Object user = session.getAttribute("username");
        if(user == null) {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
        }else{
            //让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter调用init初始化!");
        //1.获取Filter的名称filter-name的内容
        System.out.println("filter-name的值为" + filterConfig.getFilterName());
        //2.获取在web.xml中配置的init-param初始化参数
        System.out.println("初始化参数username的值为:" + filterConfig.getInitParameter("username"));
        //3.获取ServletContext对象
        System.out.println(filterConfig.getServletContext());
    }

    @Override
    public void destroy() {
        System.out.println("Filter被销毁!");
    }
}
