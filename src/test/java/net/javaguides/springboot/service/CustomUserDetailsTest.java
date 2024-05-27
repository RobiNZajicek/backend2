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

    /**
     * Tests the getFullname method of CustomUserDetails.
     */
    @Test
    public void testGetFullname() {
        assertEquals("John Doe", customUserDetails.getFullname());
    }

    /**
     * Tests the getNumber method of CustomUserDetails.
     */
    @Test
    public void testGetNumber() {
        assertEquals(123456789, customUserDetails.getNumber());
    }

    /**
     * Tests the getGender method of CustomUserDetails.
     */
    @Test
    public void testGetGender() {
        assertEquals(Gender.MALE, customUserDetails.getGender());
    }

    /**
     * Tests the getName method of CustomUserDetails.
     */
    @Test
    public void testGetName() {
        assertEquals("John", customUserDetails.getName());
    }

    /**
     * Tests the getLastname method of CustomUserDetails.
     */
    @Test
    public void testGetLastname() {
        assertEquals("Doe", customUserDetails.getLastname());
    }

    /**
     * Tests the getUserNameos method of CustomUserDetails.
     */
    @Test
    public void testGetUserNameos() {
        assertEquals("johndoe", customUserDetails.getUserNameos());
    }

    /**
     * Tests the getMoney method of CustomUserDetails.
     */
    @Test
    public void testGetMoney() {
        assertEquals(1000, customUserDetails.getMoney());
    }

    /**
     * Tests the getPassword method of CustomUserDetails.
     */
    @Test
    public void testGetPassword() {
        assertNull(customUserDetails.getPassword());
    }

    /**
     * Tests the getUsername method of CustomUserDetails.
     */
    @Test
    public void testGetUsername() {
        assertEquals("john.doe@example.com", customUserDetails.getUsername());
    }

    /**
     * Tests the isAccountNonExpired method of CustomUserDetails.
     */
    @Test
    public void testIsAccountNonExpired() {
        assertTrue(customUserDetails.isAccountNonExpired());
    }

    /**
     * Tests the isAccountNonLocked method of CustomUserDetails.
     */
    @Test
    public void testIsAccountNonLocked() {
        assertTrue(customUserDetails.isAccountNonLocked());
    }

    /**
     * Tests the isCredentialsNonExpired method of CustomUserDetails.
     */
    @Test
    public void testIsCredentialsNonExpired() {
        assertTrue(customUserDetails.isCredentialsNonExpired());
    }

    /**
     * Tests the isEnabled method of CustomUserDetails.
     */
    @Test
    public void testIsEnabled() {
        assertTrue(customUserDetails.isEnabled());
    }
}
