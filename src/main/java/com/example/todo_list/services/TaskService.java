package com.example.todo_list.services;

import com.example.todo_list.dtos.TaskDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    TaskDto addTask(TaskDto taskDto);
    TaskDto updateTask(TaskDto taskDto);
    void deleteTask(Long id);
    Page<TaskDto> findAll(int page, int size, Long userId);

}
