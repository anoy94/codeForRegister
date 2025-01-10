package com.itheima.todo.pojo.todospojo;

import lombok.Data;

@Data
public class todoGet {
    Integer code=255;
    String status="fail";
    todos data;

}
