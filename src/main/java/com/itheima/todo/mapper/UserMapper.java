package com.itheima.todo.mapper;

import com.itheima.todo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public Integer register(User users);
    Integer login(User users);
    User selectByuser(User users);

    void insert(User users);
    String selectgroups(String account);
}
