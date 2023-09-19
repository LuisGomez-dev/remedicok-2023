package com.remedicok.backend.service.personal;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remedicok.backend.data.personal.Usuario;
import com.remedicok.backend.data.personal.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(String nombre, String apellido, String correoElectronico, String contrasena) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setCorreoElectronico(correoElectronico);
        usuario.setContrasena(contrasena);
        
        // Establecer fechas de registro y modificación (puedes usar LocalDateTime en lugar de Date si lo prefieres)
        usuario.setFechaRegistro(new Date());
        usuario.setFechaModificacion(new Date());

        return usuarioRepository.save(usuario); 
    }

    public void obtenerTodosLosUsuarios(Map<String, Object> result) {
        result.put("usuarios", usuarioRepository.findAll());
    }
}
