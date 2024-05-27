package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

/**
 * Controller class for managing user-related web requests.
 */
@Controller
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    /**
     * Handles GET requests for the registration page.
     *
     * @param userDto Data transfer object for user registration.
     * @return The name of the registration form view.
     */
    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
        return "registration-form";
    }

    /**
     * Handles POST requests for user registration.
     *
     * @param userDto Data transfer object containing user information.
     * @param model   Model object for adding attributes to the view.
     * @return The name of the login view.
     */
    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
        userService.save(userDto);
        model.addAttribute("message", "Registered Successfully!");
        return "/login";
    }

    /**
     * Handles GET requests for the login page.
     *
     * @return The name of the login view.
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Handles GET requests for the user list page.
     *
     * @param model     Model object for adding attributes to the view.
     * @param principal Principal object representing the current logged-in user.
     * @return The name of the user list view.
     */
    @GetMapping("/list-users")
    public String userPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        model.addAttribute("listUsers", userService.getAllUsers());
        return "list-users";
    }

    /**
     * Handles GET requests for the admin page.
     *
     * @param model     Model object for adding attributes to the view.
     * @param principal Principal object representing the current logged-in user.
     * @return The name of the admin page view.
     */
    @GetMapping("admin-page")
    public String adminPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "admin-page";
    }

    /**
     * Handles GET requests for the user profile page.
     *
     * @param model Model object for adding attributes to the view.
     * @return The name of the user profile view.
     */
    @GetMapping("/user-profile")
    public String userProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        UserDto userDto = userService.getUserByEmail(currentPrincipalName);
        model.addAttribute("user", userDto);
        return "user-profile";
    }

    /**
     * Retrieves the user profile based on the authentication object.
     *
     * @param authentication Authentication object containing user details.
     * @return UserDto object with user profile information.
     */
    public UserDto getUserProfile(Authentication authentication) {
        String email = authentication.getName();
        UserDto userDto = userService.getUserByEmail(email);
        return userDto;
    }
}
