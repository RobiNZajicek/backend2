package net.javaguides.springboot.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CustomSuccessHandlerTest {

    @InjectMocks
    private CustomSuccessHandler customSuccessHandler;

    /**
     * Tests the onAuthenticationSuccess method of CustomSuccessHandler when redirecting to the home page.
     *
     * @throws IOException      if an input or output exception occurred.
     * @throws ServletException if the request could not be handled.
     */
    @Test
    public void testOnAuthenticationSuccess_RedirectToHomePage() throws IOException, ServletException {
        HttpServletRequest request = null;  // You can create a mock request if needed
        HttpServletResponse response = null;  // You can create a mock response if needed

        customSuccessHandler.onAuthenticationSuccess(request, response, null);  // Passing null for authentication

        verify(response).sendRedirect("/");
    }
}
