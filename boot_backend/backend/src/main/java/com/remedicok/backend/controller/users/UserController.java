package com.remedicok.backend.controller.users;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedicok.backend.controller.ResultController;
import com.remedicok.backend.service.personal.UsuarioService;

@RestController
@RequestMapping("api/usuario")
public class UserController extends ResultController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    ResponseEntity<Map<String, Object>> obtenerUsuarios(Authentication authentication) {
        try{

            boolean isAdmin = validateRoles(authentication, "ROLE_ADMIN");
            if (isAdmin) {
                usuarioService.obtenerTodosLosUsuarios(objResult);
                responseEntity = ResponseEntity.ok(objResult);
            } else {
                 responseEntity = ResponseEntity.status(HttpStatus.FORBIDDEN).body(objResult);
            }

        }catch(Exception e){
            responseEntity =  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR ).body(objResult);
        }
        return responseEntity;
        
    }
}
