package com.studentrestapi.jwt;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

  private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
      throws IOException, ServletException {
    logger.error("Unauthorized error: {}", authException.getMessage());

//    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//
//    final Map<String, Object> body = new HashMap<>();
//    body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
//    body.put("error", "Unauthorized");
//    body.put("message", authException.getMessage());
//    body.put("path", request.getServletPath());
//
//    final ObjectMapper mapper = new ObjectMapper();
//    mapper.writeValue(response.getOutputStream(), body);
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
  }

}


//
//
//
//import org.springframework.http.MediaType;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
//            throws IOException, ServletException {
//        if (isMultipartRequest(request)) {
//            // Handle multipart request differently, if needed
//            handleMultipartRequest(response, authException, request);
//        } else {
//            // Handle other requests
//            handleNonMultipartRequest(response, authException, request);
//        }
//    }
//
//    private boolean isMultipartRequest(HttpServletRequest request) {
//        return MediaType.MULTIPART_FORM_DATA_VALUE.equalsIgnoreCase(request.getContentType());
//    }
//
//    private void handleMultipartRequest(HttpServletResponse response, AuthenticationException authException, HttpServletRequest request)
//            throws IOException {
//        // Handle multipart request
//        // You may choose to respond differently for multipart requests
//        // For example, set a different status code, message, etc.
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//
//        final Map<String, Object> body = new HashMap<>();
//        body.put("status", HttpServletResponse.SC_BAD_REQUEST);
//        body.put("error", "Bad Request");
//        body.put("message", "Multipart requests not supported for authentication");
//        body.put("path", request.getServletPath());
//
//        // Use your preferred JSON mapping library (e.g., Jackson) to write the response body
//        // Here, ObjectMapper is just an example, you can replace it with your library of choice
//        final ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(response.getOutputStream(), body);
//    }
//
//    private void handleNonMultipartRequest(HttpServletResponse response, AuthenticationException authException, HttpServletRequest request)
//            throws IOException {
//        // Handle other requests as before
//        logger.error("Unauthorized error: {}", authException.getMessage());
//
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//
//        final Map<String, Object> body = new HashMap<>();
//        body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
//        body.put("error", "Unauthorized");
//        body.put("message", authException.getMessage());
//        body.put("path", request.getServletPath());
//
//        final ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(response.getOutputStream(), body);
//    }
//}
//
