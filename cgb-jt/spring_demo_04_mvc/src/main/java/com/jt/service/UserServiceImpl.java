package com.jt.service;

import com.jt.Dao.UserDao;
import com.jt.pojo.User;

public class UserServiceImpl implements UserService{

    private UserDao userdao;//基于spring注入dao,  面向接口编程

    public void setUserdao(UserDao userdao){
        this.userdao=userdao;
    }
    @Override
    public void addUser(User user) {

    }
}
