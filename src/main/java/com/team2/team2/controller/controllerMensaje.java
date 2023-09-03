package com.team2.team2.controller;


import com.team2.team2.Service.InterfazServiceMensaje;
import com.team2.team2.entities.Mensaje;
import com.team2.team2.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController

//@RequestMapping: define le URL donde se hara la peticion (http://localhost:8080/productos"/(end poit al que deseo ingresar))
@RequestMapping("proceso")
public class controllerMensaje {
    @Autowired
    private InterfazServiceMensaje interfazServiceMensaje;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces="application/json")

    public @ResponseBody Mensaje findById (@PathVariable long id) throws ParseException {

        return this.interfazServiceMensaje.finbyid(id);
    }
    @RequestMapping(value = "/all",method = RequestMethod.GET,produces="application/json")

    public @ResponseBody List<Mensaje> findAll () {
        List<Mensaje> listaProceso=this.interfazServiceMensaje.findAll();
        return listaProceso;
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET,produces="application/json")
    public @ResponseBody void findByIdEdit (@PathVariable long id) {

        this.interfazServiceMensaje.Delete(id);
    }

    @RequestMapping(value = "/saveMeseger",method = RequestMethod.POST,produces="application/json")
    public @ResponseBody void save (@RequestBody Mensaje proceso) {

        this.interfazServiceMensaje.save(proceso);
    }
    @RequestMapping(value = "/findMeseger/{correo}",method = RequestMethod.GET,produces="application/json")

    public @ResponseBody List<Mensaje> findAlli (@PathVariable String correo) {
        List<Mensaje> listaProceso=this.interfazServiceMensaje.findByConversa(correo);
        return listaProceso;
    }

    @RequestMapping(value = "/findMesegerLastAlertAll/{correo}",method = RequestMethod.GET,produces="application/json")

    public @ResponseBody List<Mensaje> findMesegerLastAlertAll (@PathVariable String correo) {
        List<Mensaje> listaProceso=this.interfazServiceMensaje.findByConversalastMessage(correo);

        return listaProceso;}

    @RequestMapping(value = "/findMessagesNotRespons",method = RequestMethod.GET,produces="application/json")

    public @ResponseBody List<Producto> findMessagesNotRespons () {
        List<Producto> listaProceso=this.interfazServiceMensaje.findMessagesNotRespons();

        return listaProceso;
    }


}
