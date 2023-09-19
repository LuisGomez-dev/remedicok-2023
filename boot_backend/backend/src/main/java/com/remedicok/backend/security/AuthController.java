package com.remedicok.backend.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.remedicok.backend.controller.ResultController;

@RestController
public class AuthController extends ResultController  {
    @Autowired
    AuthService authService;

    @PostMapping(path="/api/login",
	consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Map<String, Object>>  authenticate(@RequestBody LoginRequestDTO localUser) {
        this.objResult = new HashMap<>();
        authService.procesaCredencial(objResult, localUser);
        if(authService.isCredencialValida()){
            responseEntity = ResponseEntity.ok(objResult);
        }else{
            responseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(objResult);
        }

        return responseEntity;
	}

}
