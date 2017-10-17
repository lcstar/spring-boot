package com.lc.controller;

import com.lc.model.User;
import com.lc.service.UserService;
import com.lc.utils.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            userService.insertUser(user);
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


    @PutMapping()
    public ReturnMessage getUser(@RequestBody User user){
        ReturnMessage message = new ReturnMessage();
        List<User> users = userService.getUser(user);
        message.setCode(0);
        message.setInfo("sucess");
        message.setMess(users);
        return message;

    }

}
