package com.example.todo_list.mappers;

import com.example.todo_list.dtos.TaskDto;
import com.example.todo_list.entities.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task taskDtoToTask(TaskDto taskDto);
    TaskDto taskToTaskDto(Task task);
}
