package com.example.todo_list.dtos;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
    Long id;
    String username;
    @Email
    String email;
}
