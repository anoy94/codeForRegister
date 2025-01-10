package com.itheima.todo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Results {
    Integer code;
    String state;
    Object body;
    public static Results error(String msg) {
        return new Results(0, msg, null);
    }
}
