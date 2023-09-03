package com.team2.team2.controller;

import com.team2.team2.Service.InterfazServiceMarca;
import com.team2.team2.Service.InterfazServiceMensaje;
import com.team2.team2.Service.InterfazServiceProdutos;
import com.team2.team2.entities.Marca;
import com.team2.team2.entities.Mensaje;
import com.team2.team2.entities.MyModelObject;
import com.team2.team2.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@Controller
public class FrontController {
    public String correo= null;


    //_______________________________________________SERVIIOS__________________________________________________________
    ////@Autowired: TRAE INTERFAZ DEL IserviceUsers  (BASE DE DATOS) y pordebajo toda la logica de ImpleServicesUsers


    @Autowired
    private InterfazServiceProdutos interfazServiceProdutos;
    @Autowired
    private InterfazServiceMarca interfazServiceMarca;

    @Autowired
    private InterfazServiceMensaje interfazServiceMensaje;



    //CREO EL OBJETO CCON EL SE VAN LLEVAR ENVIAR MENSAJES
    MyModelObject mymodelobject = new MyModelObject();


    //_______________________________________________METODOS__________________________________________________________

    @GetMapping("/")
    //@ResponseBody para indicar que el resultado del método lo vuelque en el cuerpo de la respuesta.
    public String home(Model model){
        ModelAndView modelAndView = new ModelAndView();


        // Aquí puedes establecer las propiedades de mymodelobject
        model.addAttribute("mymodelobject", mymodelobject);

        //mando lo usuarios con alarmas
        List<Producto> producto1=this.interfazServiceProdutos.findAll();
        model.addAttribute("producto1", producto1);

        //mando lo tipos de alertas
        List<Marca> marca=this.interfazServiceMarca.findAll();
        model.addAttribute("marca", marca);

        //lleno los mensajes para todos los usuarios
        List<Mensaje> mensaje =this.interfazServiceMensaje.findAll();

        model.addAttribute("mensaje", mensaje);

        //envio las alertas ORDENADAS por tiempo
        List<Producto> AlertByTime =this.interfazServiceProdutos.findAlertByTime();
        model.addAttribute("AlertByTime", AlertByTime);

        //envio al mapa usuarios con alertas de un dia de retrazo
        List<Producto> findAlertByTimebyHour =this.interfazServiceProdutos.findAlertByTimebyHour();
        model.addAttribute("findAlertByTimebyHoure", findAlertByTimebyHour);

        //Buscar usuarios con mensajes pendintes
        List<Producto> findMessagesNotRespons =this.interfazServiceMensaje.findMessagesNotRespons();
        model.addAttribute("findMessagesNotRespons", findMessagesNotRespons);




        if (correo==null){
            System.out.println("ninguna consulta");
            List<Mensaje> mensajeuser =this.interfazServiceMensaje.findBynombre(correo);
            model.addAttribute("mensajeuser", mensajeuser);

        }
        else {
            System.out.println(" consulta");
            System.out.println(correo);
            List<Mensaje> mensajeuser =this.interfazServiceMensaje.findByConversa(correo);
            model.addAttribute("mensajeuser", mensajeuser);

        }

        return "index";
    }

    @PostMapping("/sendMensagueAll")
    public String sendMensagueAll(@RequestParam(name = "myid") String myid, @RequestParam(name = "marca") String marca) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String formattedDate = format.format(date);
        Mensaje mensaje1= new Mensaje("ADMIN","TODOS",marca,myid,formattedDate);
        interfazServiceMensaje.save(mensaje1);

        return "redirect:/";
    }
    @PostMapping("/sendMensagueUser")
    public String sendMensagueUser(@RequestParam(name = "miInput") String miInput,@RequestParam(name = "myid") String myid, @RequestParam(name = "marca") String marca) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String formattedDate = format.format(date);
        Mensaje mensaje1= new Mensaje("ADMIN",miInput,marca,myid,formattedDate);
        interfazServiceMensaje.save(mensaje1);
        correo=miInput;

        return "redirect:/";
    }





}
