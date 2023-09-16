package com.remedicok.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedicok.backend.service.LibroService;

import java.util.Map;

@RestController
@RequestMapping("api/libros")
public class LibroController extends ResultController {
    @Autowired
    LibroService libroService;


    @GetMapping
    Map<String, Object> obtenerLibros() {
        libroService.listadoLibro(objResult);
        return objResult;
    }
}
