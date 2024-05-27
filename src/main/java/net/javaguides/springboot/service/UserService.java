package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.model.User;

import java.util.List;

/**
 * Service interface for managing users.
 */
public interface UserService {

    /**
     * Saves a new user.
     *
     * @param userDto The user DTO containing user information to be saved.
     */
    void save(UserDto userDto);

    /**
     * Retrieves a user DTO by email.
     *
     * @param email The email of the user to retrieve.
     * @return UserDto object containing user details.
     */
    UserDto getUserByEmail(String email);

    /**
     * Retrieves a list of all users.
     *
     * @return List of UserDto objects representing all users.
     */
    List<UserDto> getAllUsers();
}
