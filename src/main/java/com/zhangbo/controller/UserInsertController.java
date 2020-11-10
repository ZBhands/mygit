package com.zhangbo.controller;

import com.zhangbo.pojo.User;
import com.zhangbo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insert")
public class UserInsertController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPass(pass);
        user.setGender(gender);
        user.setEmail(email);

        UserServiceImpl userService = new UserServiceImpl();
        Boolean update = userService.insert(user);

        if (update){
            resp.sendRedirect("/findAll");
        }
    }
}