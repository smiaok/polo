package com.fudan.intellij.plugin.backend.polo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.fudan.intellij.plugin.backend.polo.common.CommonResult;
import com.fudan.intellij.plugin.backend.polo.entity.User;
import com.fudan.intellij.plugin.backend.polo.service.IUserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value ="/ping",method = RequestMethod.POST)
    public CommonResult<Object> ping() {
        return CommonResult.success();

    }

    @RequestMapping(value ="/login",method = RequestMethod.POST)
    public CommonResult<Object> login(String username, String password) {

        if(userService.checkUser(username,password)) {
            StpUtil.setLoginId(username);
            return CommonResult.success();
        }
        return CommonResult.failed();

    }

    @SaCheckLogin
    @RequestMapping(value ="/logout",method = RequestMethod.POST)
    public CommonResult<Boolean> logout() {
        StpUtil.logout();
        if(StpUtil.isLogin()){
            return CommonResult.success(false);
        }
        return CommonResult.success(true);
    }

    @SaCheckLogin
    @RequestMapping(value = "/userInfo",method = RequestMethod.POST)
    public CommonResult<User> info(String username) {
        User user =  userService.getUser(username);
        return CommonResult.success(user);
    }

    @RequestMapping(value = "/isLogin")
    public CommonResult<Boolean> isLogin() {
        if(StpUtil.isLogin()){
            return CommonResult.success(true);
        }
        return CommonResult.success(false);
    }

    @RequestMapping(value ="/register",method = RequestMethod.POST)
    public CommonResult<Boolean> register(String username, String password, String email,String phone){
        if(userService.register(username,password,email,phone)){
            return CommonResult.success(true);
        }
        return CommonResult.success(false);
    }

    @SaCheckLogin
    @RequestMapping(value = "/getAllUser",method = RequestMethod.POST)
    public CommonResult<List<User>> getAllUser() {
        return CommonResult.success(userService.getAllUser());
    }


}
