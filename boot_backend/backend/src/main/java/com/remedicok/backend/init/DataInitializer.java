package com.remedicok.backend.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.remedicok.backend.data.personal.Rol;
import com.remedicok.backend.data.personal.RolRepository;
import com.remedicok.backend.data.personal.Usuario;
import com.remedicok.backend.data.personal.UsuarioRepository;

import javax.transaction.Transactional;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository RolRepository;

    @Autowired
    public DataInitializer(
            UsuarioRepository usuarioRepository,
            RolRepository RolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.RolRepository = RolRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        // Llenar la tabla de Usuarios
        Usuario usuario1 = usuarioRepository.save(new Usuario("Juan", "Pérez", "juan@example.com", "contrasena123"));
        Usuario usuario2 = usuarioRepository.save(new Usuario("María", "González", "maria@example.com", "maria456"));
        Usuario usuario3 = usuarioRepository.save(new Usuario("Pedro", "Ramírez", "pedro@example.com", "pedro789"));
        

        // Llenar la tabla de Roles
        Rol Rol1 = RolRepository.save(new Rol("ROLE_ADMIN", "Rol de administrador con acceso completo"));
        Rol Rol2 = RolRepository.save(new Rol("ROLE_USER", "Rol de usuario con acceso limitado"));
        Rol Rol3 = RolRepository.save(new Rol("ROLE_DOCTOR", "Rol de médico con acceso a información de pacientes"));


        // Establecer relaciones entre Usuarios y Roles
        usuario1.getRoles().add(Rol1);
        usuario2.getRoles().add(Rol2);
        usuario3.getRoles().add(Rol3);
    }
}
