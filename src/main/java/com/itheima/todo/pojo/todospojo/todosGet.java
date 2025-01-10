package com.itheima.todo.pojo.todospojo;

import lombok.Data;

@Data
public class todosGet {
    Integer code=255;
    String status="fail";
    TodosData data;
}
