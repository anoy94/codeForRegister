package com.itheima.todo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.todo.Mapper.UsersMapper;
import com.itheima.todo.pojo.groupspojo.GroupsGetResult;
import com.itheima.todo.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupsServiceImpl implements GroupsService {
    @Autowired
    UsersMapper usersMapper;
    ObjectMapper objectMapper=new ObjectMapper();
    @Override
    public GroupsGetResult groupsget(String account) throws JsonProcessingException {
        GroupsGetResult groupsGetResult=new GroupsGetResult();
        groupsGetResult.setData(objectMapper.readValue(usersMapper.selectgroups(account),new TypeReference<String[]>() {}));
        groupsGetResult.setCode(200);
        groupsGetResult.setStatus("success");
        return groupsGetResult;
    }
}
