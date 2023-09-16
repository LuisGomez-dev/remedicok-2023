package com.remedicok.backend.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class LibroService {

    public void listadoLibro(Map<String, Object> result){
        Map<String, Object> libros = new HashMap<>(); // Creamos un mapa para pares clave-valor

        libros.put("lib1", "Libor");
        libros.put("lib2", "Libor");
        libros.put("lib3", "Libor");
        libros.put("lib4", "Libor");
        result.put("Biblio", libros);
    }    

}
