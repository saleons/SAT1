package com.team2.team2.Service;

import com.team2.team2.entities.Marca;

import java.util.List;

public interface InterfazServiceMarca {
    List<Marca> findAll();

    void Delete(long id);

    void save(Marca marca);
    Marca finbyid(long id);
}
