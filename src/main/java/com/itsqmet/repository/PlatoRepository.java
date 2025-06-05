package com.itsqmet.repository;

import com.itsqmet.entity.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {
    //FIltrar por Categoria
    List<Plato> findByCategoriaContainingIgnoreCase(String categoria);
}
