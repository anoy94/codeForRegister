package com.itheima.todo.service;

import com.itheima.todo.pojo.tokenCheck;

public interface JwtsService {
    void tokenadd(tokenCheck tokencheck);
     void tokendel(tokenCheck tokencheck);
     Integer tokensel(tokenCheck tokencheck);
}
