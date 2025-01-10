package com.itheima.todo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.todo.Mapper.TodosMapper;
import com.itheima.todo.pojo.todospojo.*;
import com.itheima.todo.service.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TodosServiceImpl implements TodosService {
    @Autowired
    private TodosMapper todosMapper;

    @Override
    public todosGet gettodos(String account, Integer page, Integer pageNum, Filter filter) throws JsonProcessingException {
        todosGet todosget=new todosGet();
        if(filter.getEnable()){
            TodosDataJson todosDataJson=new TodosDataJson();
            todosDataJson.setTodosjson(todosMapper.select(account, page, pageNum).toArray(new TodosJson[0]));

            ObjectMapper objectMapper=new ObjectMapper();
            TodosData todosData= new TodosData();
            todos[] todosfordata= new todos[todosDataJson.getTodosjson().length];
            for (int i=0;i<todosDataJson.getTodosjson().length;i++){
                todosfordata[i] = new todos();
                todosfordata[i].setId(todosDataJson.getTodosjson()[i].getId());
                todosfordata[i].setTitle(todosDataJson.getTodosjson()[i].getTitle());
                todosfordata[i].setContent(todosDataJson.getTodosjson()[i].getContent());
                todosfordata[i].setBrief(todosDataJson.getTodosjson()[i].getBrief());
                todosfordata[i].setStatus(todosDataJson.getTodosjson()[i].getStatus());
                todosfordata[i].setType(todosDataJson.getTodosjson()[i].getType());
                todosfordata[i].setResetOption(objectMapper.readValue(todosDataJson.getTodosjson()[i].getResetOption(),resetOption.class));
                todosfordata[i].setRepeatOption(objectMapper.readValue(todosDataJson.getTodosjson()[i].getRepeatOption(),repeatOption.class));
                todosfordata[i].setTags(objectMapper.readValue(todosDataJson.getTodosjson()[i].getTags(),new TypeReference<String[]>() {}));
                todosfordata[i].setOrigin(objectMapper.readValue(todosDataJson.getTodosjson()[i].getOrigin(),Origin.class));
                todosfordata[i].setNotificationOption(objectMapper.readValue(todosDataJson.getTodosjson()[i].getNotificationOption(), notificationOption.class));
            }
            todosData.setTodos(todosfordata);
            todosData.setTotal(todosDataJson.getTodosjson().length);

            todosget.setData(todosData);
        }
        else {
            TodosDataJson todosDataJson = new TodosDataJson();
            todosDataJson.setTodosjson(todosMapper.selectall(account).toArray(new TodosJson[0]));

            ObjectMapper objectMapper=new ObjectMapper();
            TodosData todosData= new TodosData();
            todos[] todosfordata= new todos[todosDataJson.getTodosjson().length];
            for (int i=0;i<todosDataJson.getTodosjson().length;i++){
                todosfordata[i] = new todos();
                todosfordata[i].setId(todosDataJson.getTodosjson()[i].getId());
                todosfordata[i].setTitle(todosDataJson.getTodosjson()[i].getTitle());
                todosfordata[i].setContent(todosDataJson.getTodosjson()[i].getContent());
                todosfordata[i].setBrief(todosDataJson.getTodosjson()[i].getBrief());
                todosfordata[i].setStatus(todosDataJson.getTodosjson()[i].getStatus());
                todosfordata[i].setType(todosDataJson.getTodosjson()[i].getType());
                todosfordata[i].setResetOption(objectMapper.readValue(todosDataJson.getTodosjson()[i].getResetOption(),resetOption.class));
                todosfordata[i].setRepeatOption(objectMapper.readValue(todosDataJson.getTodosjson()[i].getRepeatOption(),repeatOption.class));
                todosfordata[i].setTags(objectMapper.readValue(todosDataJson.getTodosjson()[i].getTags(),new TypeReference<String[]>() {}));
                todosfordata[i].setOrigin(objectMapper.readValue(todosDataJson.getTodosjson()[i].getOrigin(),Origin.class));
                todosfordata[i].setNotificationOption(objectMapper.readValue(todosDataJson.getTodosjson()[i].getNotificationOption(), notificationOption.class));
            }
            todosData.setTodos(todosfordata);
            todosData.setTotal(todosDataJson.getTodosjson().length);

            todosget.setData(todosData);
        }
        todosget.setCode(200);
        todosget.setStatus("success");
        return todosget;
    }
    @Override
    public UpdateTodosResult updatetodos(String account, Integer id, updater updater) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        todosMapper.update(account, id,updater.getTitle(),updater.getContent(),updater.getBrief(),updater.getStatus(),updater.getType(),objectMapper.writeValueAsString(updater.getTags()) ,objectMapper.writeValueAsString(updater.getRepeatOption()) ,objectMapper.writeValueAsString(updater.getResetOption()) ,objectMapper.writeValueAsString(updater.getNotificationOption()) );
        UpdateTodosResult updateTodosResult =new UpdateTodosResult();
        updateTodosResult.setCode(200);
        updateTodosResult.setStatus("success");
        return  updateTodosResult;

    };
    @Override
    public  AddTodosResult addtodos(todos todo,String account) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
//        todosMapper.add(account,todo.getTitle(),todo.getContent(),todo.getBrief(),todo.getStatus(),todo.getType(),objectMapper.writeValueAsString(todo.getTags()) ,objectMapper.writeValueAsString(todo.getRepeatOption()) ,objectMapper.writeValueAsString(todo.getResetOption()) ,objectMapper.writeValueAsString(todo.getOrigin()), objectMapper.writeValueAsString(todo.getNotificationOption()) ,idret);
        MapRequestForAdd mapRequestForAdd=new MapRequestForAdd();
        mapRequestForAdd.setTitle(todo.getTitle());
        mapRequestForAdd.setAccount(account);
        mapRequestForAdd.setContent(todo.getContent());
        mapRequestForAdd.setBrief(todo.getBrief());
        mapRequestForAdd.setStatus(todo.getStatus());
        mapRequestForAdd.setType(todo.getType());
        mapRequestForAdd.setTags(objectMapper.writeValueAsString(todo.getTags()));
        mapRequestForAdd.setRepeatOption(objectMapper.writeValueAsString(todo.getRepeatOption()));
        mapRequestForAdd.setResetOption(objectMapper.writeValueAsString(todo.getResetOption()));
        mapRequestForAdd.setOrigin(objectMapper.writeValueAsString(todo.getOrigin()));
        mapRequestForAdd.setNotificationOption(objectMapper.writeValueAsString(todo.getNotificationOption()));
        todosMapper.add(mapRequestForAdd);
        AddTodosResult addTodosResult=new AddTodosResult();
        addTodosResult.setCode(200);
        addTodosResult.setStatus("success");
        addTodosResult.setData(mapRequestForAdd.getId());
        return addTodosResult;
    }

    @Override
    public DeleteTodoResult deletetodos(Integer id, String account) {
        DeleteTodoResult deleteTodoResult=new DeleteTodoResult();
        MapRequestForDelete mapRequestForDelete=new MapRequestForDelete();
        mapRequestForDelete.setAccount(account);
        mapRequestForDelete.setId(id);
        todosMapper.delete(mapRequestForDelete);
        deleteTodoResult.setStatus("success");
        deleteTodoResult.setCode(200);
        return deleteTodoResult;
    }

    @Override
    public todoGet gettodo(Integer id, String account) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        todoGet todoGet=new todoGet();
        TodosJson todosJson=todosMapper.selectOne(id, account);
        todos todosfordata = new todos();
        todosfordata.setId(todosJson.getId());
        todosfordata.setTitle(todosJson.getTitle());
        todosfordata.setContent(todosJson.getContent());
        todosfordata.setBrief(todosJson.getBrief());
        todosfordata.setStatus(todosJson.getStatus());
        todosfordata.setType(todosJson.getType());
        todosfordata.setTags(objectMapper.readValue(todosJson.getTags(),new TypeReference<String[]>() {}));
        todosfordata.setRepeatOption(objectMapper.readValue(todosJson.getRepeatOption(),repeatOption.class));
        todosfordata.setResetOption(objectMapper.readValue(todosJson.getResetOption(),resetOption.class));
        todosfordata.setOrigin(objectMapper.readValue(todosJson.getOrigin(),Origin.class));
        todosfordata.setNotificationOption(objectMapper.readValue(todosJson.getNotificationOption(),notificationOption.class));
        todoGet.setData(todosfordata);
        todoGet.setCode(200);
        todoGet.setStatus("success");
        return todoGet;
    }
}
