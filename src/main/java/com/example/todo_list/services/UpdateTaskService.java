package com.example.todo_list.services;

import com.example.todo_list.dtos.TaskDto;

public interface UpdateTaskService {
    TaskDto updateTask(TaskDto taskDto);
}
