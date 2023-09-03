package com.team2.team2.repositories;

import com.team2.team2.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InterfazBaseproductos extends JpaRepository<Producto,Long> {



        Producto findByid (long id);

        List<Producto> findBynombre (String nombre);


        List<Producto> findAll();

        @Query(value ="SELECT * FROM producto WHERE nombre = :nombre ORDER BY id DESC LIMIT 10",nativeQuery = true)

                //@Param=pasa los datos del id a param para enviarlo a la consulta @Query
        Producto findLastAlert(@Param("nombre") String nombre);


        @Query(value = "SELECT * FROM producto  ORDER BY fecha_actualizacion ", nativeQuery = true)
        List<Producto> findAlertByTime();

        @Query(value = "SELECT * FROM producto WHERE cantidad = 10  ", nativeQuery = true)
        List<Producto> findAlertByMessageNotResponset();
}
