package com.itheima.todo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itheima.todo.pojo.*;

public interface UserService {


    ResultLog login(String account, String pwd) throws JsonProcessingException;

    ResultReg register(String account, String pwd, BasicInfo basicInfo) throws JsonProcessingException;

    ResultLogout logout(String token);

//    resultInfo basicinfos(String token, String[] accounts);
}
