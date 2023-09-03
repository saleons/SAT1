package com.team2.team2.controller;


import com.team2.team2.Service.InterfazServiceProdutos;
import com.team2.team2.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

//@RequestMapping: define le URL donde se hara la peticion (http://localhost:8080/productos"/(end poit al que deseo ingresar))
@RequestMapping("productos")
public class controllerProductos {
    //_____________________________________________SERVICIOS________________________________________
    ////@Autowired: TRAE INTERFAZ DEL IserviceUsers  (BASE DE DATOS) y pordebajo toda la logica de ImpleServicesUsers
    @Autowired
    private InterfazServiceProdutos interfazServiceProdutos;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces="application/json")
    public @ResponseBody Producto findById (@PathVariable long id) {
        return this.interfazServiceProdutos.finbyid(id);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET,produces="application/json")

    public @ResponseBody List<Producto> findAll () {
        List<Producto> listaProductos=this.interfazServiceProdutos.findAll();
        return listaProductos;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET,produces="application/json")
    public @ResponseBody void findByIdEdit (@PathVariable long id) {
        this.interfazServiceProdutos.Delete(id);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST,produces="application/json")
    public @ResponseBody String save (@RequestBody Producto producto) {
        return this.interfazServiceProdutos.save(producto);
    }

    @RequestMapping(value = "/endpoint",method = RequestMethod.POST,produces="application/json")
    public String A (@RequestBody String a) {
        System.out.println("a");
        return "reserva";
    }
    @RequestMapping(value = "/all11",method = RequestMethod.GET,produces="application/json")

    public @ResponseBody List<Producto> findAlertByTimebyHour () {
        List<Producto> listaProductos=this.interfazServiceProdutos.findAlertByTimebyHour();
        return listaProductos;
    }






}
