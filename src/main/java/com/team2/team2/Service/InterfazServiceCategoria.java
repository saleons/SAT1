package com.team2.team2.Service;

import com.team2.team2.entities.Categoria;

import java.util.List;

public interface InterfazServiceCategoria {
    Categoria finbyid(long id);
    List<Categoria> findAll();

    void Delete(long id);

    void save(Categoria categoria);
}
