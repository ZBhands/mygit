package com.zhangbo.service.impl;

import com.sun.glass.ui.Menu;
import com.zhangbo.dao.impl.UserDaoImpl;
import com.zhangbo.pojo.User;
import com.zhangbo.service.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAll() {
        //去dao层调用方法 进行查找
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.findAll();
    }

    @Override
    public User findById(Integer id) {

        UserDaoImpl userDao = new UserDaoImpl();
        User byId = userDao.findById(id);
        return byId;
    }

    @Override
    public Boolean update(User user) {
        UserDaoImpl userDao = new UserDaoImpl();

        return userDao.update(user);
    }

    @Override
    public Boolean deleteById(Integer id) {
        UserDaoImpl userDao = new UserDaoImpl();

        return userDao.deleteById(id);
    }

    @Override
    public Boolean insert(User user) {
        UserDaoImpl userDao = new UserDaoImpl();

        return userDao.insert(user);
    }
}
