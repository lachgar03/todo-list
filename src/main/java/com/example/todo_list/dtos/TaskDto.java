package com.example.todo_list.dtos;

import com.example.todo_list.shared.Status;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class TaskDto {
    @NonNull
    Long id;
    @NonNull
    String name;
    @NonNull
    @Size(min = 1, max = 100)
    String description;
    Status status;
}
