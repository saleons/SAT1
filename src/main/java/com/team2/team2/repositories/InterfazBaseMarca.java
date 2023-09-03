package com.team2.team2.repositories;

import com.team2.team2.entities.Marca;
import com.team2.team2.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterfazBaseMarca extends JpaRepository<Marca,Long> {

    Marca findByid (long id);


    List<Marca> findAll();
}
