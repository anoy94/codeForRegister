package com.itheima.todo.pojo.todospojo;

import lombok.Data;

@Data
public class AddTodosResult {
    Integer code=255;
    String status="fail";
    Integer data;
}
