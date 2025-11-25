package com.example.todo_list.services.impl;

import com.example.todo_list.dtos.TaskDto;
import com.example.todo_list.entities.Task;
import com.example.todo_list.mappers.TaskMapper;
import com.example.todo_list.repositories.TaskRepository;
import com.example.todo_list.services.AddTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddTaskServiceImpl implements AddTaskService {
    private final TaskMapper taskMapper ;
    private final TaskRepository taskRepository;

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        Task task = taskMapper.taskDtoToTask(taskDto);
        Task saved = taskRepository.save(task);
        return taskMapper.taskToTaskDto(saved);

    }
}
