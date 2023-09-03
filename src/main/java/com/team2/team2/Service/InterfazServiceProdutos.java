package com.team2.team2.Service;

import com.team2.team2.entities.Producto;

import java.util.List;

public interface InterfazServiceProdutos {

    public Producto finbyid(long id);

    public List<Producto> findBynombre (String nombre);


    public List<Producto> findAll();

    public void Delete (long id);

    String save(Producto producto);

    List<Producto> findAlertByTime();

    List<Producto> findAlertByTimebyHour();



    List<Producto> findAlertByMessageNotResponset();
}
