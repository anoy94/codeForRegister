package com.itheima.todo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itheima.todo.pojo.groupspojo.GroupsGetResult;
import com.itheima.todo.pojo.tokenCheck;
import com.itheima.todo.service.GroupsService;
import com.itheima.todo.service.UsersService;
import com.itheima.todo.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GroupsController {
    @Autowired
    GroupsService groupsService;
    @PostMapping("api/group/get/joined")
    GroupsGetResult getgroups(@RequestBody String token) throws JsonProcessingException {
        tokenCheck tok = new tokenCheck();
        tok.setAccount(JwtUtils.parseJWT(token).get("account", String.class));
        GroupsGetResult groupsGetResult=groupsService.groupsget(tok.getAccount());
        return groupsGetResult;
    }

}
