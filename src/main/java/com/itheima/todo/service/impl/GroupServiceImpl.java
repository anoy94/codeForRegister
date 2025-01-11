package com.itheima.todo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.todo.mapper.UserMapper;
import com.itheima.todo.pojo.groupspojo.GroupsGetResult;
import com.itheima.todo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    UserMapper userMapper;
    ObjectMapper objectMapper=new ObjectMapper();
    @Override
    public GroupsGetResult groupsget(String account) throws JsonProcessingException {
        GroupsGetResult groupsGetResult=new GroupsGetResult();
        groupsGetResult.setData(objectMapper.readValue(userMapper.selectgroups(account),new TypeReference<String[]>() {}));
        groupsGetResult.setCode(200);
        groupsGetResult.setStatus("success");
        return groupsGetResult;
    }
}
