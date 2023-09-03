package com.team2.team2.controller;

import com.team2.team2.Service.InterfazServiceCategoria;
import com.team2.team2.Service.InterfazServiceMarca;
import com.team2.team2.Service.InterfazServiceProdutos;
import com.team2.team2.entities.Categoria;
import com.team2.team2.entities.Marca;
import com.team2.team2.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

//@RequestMapping: define le URL donde se hara la peticion (http://localhost:8080/productos"/(end poit al que deseo ingresar))
@RequestMapping("marca")
public class controllerMarca {
    @Autowired
    private InterfazServiceMarca interfazServiceMarca;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces="application/json")

    public @ResponseBody Marca findById (@PathVariable long id) {

        return this.interfazServiceMarca.finbyid(id);
    }
    @RequestMapping(value = "/all",method = RequestMethod.GET,produces="application/json")

    public @ResponseBody List<Marca> findAll () {
        List<Marca> listaMarca=this.interfazServiceMarca.findAll();
        return listaMarca;
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET,produces="application/json")
    public @ResponseBody void findByIdEdit (@PathVariable long id) {
        this.interfazServiceMarca.Delete(id);
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST,produces="application/json")
    public @ResponseBody void save (@RequestBody Marca marca) {

        this.interfazServiceMarca.save(marca);
    }


}
