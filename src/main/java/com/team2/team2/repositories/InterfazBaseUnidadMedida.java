package com.team2.team2.repositories;

import com.team2.team2.entities.Producto;
import com.team2.team2.entities.UnidadMedida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterfazBaseUnidadMedida extends JpaRepository<UnidadMedida,Long> {

    UnidadMedida findByid (long id);


    List<UnidadMedida> findAll();
}
