package com.itheima.todo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itheima.todo.pojo.todospojo.*;

public interface TodosService {
    todosGet gettodos(String account, Integer page, Integer pageNum, Filter filter) throws JsonProcessingException;
    UpdateTodosResult updatetodos(String account, Integer id, updater updater) throws JsonProcessingException;
    AddTodosResult addtodos(todos todo, String account) throws JsonProcessingException;
    DeleteTodoResult deletetodos(Integer id,String account);
    todoGet gettodo(Integer id,String account) throws JsonProcessingException;
}
