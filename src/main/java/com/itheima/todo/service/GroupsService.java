package com.itheima.todo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itheima.todo.pojo.groupspojo.GroupsGetResult;

public interface GroupsService {
    GroupsGetResult groupsget(String account) throws JsonProcessingException;
}
