package com.lc.controller;

import com.lc.mapper.UserMapper;
import com.lc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lc
 * createTime 2019/4/29.
 */
@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Secured("ROLE_ADMIN")
    @GetMapping
    public List<User> getUsers(){
        return userMapper.selectAll();
    }
}
