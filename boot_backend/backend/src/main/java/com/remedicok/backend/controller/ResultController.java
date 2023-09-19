package com.remedicok.backend.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

public class ResultController {
    protected Map<String, Object> objResult;
    protected ResponseEntity<Map<String, Object>> responseEntity;
    
    public ResultController() {
        objResult = new HashMap<>();
        responseEntity = ResponseEntity.ok().build();
    }

    public boolean validateRoles(Authentication authentication, String... rolesToCheck) {
        if (authentication != null && authentication.isAuthenticated()) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

            // Obtén los nombres de roles (autoridades) del usuario autenticado
            List<String> userRoles = authorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            // Verifica si el usuario tiene al menos uno de los roles especificados
            for (String roleToCheck : rolesToCheck) {
                if (userRoles.contains(roleToCheck)) {
                    return true; // El usuario tiene al menos uno de los roles especificados
                }
            }
        }

        return false; // El usuario no está autenticado o no tiene los roles especificados
    }

}