package com.itheima.todo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itheima.todo.pojo.groupspojo.GroupsGetResult;
import com.itheima.todo.pojo.TokenCheck;
import com.itheima.todo.service.GroupService;
import com.itheima.todo.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GroupController {
    @Autowired
    GroupService groupService;
    @PostMapping("api/group/get/joined")
    GroupsGetResult getGroups(@RequestBody String token) throws JsonProcessingException {
        TokenCheck tok = new TokenCheck();
        tok.setAccount(JwtUtils.parseJWT(token).get("account", String.class));
        GroupsGetResult groupsGetResult= groupService.groupsget(tok.getAccount());
        return groupsGetResult;
    }

}
