package com.lc.service;

import com.lc.model.User;

import java.util.List;

public interface UserService {
    public int insertUser(User user);

    public List<User> getUsers();
}
