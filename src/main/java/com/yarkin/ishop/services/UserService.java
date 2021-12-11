package com.yarkin.ishop.services;

import com.yarkin.ishop.dao.UserDao;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
}
