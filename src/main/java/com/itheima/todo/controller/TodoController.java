package com.itheima.todo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itheima.todo.pojo.todospojo.*;
import com.itheima.todo.pojo.TokenCheck;
import com.itheima.todo.service.TodoService;
import com.itheima.todo.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController

public class TodoController {
    @Autowired
    private TodoService todoService;
    @PostMapping("/api/todos/get/user")
    todosGet getTodos(@RequestBody todosGetRequest todosGetRequest) throws JsonProcessingException {
        String jwt=todosGetRequest.getToken();
        TokenCheck tok = new TokenCheck();
        tok.setAccount(JwtUtils.parseJWT(jwt).get("account", String.class));
        todosGet todosget= todoService.gettodos(tok.getAccount(),todosGetRequest.getPage(),todosGetRequest.getPageNum(),todosGetRequest.getFilter());
        return todosget;
    }
    @PostMapping("api/todos/update/user")
    UpdateTodosResult updateTodos(@RequestBody todosUpdateRequest todosUpdateRequest) throws JsonProcessingException {
        String jwt=todosUpdateRequest.getToken();
        TokenCheck tok = new TokenCheck();
        tok.setAccount(JwtUtils.parseJWT(jwt).get("account", String.class));
        UpdateTodosResult updateTodosResult= todoService.updatetodos(tok.getAccount(),todosUpdateRequest.getId(),todosUpdateRequest.getUpdater());
        return updateTodosResult;

    }
    @PostMapping("api/todo/add/user")
    AddTodosResult addTodos(@RequestBody todosAddRequest todosAddRequest) throws JsonProcessingException {
        String jwt=todosAddRequest.getToken();
        TokenCheck tok = new TokenCheck();
        tok.setAccount(JwtUtils.parseJWT(jwt).get("account", String.class));
        AddTodosResult addTodosResult= todoService.addtodos(todosAddRequest.getTodo(),tok.getAccount());
        return  addTodosResult;
    }
    @PostMapping("api/todo/delete/user")
    DeleteTodoResult deleteTodos(@RequestBody todosDeleteRequest todosDeleteRequest){
        String jwt=todosDeleteRequest.getToken();
        TokenCheck tok = new TokenCheck();
        tok.setAccount(JwtUtils.parseJWT(jwt).get("account", String.class));
        DeleteTodoResult deleteTodoResult= todoService.deletetodos(todosDeleteRequest.getId(),tok.getAccount());
        return  deleteTodoResult;
    }
    @PostMapping("api/todo/get/user")
    todoGet getTodo(@RequestBody todosDeleteRequest todosDeleteRequest) throws JsonProcessingException {
        String jwt=todosDeleteRequest.getToken();
        TokenCheck tok = new TokenCheck();
        tok.setAccount(JwtUtils.parseJWT(jwt).get("account", String.class));
        todoGet todoGet= todoService.gettodo(todosDeleteRequest.getId(),tok.getAccount());
        return  todoGet;
    }



}