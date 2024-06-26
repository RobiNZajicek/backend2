package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of UserService interface.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Saves a new user.
     *
     * @param userDto The user DTO containing user information to be saved.
     */
    @Override
    public void save(UserDto userDto) {
        User user = new User();
        user.setFullname(userDto.getFullname());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setMoney((int) userDto.getMoney());
        user.setUserName(userDto.getUserName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setGender(userDto.getGender());
        user.setRole("USER"); // Set default role or based on logic
        userRepository.save(user);
    }

    /**
     * Retrieves a user DTO by email.
     *
     * @param email The email of the user to retrieve.
     * @return UserDto object containing user details.
     */
    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            UserDto userDto = new UserDto();
            userDto.setFullname(user.getFullname());
            userDto.setEmail(user.getEmail());
            // Do not return the password
            userDto.setName(user.getName());
            userDto.setLastname(user.getLastname());
            userDto.setMoney(user.getMoney());
            userDto.setUserName(user.getUserName());
            userDto.setPhoneNumber(user.getPhoneNumber());
            userDto.setGender(user.getGender());
            return userDto;
        }
        return null;
    }

    /**
     * Retrieves a list of all users.
     *
     * @return List of UserDto objects representing all users.
     */
    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(user -> {
            UserDto userDto = new UserDto();
            userDto.setFullname(user.getFullname());
            userDto.setEmail(user.getEmail());
            userDto.setName(user.getName());
            userDto.setLastname(user.getLastname());
            userDto.setMoney(user.getMoney());
            userDto.setUserName(user.getUserName());
            userDto.setPhoneNumber(user.getPhoneNumber());
            userDto.setGender(user.getGender());
            return userDto;
        }).collect(Collectors.toList());
    }
}
