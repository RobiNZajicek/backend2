package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Gender;
import net.javaguides.springboot.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomUserDetailsTest {

    private User user;
    private CustomUserDetails customUserDetails;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setName("John");
        user.setLastname("Doe");
        user.setEmail("john.doe@example.com");
        user.setPhoneNumber(123456789);
        user.setGender(Gender.MALE);
        user.setUserName("johndoe");
        user.setMoney(1000);
        user.setRole("USER");
        customUserDetails = new CustomUserDetails(user);
    }

    @Test
    public void testGetFullname() {
        assertEquals("John Doe", customUserDetails.getFullname());
    }

    @Test
    public void testGetNumber() {
        assertEquals(123456789, customUserDetails.getNumber());
    }

    @Test
    public void testGetGender() {
        assertEquals(Gender.MALE, customUserDetails.getGender());
    }

    @Test
    public void testGetName() {
        assertEquals("John", customUserDetails.getName());
    }

    @Test
    public void testGetLastname() {
        assertEquals("Doe", customUserDetails.getLastname());
    }

    @Test
    public void testGetUserNameos() {
        assertEquals("johndoe", customUserDetails.getUserNameos());
    }

    @Test
    public void testGetMoney() {
        assertEquals(1000, customUserDetails.getMoney());
    }

    @Test
    public void testGetPassword() {
        assertNull(customUserDetails.getPassword());
    }

    @Test
    public void testGetUsername() {
        assertEquals("john.doe@example.com", customUserDetails.getUsername());
    }

    @Test
    public void testIsAccountNonExpired() {
        assertTrue(customUserDetails.isAccountNonExpired());
    }

    @Test
    public void testIsAccountNonLocked() {
        assertTrue(customUserDetails.isAccountNonLocked());
    }

    @Test
    public void testIsCredentialsNonExpired() {
        assertTrue(customUserDetails.isCredentialsNonExpired());
    }

    @Test
    public void testIsEnabled() {
        assertTrue(customUserDetails.isEnabled());
    }
}
