package com.remedicok.backend.data.personal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PantallaRepository extends JpaRepository<Pantalla, Long> {
    // Puedes agregar métodos personalizados de repositorio si es necesario
}
