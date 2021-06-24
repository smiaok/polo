package com.fudan.intellij.plugin.backend.polo.service;

import com.fudan.intellij.plugin.backend.polo.entity.User;

import java.util.List;

public interface IUserService {

    boolean checkUser(String username,String password);

    boolean register(String username,String password,String email,String phone);

    User getUser(String username);

    List<User> getAllUser();
}
