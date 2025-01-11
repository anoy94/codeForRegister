package com.itheima.todo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itheima.todo.pojo.*;
import com.itheima.todo.service.JwtService;
import com.itheima.todo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;
    @PostMapping("/api/user/register")
    ResultReg register(@RequestBody LoginRequest loginReq) throws JsonProcessingException {
        ResultReg reg = userService.register(loginReq.getAccount(),loginReq.getPwd(),loginReq.getBasicInfo());
        log.info("register ok");
        return reg;
    }
    @PostMapping("/api/user/login")
    ResultLog login(@RequestBody LoginRequest loginReq) throws JsonProcessingException {
        ResultLog logi= userService.login(loginReq.getAccount(),loginReq.getPwd());
        return logi;
    }

    @PostMapping("/api/user/logout")
    ResultLogout logout(@RequestBody LogoutRequest logoutReq){
        ResultLogout logo = userService.logout(logoutReq.getToken());
        return logo;

    }
//    @PostMapping("/api/user/basicinfos")
//    void basicinfos(@RequestBody loginRequest loginReq){
//        resultInfo info =  usersService.
//
//    }
}
