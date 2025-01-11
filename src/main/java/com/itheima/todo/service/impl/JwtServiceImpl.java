package com.itheima.todo.service.impl;

import com.itheima.todo.mapper.JwtMapper;
import com.itheima.todo.pojo.TokenCheck;
import com.itheima.todo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {
    @Autowired
    JwtMapper jwtMapper;
    @Override
    public void tokenadd(TokenCheck tokencheck) {
        jwtMapper.tokenadd(tokencheck);
    }

    @Override
    public void tokendel(TokenCheck tokencheck) {
        jwtMapper.tokendel(tokencheck);
    }

    public Integer tokensel(TokenCheck tokencheck) {
        Integer tokenNum= jwtMapper.tokensel(tokencheck);
        return tokenNum;
    }
}
