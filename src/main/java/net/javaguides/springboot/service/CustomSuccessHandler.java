package net.javaguides.springboot.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.springboot.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Custom success handler to manage post-authentication actions.
 */
@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    /**
     * Method invoked upon successful authentication.
     *
     * @param request        the HttpServletRequest object.
     * @param response       the HttpServletResponse object.
     * @param authentication the Authentication object.
     * @throws IOException      if an input or output error occurs.
     * @throws ServletException if a servlet-specific error occurs.
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        try {
            var authorities = authentication.getAuthorities();
            var roles = authorities.stream().map(r -> r.getAuthority()).findFirst();

            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            String fullname = userDetails.getFullname();
            String email = userDetails.getUsername();
            String name = userDetails.getName();
            String lastname = userDetails.getLastname();
            int phoneNumber = userDetails.getNumber();
            int money = userDetails.getMoney();
            String gender = userDetails.getGender().toString();  // Convert enum to string
            String userName = userDetails.getUserNameos();

            // Redirect based on the user's role
            if (roles.orElse("").equals("ADMIN")) {
                response.sendRedirect("/admin-page");
            } else if (roles.orElse("").equals("USER")) {
                // Example redirect after successful registration
                response.sendRedirect("https://stcoks2-2-iowy.vercel.app/?fullname=" + fullname
                        + "&email=" + email
                        + "&name=" + name
                        + "&lastname=" + lastname
                        + "&money=" + money
                        + "&userName=" + userName
                        + "&phoneNumber=" + phoneNumber
                        + "&gender=" + gender);
            } else {
                response.sendRedirect("/error");
            }
        } catch (Exception e) {
            // Handle any unexpected errors and redirect to an error page
            response.sendRedirect("/error");
        }
    }
}
