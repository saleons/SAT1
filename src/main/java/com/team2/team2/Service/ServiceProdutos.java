package com.team2.team2.Service;

import com.team2.team2.entities.*;
import com.team2.team2.repositories.InterfazBaseproductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceProdutos implements InterfazServiceProdutos {
    @Autowired
    private InterfazBaseproductos interfazBaseproductos;

    public Producto finbyid(long id) {
        //Producto producto= new Producto(1,"zapatos","zapato de cuero",1,23000,"","2015-03-31","2015-03-31","agotado");
        Producto producto = this.interfazBaseproductos.findByid(id);
        if (producto == null) {
            Mensaje proceso = new Mensaje("", "", "", "", "");
            UnidadMedida unidadMedida = new UnidadMedida(0, 0, "", "");
            Marca marca1 = new Marca("", "");
            Categoria categoria1 = new Categoria(0, 0, "", "", "", "");
            Producto producto1 = new Producto(0, "no encontrado", "", 0, 0, "", "", "", "", categoria1, marca1, unidadMedida, proceso);
            return producto1;
        } else {
            return producto;
        }
    }


    @Override
    public List<Producto> findBynombre(String nombre) {
        //Producto producto= new Producto(1,"zapatos","zapato de cuero",1,23000,"","2015-03-31","2015-03-31","agotado");
        List<Producto> productoUser = interfazBaseproductos.findBynombre(nombre);
        return productoUser;

    }


    @Override
    public List<Producto> findAll() {
        List<Producto> listdeproducto = interfazBaseproductos.findAll();

        return listdeproducto;
    }

    @Override
    public void Delete(long id) {
        this.interfazBaseproductos.deleteById(id);
    }


    @Override
    public String save(Producto producto) {
        //primero grabar usuario o verificar

        if (findBynombre(producto.getNombre()).size() != 0) {
            Producto alert1 = this.interfazBaseproductos.findLastAlert(producto.getNombre());

            //nuevo objeto a actulizar
            Producto alert2 = new Producto();
            alert2.setId(alert1.getId());
            alert2.setNombre(alert1.getNombre());
            alert2.setDescripcion(producto.getDescripcion());
            alert2.setCantidad(producto.getCantidad());
            alert2.setPrecio(alert1.getPrecio());
            alert2.setImagen(alert1.getImagen());
            alert2.setFechaCreacion(alert1.getFechaCreacion());
            alert2.setFechaModificacion(producto.getFechaModificacion());
            alert2.setEstado(producto.getEstado());
            alert2.setCategoria(alert1.getCategoria());
            alert2.setMarca(alert1.getMarca());
            alert2.setUnidadMedida(alert1.getUnidadMedida());
            alert2.setProceso(alert1.getProceso());


            this.interfazBaseproductos.save(alert2);
            System.out.println("editado");
            return "editado";
        } else {
            this.interfazBaseproductos.save(producto);
            System.out.println("grabado");
            return "grabado";

        }

    }

    @Override
    public List<Producto> findAlertByTime() {
        List<Producto> listdeproducto = interfazBaseproductos.findAlertByTime();

        return listdeproducto;
    }

    //METODOQ QUE FILTRA LAS ALERTAS QUE TENGA UN DIA DE ENVIADAS
    @Override
    public List<Producto> findAlertByTimebyHour() {
        List<Producto> listdeproducto = interfazBaseproductos.findAlertByTime();

        System.out.println(listdeproducto.size());
        List<Producto> LitHour = new ArrayList<>();
        for (Producto producto : listdeproducto) {

            LocalDateTime now = LocalDateTime.now();
            int hoy = now.getDayOfYear();
            int ayer =hoy-1;
            System.out.println("w+");
            System.out.println(hoy);
            System.out.println(producto.getfechaActualizacion());
            System.out.println(producto.getfechageneraion());

            if (producto.getfechaActualizacion() != null) {
                LocalDateTime localDateTime = producto.getfechaActualizacion();
                int diaalert = localDateTime.getDayOfYear();
                System.out.println("w+2");
                System.out.println(diaalert);
                if (diaalert >= ayer) {
                    System.out.println("entra2");
                    LitHour = new ArrayList<>();
                    LitHour.add(producto);
                }
                System.out.println("-----------------------------------");
                }
            else {
                LocalDateTime localDateTime1 = producto.getfechageneraion();
                int diaalert = localDateTime1.getDayOfYear();
                System.out.println("w-2");
                System.out.println(diaalert);

                if (diaalert >= ayer) {
                    System.out.println("entra1");

                    LitHour.add(producto);
                }
                System.out.println("-----------------------------------");
            }
        }

        System.out.println("-----------------------------------");
        System.out.println(LitHour.size());

        return LitHour;
    }

    @Override
    public List<Producto> findAlertByMessageNotResponset() {
        List<Producto> productos=interfazBaseproductos.findAlertByMessageNotResponset();

        return productos;
    }
}
