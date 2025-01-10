package com.itheima.todo.pojo.todospojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class TodosDataJson {
    TodosJson[] todosjson;
    Integer total;
    public TodosData jsontodata() throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        TodosData todosData= new TodosData();
        todos[] todosfordata= new todos[todosjson.length];
        for (int i=0;i<todosjson.length;i+=1){
            todosfordata[i] = new todos();
            todosfordata[i].id=this.todosjson[i].id;
            todosfordata[i].title=this.todosjson[i].title;
            todosfordata[i].content=this.todosjson[i].content;
            todosfordata[i].brief=this.todosjson[i].brief;
            todosfordata[i].status=this.todosjson[i].status;
            todosfordata[i].type=this.todosjson[i].type;
            todosfordata[i].resetOption=objectMapper.readValue(this.todosjson[i].resetOption,resetOption.class);
            todosfordata[i].repeatOption=objectMapper.readValue(this.todosjson[i].repeatOption,repeatOption.class);
            todosfordata[i].tags=objectMapper.readValue(this.todosjson[i].tags, new TypeReference<String[]>() {});
            todosfordata[i].origin=objectMapper.readValue(this.todosjson[i].origin,Origin.class);
            todosfordata[i].notificationOption =objectMapper.readValue(this.todosjson[i].notificationOption, notificationOption.class);
        }
        todosData.setTodos(todosfordata);
        todosData.setTotal(this.total);
        return todosData;
    }
}
