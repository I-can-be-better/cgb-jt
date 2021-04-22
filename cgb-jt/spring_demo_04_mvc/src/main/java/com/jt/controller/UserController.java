package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;

public class UserController {
    private UserService userService;
    private User user;

    public void addUser(){
        userService.addUser(user);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
