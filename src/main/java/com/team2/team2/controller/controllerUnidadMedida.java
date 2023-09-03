package com.team2.team2.controller;


import com.team2.team2.Service.InterfazServiceProdutos;
import com.team2.team2.Service.InterfazServiceUnidadMedida;
import com.team2.team2.entities.Producto;
import com.team2.team2.entities.UnidadMedida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

//@RequestMapping: define le URL donde se hara la peticion (http://localhost:8080/productos"/(end poit al que deseo ingresar))
@RequestMapping("unidadmedida")
public class controllerUnidadMedida {
    @Autowired
    private InterfazServiceUnidadMedida interfazServiceUnidadMedida;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces="application/json")

    public @ResponseBody UnidadMedida findById (@PathVariable long id) {

        return this.interfazServiceUnidadMedida.finbyid(id);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET,produces="application/json")

    public @ResponseBody List<UnidadMedida> findAll () {
        List<UnidadMedida> listaUnidadMedida=this.interfazServiceUnidadMedida.findAll();
        return listaUnidadMedida;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET,produces="application/json")
    public @ResponseBody void findByIdEdit (@PathVariable long id) {
        this.interfazServiceUnidadMedida.Delete(id);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST,produces="application/json")
    public @ResponseBody void save (@RequestBody UnidadMedida unidadMedida) {

        this.interfazServiceUnidadMedida.save(unidadMedida);
    }
}
