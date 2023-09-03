package com.team2.team2.repositories;

import com.team2.team2.entities.Mensaje;
import com.team2.team2.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InterfazBaseMensaje extends JpaRepository<Mensaje,Long> {

    Mensaje findByid (long id);

    List<Mensaje> findByusuariorecibe (String nombre);

    List<Mensaje> findAll();

    @Query(value ="SELECT * FROM proceso  WHERE usuarioenvia = :nombre OR usuariorecibe = :nombre",nativeQuery = true)

        //@Param=pasa los datos del id a param para enviarlo a la consulta @Query
    List<Mensaje> findByConversa( @Param("nombre") String nombre);  //busca por nombre de departamnwto q contiene una ciudad

    @Query(value ="SELECT * FROM proceso WHERE  usuariorecibe = :nombre ORDER BY id DESC LIMIT 1",nativeQuery = true)

        //@Param=pasa los datos del id a param para enviarlo a la consulta @Query
    List<Mensaje> findByConversalastMessage( @Param("nombre") String nombre);


    @Query(value ="SELECT * FROM proceso  WHERE usuarioenvia = :nombre AND usuariorecibe = 'ADMIN' ORDER BY id DESC LIMIT 1",nativeQuery = true)
    Mensaje findLastMessagesNotResponsByName(String nombre);
}
