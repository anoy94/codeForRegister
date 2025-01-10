package com.itheima.todo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itheima.todo.pojo.*;
import com.itheima.todo.service.JwtsService;
import com.itheima.todo.service.UsersService;
import com.itheima.todo.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private JwtsService jwtsService;
    @PostMapping("/api/user/register")
    resultReg register(@RequestBody loginRequest loginReq) throws JsonProcessingException {
        resultReg reg =usersService.register(loginReq.getAccount(),loginReq.getPwd(),loginReq.getBasicInfo());
        log.info("register ok");
        return reg;
    }
    @PostMapping("/api/user/login")
    resultLog login(@RequestBody loginRequest loginReq) throws JsonProcessingException {
        resultLog logi=usersService.login(loginReq.getAccount(),loginReq.getPwd());
        return logi;
    }

    @PostMapping("/api/user/logout")
    resultLogout logout(@RequestBody logoutRequest logoutReq){
        resultLogout logo = usersService.logout(logoutReq.getToken());
        return logo;

    }
//    @PostMapping("/api/user/basicinfos")
//    void basicinfos(@RequestBody loginRequest loginReq){
//        resultInfo info =  usersService.
//
//    }
}
