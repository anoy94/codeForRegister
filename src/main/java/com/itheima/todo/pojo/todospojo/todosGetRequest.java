package com.itheima.todo.pojo.todospojo;

import lombok.Data;

@Data
public class todosGetRequest {
    Integer page;
    Integer pageNum;
    Filter filter;
    String token;

}
