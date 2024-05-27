package net.javaguides.springboot.service;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CustomUserDetailsService customUserDetailsService;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setEmail("john.doe@example.com");
    }

    /**
     * Tests the loadUserByUsername method of CustomUserDetailsService when the user is found.
     */
    @Test
    public void testLoadUserByUsername_UserFound() {
        when(userRepository.findByEmail("john.doe@example.com")).thenReturn(user);

        CustomUserDetails userDetails = (CustomUserDetails) customUserDetailsService.loadUserByUsername("john.doe@example.com");

        assertEquals("john.doe@example.com", userDetails.getUsername());
        verify(userRepository, times(1)).findByEmail("john.doe@example.com");
    }

    /**
     * Tests the loadUserByUsername method of CustomUserDetailsService when the user is not found.
     */
    @Test
    public void testLoadUserByUsername_UserNotFound() {
        when(userRepository.findByEmail("john.doe@example.com")).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> {
            customUserDetailsService.loadUserByUsername("john.doe@example.com");
        });
    }
}
