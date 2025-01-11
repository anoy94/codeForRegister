package com.itheima.todo.pojo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    String account;
    String pwd;
    BasicInfo basicInfo;
}
