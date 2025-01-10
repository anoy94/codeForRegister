package com.itheima.todo.service.impl;

import com.itheima.todo.Mapper.JwtsMapper;
import com.itheima.todo.pojo.tokenCheck;
import com.itheima.todo.service.JwtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtsServiceImpl implements JwtsService {
    @Autowired
    JwtsMapper jwtsMapper;
    @Override
    public void tokenadd(tokenCheck tokencheck) {
        jwtsMapper.tokenadd(tokencheck);
    }

    @Override
    public void tokendel(tokenCheck tokencheck) {
        jwtsMapper.tokendel(tokencheck);
    }

    public Integer tokensel(tokenCheck tokencheck) {
        Integer tokenNum=jwtsMapper.tokensel(tokencheck);
        return tokenNum;
    }
}
