package com.itheima.todo.pojo.todospojo;

import lombok.Data;

@Data
public class MapRequestForAdd {
    Integer id;
    String account;
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
