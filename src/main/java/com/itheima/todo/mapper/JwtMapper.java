package com.itheima.todo.mapper;

import com.itheima.todo.pojo.TokenCheck;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JwtMapper {
    void tokenadd(TokenCheck tokencheck);
    void tokendel(TokenCheck tokencheck);
    Integer tokensel(TokenCheck tokencheck);
}
