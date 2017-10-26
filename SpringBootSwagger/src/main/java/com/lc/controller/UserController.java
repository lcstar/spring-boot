package com.lc.controller;

import com.lc.model.User;
import com.lc.service.UserService;
import com.lc.utils.ReturnMessage;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
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

    @ApiOperation(value="获取用户列表", notes="")
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
