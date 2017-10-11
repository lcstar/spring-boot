package com.lc.demo.service;

import com.lc.demo.model.User;

import java.util.List;

public interface UserService {
    public int insertUser(String name, String password);

    public List<User> getUsers();
}
