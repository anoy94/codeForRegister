package com.itheima.todo.Mapper;

import com.itheima.todo.pojo.tokenCheck;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JwtsMapper {
    void tokenadd(tokenCheck tokencheck);
    void tokendel(tokenCheck tokencheck);
    Integer tokensel(tokenCheck tokencheck);
}
