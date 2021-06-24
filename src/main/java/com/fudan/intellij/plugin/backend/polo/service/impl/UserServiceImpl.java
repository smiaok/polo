package com.fudan.intellij.plugin.backend.polo.service.impl;

import com.fudan.intellij.plugin.backend.polo.dao.UserDao;
import com.fudan.intellij.plugin.backend.polo.entity.User;
import com.fudan.intellij.plugin.backend.polo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao userDao;

    @Override
    public boolean checkUser(String username,String password){
        return userDao.verifyUser(username,password) != null;
    }

    @Override
    public boolean register(String username,String password,String email,String phone){
        return userDao.insertUser(username,password,email,phone) == 1;
    }

    @Override
    public User getUser(String username){
        return userDao.findUserbyName(username);
    }

    @Override
    public List<User> getAllUser(){
        return userDao.findUser();
    }
}
