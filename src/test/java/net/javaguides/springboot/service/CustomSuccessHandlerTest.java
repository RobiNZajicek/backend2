package net.javaguides.springboot.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CustomSuccessHandlerTest {

    @InjectMocks
    private CustomSuccessHandler customSuccessHandler;

    @Test
    public void testOnAuthenticationSuccess_RedirectToHomePage() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        customSuccessHandler.onAuthenticationSuccess(request, response, null);

        verify(response).sendRedirect("/");
    }
}
