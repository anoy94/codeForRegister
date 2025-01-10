package com.itheima.todo.pojo.todospojo;

import lombok.Data;

@Data
public class todos {
    String id;
    String title;
    String content;
    String brief;
    String status;
    String type;
    String[] tags;
    repeatOption repeatOption;
    resetOption resetOption;
    Origin origin;
    notificationOption notificationOption;
}
