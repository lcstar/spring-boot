package com.lc.service.impl;

import com.lc.mapper.UserMapper;
import com.lc.model.User;
import com.lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int insertUser(User user) {
       //return userMapper.insertUser(name,password);
        return userMapper.insert(user);
    }

    @Override
    public List<User> getUsers() {
        //return userMapper.getUsers();
        return null;
    }
}
