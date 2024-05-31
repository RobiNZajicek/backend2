package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private UserDetailsService userDetailsService;

    @InjectMocks
    private UserController userController;

    @Mock
    private Model model;

    @Mock
    private Principal principal;

    @Mock
    private Authentication authentication;

    private UserDto userDto;
    private List<UserDto> userList;

    @BeforeEach
    public void setUp() {
        userDto = new UserDto();
        userDto.setFullname("John Doe");
        userDto.setEmail("john.doe@example.com");

        userList = new ArrayList<>();
        userList.add(userDto);

        when(principal.getName()).thenReturn("john.doe@example.com");
    }

    @Test
    public void testGetRegistrationPage() {
        String viewName = userController.getRegistrationPage(userDto);
        assertEquals("registration-form", viewName);
    }

    @Test
    public void testSaveUser() {
        String viewName = userController.saveUser(userDto, model);
        assertEquals("/login", viewName);
        verify(userService, times(1)).save(userDto);
        verify(model, times(1)).addAttribute("message", "Registered Successfully!");
    }

    @Test
    public void testLogin() {
        String viewName = userController.login();
        assertEquals("login", viewName);
    }

    @Test
    public void testUserPage() {
        UserDetails userDetails = new User("john.doe@example.com", "password", new ArrayList<>());
        when(userDetailsService.loadUserByUsername("john.doe@example.com")).thenReturn(userDetails);
        when(userService.getAllUsers()).thenReturn(userList);

        String viewName = userController.userPage(model, principal);
        assertEquals("list-users", viewName);

        verify(model, times(1)).addAttribute("user", userDetails);
        verify(model, times(1)).addAttribute("listUsers", userList);
    }

    @Test
    public void testAdminPage() {
        UserDetails userDetails = new User("john.doe@example.com", "password", new ArrayList<>());
        when(userDetailsService.loadUserByUsername("john.doe@example.com")).thenReturn(userDetails);

        String viewName = userController.adminPage(model, principal);
        assertEquals("admin-page", viewName);

        verify(model, times(1)).addAttribute("user", userDetails);
    }

    @Test
    public void testUserProfile() {
        SecurityContextHolder.getContext().setAuthentication(authentication);
        when(authentication.getName()).thenReturn("john.doe@example.com");

        UserDetails userDetails = new User("john.doe@example.com", "password", new ArrayList<>());
        when(userService.getUserByEmail("john.doe@example.com")).thenReturn(userDto);

        String viewName = userController.userProfile(model);
        assertEquals("user-profile", viewName);

        verify(model, times(1)).addAttribute("user", userDto);
    }
}
