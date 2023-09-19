package com.remedicok.backend.security;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    /*
	@Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write("{\"message\": \"Acceso denegado\", \"error\": \"" + accessDeniedException.getMessage() + "\"}");
    }
    */
    private final ObjectMapper objectMapper;

    public CustomAccessDeniedHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // Configura el código de estado de la respuesta como 403 (Acceso Denegado)
        response.setStatus(HttpStatus.FORBIDDEN.value());

        // Crea un mapa para el mensaje de error
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", "Acceso denegado");
        errorMap.put("error", accessDeniedException.getMessage());

        // Usa Jackson para convertir el mapa en una representación JSON y escribirlo en el cuerpo de la respuesta
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(errorMap));
    }
}
