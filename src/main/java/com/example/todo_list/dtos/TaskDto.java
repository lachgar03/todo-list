package com.example.todo_list.dtos;

import com.example.todo_list.shared.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class TaskDto {
    Long id;
    @NotBlank(message = "name is required")
    String name;
    @NotNull
    @Size(min = 1, max = 100)
    String description;
    Status status;
}
