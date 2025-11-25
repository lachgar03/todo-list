package com.example.todo_list.services.impl;

import com.example.todo_list.dtos.TaskDto;
import com.example.todo_list.entities.Task;
import com.example.todo_list.mappers.TaskMapper;
import com.example.todo_list.repositories.TaskRepository;
import com.example.todo_list.services.UpdateTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateTaskServiceImpl implements UpdateTaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    @Override
    public TaskDto updateTask(TaskDto taskDto) {
        Task existing = taskRepository.findById(taskDto.getId()).orElseThrow();

        existing.setDescription(taskDto.getDescription());
        existing.setName(taskDto.getName());
        taskRepository.save(existing);
        return taskMapper.taskToTaskDto(existing);
    }
}
