package com.example.todo_list.controllers;

import com.example.todo_list.dtos.TaskDto;
import com.example.todo_list.entities.Task;
import com.example.todo_list.entities.User;
import com.example.todo_list.mappers.TaskMapper;
import com.example.todo_list.repositories.TaskRepository;
import com.example.todo_list.services.AddTaskService;
import com.example.todo_list.services.DeleteTaskService;
import com.example.todo_list.services.UpdateTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskControllers {
    private final AddTaskService addTaskService;
    private final UpdateTaskService updateTaskService;
    private final DeleteTaskService deleteTaskService;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @GetMapping
    public Page<TaskDto> findAll(
            @RequestParam int page,
            @RequestParam int size,
            User user
    ){
        Pageable pageable = PageRequest.of(page, size);
        Page<Task> returnedPage = taskRepository.findAllByUser(user, pageable);

        return returnedPage.map(taskMapper::taskToTaskDto);
    }
    @PostMapping("/ajouter")
    public TaskDto addTask(@RequestBody TaskDto taskDto){
        Task task = taskMapper.taskDtoToTask(taskDto);
        taskRepository.save(task);
        return taskMapper.taskToTaskDto(task);
    }

    @PutMapping("/modifier")
    public TaskDto updateTask(@RequestBody TaskDto taskDto){
        Task task = taskMapper.taskDtoToTask(taskDto);
        taskRepository.save(task);
        return taskMapper.taskToTaskDto(task);
    }
    @DeleteMapping("/supression")
    public void deleteTask(@RequestParam Long id){
        taskRepository.deleteById(id);
    }


}
