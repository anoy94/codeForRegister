package com.itheima.todo.pojo.todospojo;

import lombok.Data;

@Data
public class Filter {
    Boolean enable=Boolean.FALSE;
    String title;
    String[] tags;
    Boolean tagMode=Boolean.FALSE;
    Boolean sortByStatus=Boolean.FALSE;
}
