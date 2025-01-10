package com.itheima.todo.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User{
    String account;
    String pwd;
    String basicInfo;
    String groups;
    String permission;
}