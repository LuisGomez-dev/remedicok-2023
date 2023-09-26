package com.remedicok.backend.data.personal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    // Puedes agregar métodos personalizados de repositorio si es necesario
}
