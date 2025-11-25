package com.example.todo_list.services.impl;

import com.example.todo_list.dtos.TaskDto;
import com.example.todo_list.entities.Task;
import com.example.todo_list.mappers.TaskMapper;
import com.example.todo_list.repositories.TaskRepository;
import com.example.todo_list.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskMapper taskMapper ;
    private final TaskRepository taskRepository;

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        Task task = taskMapper.taskDtoToTask(taskDto);
        Task saved = taskRepository.save(task);
        return taskMapper.taskToTaskDto(saved);

    }
    @Override
    public TaskDto updateTask(TaskDto taskDto) {
        Task existing = taskRepository.findById(taskDto.getId()).orElseThrow();

        existing.setDescription(taskDto.getDescription());
        existing.setName(taskDto.getName());
        taskRepository.save(existing);
        return taskMapper.taskToTaskDto(existing);
    }
    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    @Override
    public Page<TaskDto> findAll(int page, int size, Long userId) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Task> taskPage = taskRepository.findAllByUserId(userId, pageable);

        return taskPage.map(taskMapper::taskToTaskDto);}
}
