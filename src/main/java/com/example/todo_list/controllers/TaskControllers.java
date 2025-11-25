package com.example.todo_list.controllers;
import com.example.todo_list.dtos.TaskDto;
import com.example.todo_list.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskControllers {
    private final TaskService taskService;

    @GetMapping
    public Page<TaskDto> findAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam Long userId
    ) {
        return taskService.findAll(page, size, userId);
    }
    @PostMapping("/add")
    public TaskDto addTask(@RequestBody TaskDto taskDto){
        return taskService.addTask(taskDto);
    }

    @PutMapping("/update")
    public TaskDto updateTask(@RequestBody TaskDto taskDto){
        return taskService.updateTask(taskDto);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }


}
