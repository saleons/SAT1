package com.team2.team2.controller;


import com.team2.team2.Service.InterfazServiceCategoria;
import com.team2.team2.entities.Categoria;
import com.team2.team2.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

//@RequestMapping: define le URL donde se hara la peticion (http://localhost:8080/productos"/(end poit al que deseo ingresar))
@RequestMapping("categorias")
public class controllerCategoria {
    //_____________________________________________SERVICIOS________________________________________
    ////@Autowired: TRAE INTERFAZ DEL IserviceUsers  (BASE DE DATOS) y pordebajo toda la logica de ImpleServicesUsers
    @Autowired
    private InterfazServiceCategoria interfazServiceCategoria;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces="application/json")

    public @ResponseBody Categoria findById (@PathVariable long id) {

        return this.interfazServiceCategoria.finbyid(id);
    }
    @RequestMapping(value = "/all",method = RequestMethod.GET,produces="application/json")

    public @ResponseBody List<Categoria> findAll () {
        List<Categoria> listaProductos=this.interfazServiceCategoria.findAll();
        return listaProductos;
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET,produces="application/json")
    public @ResponseBody void findByIdEdit (@PathVariable long id) {
        this.interfazServiceCategoria.Delete(id);
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST,produces="application/json")
    public @ResponseBody void save (@RequestBody Categoria categoria) {

        this.interfazServiceCategoria.save(categoria);
    }
}
