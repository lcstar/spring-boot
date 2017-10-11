package com.lc.demo.controller;

import com.lc.demo.model.User;
import com.lc.demo.service.UserService;
import com.lc.demo.utils.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ReturnMessage insertUser(@RequestBody User user){
        ReturnMessage message = new ReturnMessage();
        try {
            userService.insertUser(user.getName(),user.getPassword());
            message.setCode(0);
            message.setInfo("sucess");
        }catch (Exception e){
            e.printStackTrace();
            message.setCode(1);
            message.setInfo("failed");
        }
        return message;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ReturnMessage getUsers(){
        ReturnMessage message = new ReturnMessage();
        try {
            List<User> users = userService.getUsers();
            message.setCode(0);
            message.setInfo("sucess");
            message.setMess(users);
        }catch (Exception e){
            e.printStackTrace();
            message.setCode(1);
            message.setInfo("failed");
        }
        return message;
    }
}
