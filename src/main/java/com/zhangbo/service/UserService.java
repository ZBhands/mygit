package com.zhangbo.service;

import com.zhangbo.pojo.User;

import java.util.List;


public interface UserService {

    List<User> findAll();

    User findById(Integer id);

    Boolean update(User user);

    Boolean deleteById(Integer id);

    Boolean insert(User user);
}
