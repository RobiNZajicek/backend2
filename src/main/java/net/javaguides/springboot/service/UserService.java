package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.model.User;

import java.util.List;

public interface UserService {
    void save(UserDto userDto);
    UserDto getUserByEmail(String email);
    List<UserDto> getAllUsers();
}
