package com.itheima.todo.pojo.groupspojo;

import lombok.Data;

@Data
public class GroupsGetResult {
    Integer code=255;
    String status="fail";
    String[] data;
}
