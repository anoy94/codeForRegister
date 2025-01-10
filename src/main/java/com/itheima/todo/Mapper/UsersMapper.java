package com.itheima.todo.Mapper;

import com.itheima.todo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper{
    public Integer register(User users);
    Integer login(User users);
    User selectByuser(User users);

    void insert(User users);
    String selectgroups(String account);
}
