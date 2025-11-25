package com.example.todo_list.repositories;

import com.example.todo_list.dtos.TaskDto;
import com.example.todo_list.entities.Task;
import com.example.todo_list.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    void  deleteById(Long id);
    Page<Task> findAllByUserId(Long userId, Pageable pageable);}
