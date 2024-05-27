package net.javaguides.springboot.service;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.model.Gender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Custom implementation of Spring Security's UserDetails interface.
 */
public class CustomUserDetails implements UserDetails {

    private User user;

    /**
     * Constructor for CustomUserDetails.
     *
     * @param user The user entity to be wrapped.
     */
    public CustomUserDetails(User user) {
        this.user = user;
    }

    /**
     * Retrieves the authorities granted to the user.
     *
     * @return Collection of GrantedAuthority objects representing user roles.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> user.getRole());
    }

    /**
     * Retrieves the full name of the user.
     *
     * @return The full name of the user.
     */
    public String getFullname() {
        try {
            return user.getFullname();
        } catch (NullPointerException e) {
            return "Unknown";
        }
    }

    /**
     * Retrieves the phone number of the user.
     *
     * @return The phone number of the user.
     */
    public int getNumber() {
        try {
            return user.getPhoneNumber();
        } catch (NullPointerException e) {
            return 0;
        }
    }

    /**
     * Retrieves the gender of the user.
     *
     * @return The gender of the user.
     */
    public Gender getGender() {
        try {
            return user.getGender();
        } catch (NullPointerException e) {
            return Gender.MEMTALY_ILL; // Assuming there's an 'OTHER' option in Gender enum
        }
    }

    /**
     * Retrieves the first name of the user.
     *
     * @return The first name of the user.
     */
    public String getName() {
        try {
            return user.getName();
        } catch (NullPointerException e) {
            return "Unknown";
        }
    }

    /**
     * Retrieves the last name of the user.
     *
     * @return The last name of the user.
     */
    public String getLastname() {
        try {
            return user.getLastname();
        } catch (NullPointerException e) {
            return "Unknown";
        }
    }

    /**
     * Retrieves the username of the user.
     *
     * @return The username of the user.
     */
    public String getUserNameos() {
        try {
            return user.getUserName();
        } catch (NullPointerException e) {
            return "Unknown";
        }
    }

    /**
     * Retrieves the amount of money associated with the user.
     *
     * @return The amount of money associated with the user.
     */
    public int getMoney() {
        try {
            return user.getMoney();
        } catch (NullPointerException e) {
            return 0;
        }
    }

    /**
     * Retrieves the password of the user.
     *
     * @return The password of the user.
     */
    @Override
    public String getPassword() {
        try {
            return user.getPassword();
        } catch (NullPointerException e) {
            return "";
        }
    }

    /**
     * Retrieves the email address of the user.
     *
     * @return The email address of the user.
     */
    @Override
    public String getUsername() {
        try {
            return user.getEmail();
        } catch (NullPointerException e) {
            return "Unknown";
        }
    }

    /**
     * Indicates whether the user's account has expired.
     *
     * @return true if the user's account is valid (i.e., non-expired), false otherwise.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked.
     *
     * @return true if the user is not locked, false otherwise.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired.
     *
     * @return true if the user's credentials are valid (i.e., non-expired), false otherwise.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled.
     *
     * @return true if the user is enabled, false otherwise.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}