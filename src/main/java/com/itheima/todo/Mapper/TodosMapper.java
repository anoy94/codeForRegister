package com.itheima.todo.Mapper;

import com.itheima.todo.pojo.todospojo.MapRequestForAdd;
import com.itheima.todo.pojo.todospojo.MapRequestForDelete;
import com.itheima.todo.pojo.todospojo.TodosJson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper

public interface TodosMapper {
    List<TodosJson> select(String account, Integer page, Integer pageNum);
    List<TodosJson> selectall(String account);
    void update(@Param("account") String account,@Param("id") Integer id,@Param("title") String title,@Param("content") String content,@Param("brief") String brief,@Param("status") String status,@Param("type") String type,@Param("tags") String tags,@Param("repeatOption") String repeatOption,@Param("resetOption") String resetOption,@Param("notificationOption") String notificationOption);


//    Integer add(@Param("account") String account,@Param("title") String title,@Param("content") String content,@Param("brief") String brief,@Param("status") String status,@Param("type") String type,@Param("tags") String tags,@Param("repeatOption") String repeatOption,@Param("resetOption") String resetOption,@Param("origin") String origin,@Param("notificationOption") String notificationOption,@Param("id") Integer idret);
    Integer add(MapRequestForAdd mapRequestForAdd);
    void delete(MapRequestForDelete mapRequestForDelete);
    TodosJson selectOne(@Param("id") Integer id,@Param("account") String account);
}
