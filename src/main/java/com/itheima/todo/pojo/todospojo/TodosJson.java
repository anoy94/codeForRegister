package com.itheima.todo.pojo.todospojo;

import lombok.Data;
@Data
public class TodosJson {
    String id;
    String title;
    String content;
    String brief;
    String status;
    String type;
    String tags;
    String repeatOption;
    String resetOption;
    String origin;
    String notificationOption;
}
