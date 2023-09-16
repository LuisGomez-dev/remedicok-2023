package com.remedicok.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedicok.backend.service.personal.UsuarioService;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController extends ResultController {
    @Autowired
    UsuarioService usuarioService;


    @GetMapping
    Map<String, Object> obtenerUsuarios() {
        usuarioService.obtenerTodosLosUsuarios(objResult);
        return objResult;
    }
}