package com.itheima.todo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itheima.todo.pojo.*;

import java.util.List;

public interface UsersService {


    resultLog login(String account, String pwd) throws JsonProcessingException;

    resultReg register(String account, String pwd, BasicInfo basicInfo) throws JsonProcessingException;

    resultLogout logout(String token);

//    resultInfo basicinfos(String token, String[] accounts);
}
