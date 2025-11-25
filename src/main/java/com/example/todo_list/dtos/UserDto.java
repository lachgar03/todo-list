package com.example.todo_list.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
    Long id;
    String username;
    String email;
}
