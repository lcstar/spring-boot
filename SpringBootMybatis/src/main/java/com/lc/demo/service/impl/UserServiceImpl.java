package com.lc.demo.service.impl;

import com.lc.demo.mapper.UserMapper;
import com.lc.demo.model.User;
import com.lc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int insertUser(String name, String password) {
       return userMapper.insertUser(name,password);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }
}
