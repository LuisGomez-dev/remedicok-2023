package com.remedicok.backend.data.personal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.correoElectronico = :correo AND u.contrasena = :contrasena")
    Usuario findByCorreoAndContrasena(String correo, String contrasena);

    // Método para buscar un usuario por correo electrónico y contraseña
    Usuario findByCorreoElectronicoAndContrasena(String correoElectronico, String contrasena);
}
