package com.xuyuchao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sun.security.util.Password;

import java.io.IOException;

/**
 * @auther xuyuchao
 * @create 2022-04-14-12:49
 */
public class LoginServlet extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if("admin".equals(username) && "admin".equals(password)) {
            resp.getWriter().write("登陆成功!");
            req.getSession().setAttribute("username",username);
        }else{
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
