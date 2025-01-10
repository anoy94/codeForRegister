package com.itheima.todo.pojo.todospojo;

import lombok.Data;

@Data
public class todosUpdateRequest {
    String token;
    updater updater;
    Integer id;

}
