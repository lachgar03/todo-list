package com.example.todo_list.mappers;


import com.example.todo_list.dtos.UserDto;
import com.example.todo_list.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userDtoToUser(UserDto userDto);
    UserDto userToUserDto(User user);
}
