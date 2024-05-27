package net.javaguides.springboot.service;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.model.Gender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> user.getRole());
    }

    public String getFullname() {
        try {
            return user.getFullname();
        } catch (NullPointerException e) {
            return "Unknown";
        }
    }

    public int getNumber() {
        try {
            return user.getPhoneNumber();
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public Gender getGender() {
        try {
            return user.getGender();
        } catch (NullPointerException e) {
            return Gender.MEMTALY_ILL; // Assuming there's an 'OTHER' option in Gender enum
        }
    }

    public String getName() {
        try {
            return user.getName();
        } catch (NullPointerException e) {
            return "Unknown";
        }
    }

    public String getLastname() {
        try {
            return user.getLastname();
        } catch (NullPointerException e) {
            return "Unknown";
        }
    }

    public String getUserNameos() {
        try {
            return user.getUserName();
        } catch (NullPointerException e) {
            return "Unknown";
        }
    }

    public int getMoney() {
        try {
            return user.getMoney();
        } catch (NullPointerException e) {
            return 0;
        }
    }

    @Override
    public String getPassword() {
        try {
            return user.getPassword();
        } catch (NullPointerException e) {
            return "";
        }
    }

    @Override
    public String getUsername() {
        try {
            return user.getEmail();
        } catch (NullPointerException e) {
            return "Unknown";
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
