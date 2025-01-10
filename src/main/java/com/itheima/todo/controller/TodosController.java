package com.itheima.todo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itheima.todo.pojo.resultReg;
import com.itheima.todo.pojo.todospojo.*;
import com.itheima.todo.pojo.tokenCheck;
import com.itheima.todo.service.TodosService;
import com.itheima.todo.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController

public class TodosController {
    @Autowired
    private TodosService todosService;
    @PostMapping("/api/todos/get/user")
    todosGet gettodos(@RequestBody todosGetRequest todosGetRequest) throws JsonProcessingException {
        String jwt=todosGetRequest.getToken();
        tokenCheck tok = new tokenCheck();
        tok.setAccount(JwtUtils.parseJWT(jwt).get("account", String.class));
        todosGet todosget=todosService.gettodos(tok.getAccount(),todosGetRequest.getPage(),todosGetRequest.getPageNum(),todosGetRequest.getFilter());
        return todosget;
    }
    @PostMapping("api/todos/update/user")
    UpdateTodosResult updatetodos(@RequestBody todosUpdateRequest todosUpdateRequest) throws JsonProcessingException {
        String jwt=todosUpdateRequest.getToken();
        tokenCheck tok = new tokenCheck();
        tok.setAccount(JwtUtils.parseJWT(jwt).get("account", String.class));
        UpdateTodosResult updateTodosResult=todosService.updatetodos(tok.getAccount(),todosUpdateRequest.getId(),todosUpdateRequest.getUpdater());
        return updateTodosResult;

    }
    @PostMapping("api/todo/add/user")
    AddTodosResult addtodos(@RequestBody todosAddRequest todosAddRequest) throws JsonProcessingException {
        String jwt=todosAddRequest.getToken();
        tokenCheck tok = new tokenCheck();
        tok.setAccount(JwtUtils.parseJWT(jwt).get("account", String.class));
        AddTodosResult addTodosResult=todosService.addtodos(todosAddRequest.getTodo(),tok.getAccount());
        return  addTodosResult;
    }
    @PostMapping("api/todo/delete/user")
    DeleteTodoResult deletetodos(@RequestBody todosDeleteRequest todosDeleteRequest){
        String jwt=todosDeleteRequest.getToken();
        tokenCheck tok = new tokenCheck();
        tok.setAccount(JwtUtils.parseJWT(jwt).get("account", String.class));
        DeleteTodoResult deleteTodoResult= todosService.deletetodos(todosDeleteRequest.getId(),tok.getAccount());
        return  deleteTodoResult;
    }
    @PostMapping("api/todo/get/user")
    todoGet gettodo(@RequestBody todosDeleteRequest todosDeleteRequest) throws JsonProcessingException {
        String jwt=todosDeleteRequest.getToken();
        tokenCheck tok = new tokenCheck();
        tok.setAccount(JwtUtils.parseJWT(jwt).get("account", String.class));
        todoGet todoGet= todosService.gettodo(todosDeleteRequest.getId(),tok.getAccount());
        return  todoGet;
    }



}