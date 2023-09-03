package com.team2.team2.Service;

import com.team2.team2.entities.UnidadMedida;

import java.util.List;

public interface InterfazServiceUnidadMedida {
    List<UnidadMedida> findAll();

    void Delete(long id);

    void save(UnidadMedida unidadMedida);
    UnidadMedida finbyid(long id);
}
