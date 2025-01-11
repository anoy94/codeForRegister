package com.itheima.todo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.todo.mapper.UserMapper;
import com.itheima.todo.pojo.*;
import com.itheima.todo.service.JwtService;
import com.itheima.todo.service.UserService;
import com.itheima.todo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtService jwtService;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    static{
        objectMapper.findAndRegisterModules();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }
    @Override
    public ResultReg register(String account, String pwd, BasicInfo basicInfo) throws JsonProcessingException {

        User users=new User();
        users.setAccount(account);
        users.setPwd(pwd);
        String basicInfoJson= objectMapper.writeValueAsString(basicInfo);
        users.setBasicInfo(basicInfoJson);
        Integer num= userMapper.register(users);
        ResultReg reg = new ResultReg();
        reg.setCode(201);
        reg.setStatus("fail");
        if(num==1){
            return reg;
        }
        Object[] B = new Object[0];
        users.setGroups(objectMapper.writeValueAsString(B));
        userMapper.insert(users);
        reg.setCode(200);
        reg.setStatus("success");
        return reg;
    }
    @Override
    public ResultLog login(String account, String pwd) throws JsonProcessingException {
        ResultLog logi=new ResultLog();
        logi.setCode(201);
        logi.setStatus("用户名或密码错误");
        User users=new User();
        users.setAccount(account);
        users.setPwd(pwd);
        Integer num= userMapper.login(users);
        if(num==0){
            return logi;
        }
        User back= userMapper.selectByuser(users);
        Map<String,Object> claims= new HashMap<>();
        claims.put("account",account);
        claims.put("iat", new Date().getTime() / 1000);
        String jwt= JwtUtils.generateJwt(claims);
        TokenCheck tokencheck=new TokenCheck();
        tokencheck.setAccount(account);
        tokencheck.setToken(jwt);
        jwtService.tokenadd(tokencheck);
        Data dataLog = new Data();
        dataLog.setToken(jwt);
        logi.setCode(200);
        logi.setStatus("success");
        BasicInfo basicInfo = objectMapper.readValue(back.getBasicInfo(), BasicInfo.class);
        dataLog.setBasicInfo(basicInfo);
        logi.setData(dataLog);
        return logi;
    }
    @Override
    public ResultLogout logout(String token){
        ResultLogout re_Logout = new ResultLogout();
        re_Logout.setCode(255);
        re_Logout.setStatus("fail");
        TokenCheck tokencheck=new TokenCheck();
        tokencheck.setToken(token);
        Integer num= jwtService.tokensel(tokencheck);
        if (num==1){
            jwtService.tokendel(tokencheck);
            re_Logout.setCode(200);
            re_Logout.setStatus("success");
            return re_Logout;
        }
        return re_Logout;
    }
//    @Override
//    public resultInfo basicinfos(String token, String[] accounts){
//        resultInfo resultInfo= new resultInfo();
//        resultInfo.setCode(255);
//        resultInfo.setStatus("fail");
//        tokenCheck tokencheck=new tokenCheck();
//        tokencheck.setToken(token);
//        Integer num=jwtsService.tokensel(tokencheck);
//        if(num==1){
//            resultInfo.setData(usersMapper.);
//        }
//        return resultInfo;
//    }
}