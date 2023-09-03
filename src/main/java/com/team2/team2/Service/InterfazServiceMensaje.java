package com.team2.team2.Service;

import com.team2.team2.entities.Mensaje;
import com.team2.team2.entities.Producto;

import java.text.ParseException;
import java.util.List;

public interface InterfazServiceMensaje {
    Mensaje finbyid(long id) throws ParseException;

    List<Mensaje> findAll();

    void Delete(long id);

    void save(Mensaje proceso);

    List<Mensaje> findBynombre(String nombre);

    List<Mensaje> findByConversa(String nombre);

    List<Mensaje> findByConversalastMessage(String nombre);


    List<Producto> findMessagesNotRespons();
}
