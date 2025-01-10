package com.itheima.todo.pojo.todospojo;

import lombok.Data;

@Data
public class updater {
    String title;
    String content;
    String brief;
    String status;
    String type;
    String tages;
    String[] tags;
    repeatOption repeatOption;
    resetOption resetOption;
    notificationOption notificationOption;
}
