package com.remedicok.backend.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.remedicok.backend.data.personal.Pantalla;
import com.remedicok.backend.data.personal.PantallaRepository;
import com.remedicok.backend.data.personal.Perfil;
import com.remedicok.backend.data.personal.PerfilRepository;
import com.remedicok.backend.data.personal.Usuario;
import com.remedicok.backend.data.personal.UsuarioRepository;

import javax.transaction.Transactional;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;
    private final PantallaRepository pantallaRepository;

    @Autowired
    public DataInitializer(
            UsuarioRepository usuarioRepository,
            PerfilRepository perfilRepository,
            PantallaRepository pantallaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.perfilRepository = perfilRepository;
        this.pantallaRepository = pantallaRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        // Llenar la tabla de Usuarios
        Usuario usuario1 = usuarioRepository.save(new Usuario("Juan", "Pérez", "juan@example.com", "contrasena123"));
        Usuario usuario2 = usuarioRepository.save(new Usuario("María", "González", "maria@example.com", "maria456"));
        Usuario usuario3 = usuarioRepository.save(new Usuario("Pedro", "Ramírez", "pedro@example.com", "pedro789"));
        

        // Llenar la tabla de Perfiles
        Perfil perfil1 = perfilRepository.save(new Perfil("ROLE_ADMIN", "Perfil de administrador con acceso completo"));
        Perfil perfil2 = perfilRepository.save(new Perfil("ROLE_USER", "Perfil de usuario con acceso limitado"));
        Perfil perfil3 = perfilRepository.save(new Perfil("ROLE_DOCTOR", "Perfil de médico con acceso a información de pacientes"));

        // Llenar la tabla de Pantallas
        Pantalla pantalla1 = pantallaRepository.save(new Pantalla("Panel de Control", "Pantalla principal de administración"));
        Pantalla pantalla2 = pantallaRepository.save(new Pantalla("Perfil de Usuario", "Pantalla de configuración del perfil del usuario"));
        Pantalla pantalla3 = pantallaRepository.save(new Pantalla("Historial de Pacientes", "Pantalla para ver el historial de pacientes"));

        // Establecer relaciones entre Usuarios y Perfiles
        usuario1.getPerfiles().add(perfil1);
        usuario2.getPerfiles().add(perfil2);
        usuario3.getPerfiles().add(perfil3);

        // Establecer relaciones entre Perfiles y Pantallas
        perfil1.getPantallas().add(pantalla1);
        perfil1.getPantallas().add(pantalla2);
        perfil2.getPantallas().add(pantalla2);
        perfil3.getPantallas().add(pantalla3);
    }
}
