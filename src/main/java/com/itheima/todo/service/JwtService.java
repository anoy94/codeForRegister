package com.itheima.todo.service;

import com.itheima.todo.pojo.TokenCheck;

public interface JwtService {
    void tokenadd(TokenCheck tokencheck);
     void tokendel(TokenCheck tokencheck);
     Integer tokensel(TokenCheck tokencheck);
}
