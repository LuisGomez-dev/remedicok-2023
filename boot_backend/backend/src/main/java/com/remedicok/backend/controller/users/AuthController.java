package com.remedicok.backend.controller.users;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.remedicok.backend.controller.ResultController;
import com.remedicok.backend.dto.security.LoginRequest;
import com.remedicok.backend.service.security.AuthService;

@RestController
public class AuthController extends ResultController  {
    @Autowired
    AuthService authService;

    @PostMapping(path="/api/login",
	consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Map<String, Object>>  authenticate(@RequestBody LoginRequest localUser) {

		if(authService.esValido(localUser) ) {
			authService.getJWTToken(objResult, localUser.getUsuario() );
            return ResponseEntity.ok(objResult);
		} else {
			objResult.put("error", "credencial no valida");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(objResult);
		}
	}

}
