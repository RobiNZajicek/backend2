package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.model.Gender;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    private UserDto userDto;
    private User user;

    @BeforeEach
    public void setUp() {
        userDto = new UserDto();
        userDto.setFullname("John Doe");
        userDto.setEmail("john.doe@example.com");
        userDto.setPassword("password");
        userDto.setName("John");
        userDto.setLastname("Doe");
        userDto.setMoney(1000);
        userDto.setUserName("johndoe");
        userDto.setPhoneNumber(123456789);
        userDto.setGender(Gender.MALE);

        user = new User();
        user.setFullname("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password");
        user.setName("John");
        user.setLastname("Doe");
        user.setMoney(1000);
        user.setUserName("johndoe");
        user.setPhoneNumber(123456789);
        user.setGender(Gender.MALE);
    }

    @Test
    public void testSaveUser() {
        when(passwordEncoder.encode(userDto.getPassword())).thenReturn("encodedPassword");

        userServiceImpl.save(userDto);

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testGetUserByEmail() {
        when(userRepository.findByEmail("john.doe@example.com")).thenReturn(user);

        UserDto fetchedUser = userServiceImpl.getUserByEmail("john.doe@example.com");

        assertEquals("john.doe@example.com", fetchedUser.getEmail());
    }

    @Test
    public void testGetUserByEmail_UserNotFound() {
        when(userRepository.findByEmail("john.doe@example.com")).thenReturn(null);

        UserDto fetchedUser = userServiceImpl.getUserByEmail("john.doe@example.com");

        assertNull(fetchedUser);
    }

    @Test
    public void testGetAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(user);

        when(userRepository.findAll()).thenReturn(userList);

        List<UserDto> users = userServiceImpl.getAllUsers();

        assertFalse(users.isEmpty());
        assertEquals(1, users.size());
    }
}
