package com.example.todo_list.services.impl;

import com.example.todo_list.repositories.TaskRepository;
import com.example.todo_list.services.DeleteTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteTaskServiceImpl implements DeleteTaskService {
    private final TaskRepository taskRepository;
    @Override
    public void deleteTask(Long id) {
         taskRepository.deleteById(id);
    }
}
