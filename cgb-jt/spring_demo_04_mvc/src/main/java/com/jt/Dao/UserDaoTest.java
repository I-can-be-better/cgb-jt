package com.jt.Dao;

import com.jt.pojo.User;


public class UserDaoTest implements UserDao {

    @Override
    public void addUser(User user) {
        System.out.println("添加用户"+user);
    }
}