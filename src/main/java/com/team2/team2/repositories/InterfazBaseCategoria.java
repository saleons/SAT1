package com.team2.team2.repositories;

import com.team2.team2.entities.Categoria;
import com.team2.team2.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Calendar;
import java.util.List;

public interface InterfazBaseCategoria extends JpaRepository<Categoria,Long> {
    Categoria findByid (long id);


    List<Categoria> findAll();
}
