package com.zhangbo.controller;

import com.zhangbo.pojo.User;
import com.zhangbo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/findById")
public class UserFindByIdController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("id"));

        UserServiceImpl userService = new UserServiceImpl();

        User user =  userService.findById(id);

        req.setAttribute("user",user);
        req.getRequestDispatcher("/update.jsp").forward(req,resp);

    }
}
