package net.javaguides.springboot.service;

import net.javaguides.springboot.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


public class CustomUserDetails implements UserDetails {

    private net.javaguides.springboot.model.User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> user.getRole());
    }

    public String getFullname() {
        return user.getFullname();
    }

    public String getName() {
        return user.getName();
    }

    public String getLastname() {
        return user.getLastname();
    }

    public String getUserNameos() {
        return user.getUserName();
    }

    public int getMoney() {
        return user.getMoney();
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getEmail();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

}
