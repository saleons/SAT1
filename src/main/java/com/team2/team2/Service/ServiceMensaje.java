package com.team2.team2.Service;

import com.team2.team2.entities.Mensaje;
import com.team2.team2.entities.Producto;
import com.team2.team2.repositories.InterfazBaseMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceMensaje implements InterfazServiceMensaje {
    @Autowired
    private InterfazBaseMensaje interfazBaseMensaje;
    @Autowired
    private InterfazServiceProdutos interfazServiceProdutos;

    @Override
    public Mensaje finbyid(long id) throws ParseException {

        Mensaje proceso= this.interfazBaseMensaje.findByid(id);
        if (proceso== null){



            Mensaje proceso1= new Mensaje("","","","","");
            return proceso1;
        }else{
            return proceso;
        }
    }
    @Override
    public List<Mensaje> findAll(){
        List<Mensaje> listdeMarca=this.interfazBaseMensaje.findAll();
        return listdeMarca;
    }
    @Override
    public void Delete(long id) {
        this.interfazBaseMensaje.deleteById(id);

    }
    @Override
    public void save(Mensaje mensaje) {
        this.interfazBaseMensaje.save(mensaje);
    }

    @Override
    public List<Mensaje> findBynombre(String nombre){
        //Producto producto= new Producto(1,"zapatos","zapato de cuero",1,23000,"","2015-03-31","2015-03-31","agotado");
        List<Mensaje> MensajeUser= interfazBaseMensaje.findByusuariorecibe(nombre);
        return MensajeUser;
    }
    @Override
    public List<Mensaje> findByConversa(String nombre){
       List<Mensaje> MensajeConversa= interfazBaseMensaje.findByConversa(nombre);
        return MensajeConversa;
    }

    @Override
    public List<Mensaje> findByConversalastMessage(String nombre){

        List<Mensaje> findByConversalastMessage=interfazBaseMensaje.findByConversalastMessage(nombre);
        return findByConversalastMessage;
    }


    @Override
    public List<Producto> findMessagesNotRespons() {
        //LLAMO CADA USUARIO REGISTRADO
        List<Producto> findallProduct = interfazServiceProdutos.findAll();


        //RECOORO CADA USUARIO
        List<Producto> miLista = null;
        for (Producto producto : findallProduct) {

            //HAGO LA CONSULTA DEL ULTIMO MENSAJE POR USUARIO
            Mensaje findMessagesNotRespons = interfazBaseMensaje.findLastMessagesNotResponsByName(producto.getNombre());

            //VERIFICO SI LA CONSULTA ES DIFERENTE A NULL
            if (findMessagesNotRespons != null) {

                //CAMBIO EL ESTADO DEL USUARIO A Q TIEN UN MENSAJE PENDIENTE
                //miLista.add(findMessagesNotRespons);

                Producto producto2 = new Producto(producto.getId(), producto.getNombre(), producto.getDescripcion(), 10,
                        producto.getPrecio(), producto.getImagen(), producto.getFechaCreacion(),
                        producto.getFechaModificacion(), producto.getEstado(), producto.getCategoria()
                        , producto.getMarca(), producto.getUnidadMedida(),
                        producto.getProceso());

                interfazServiceProdutos.save(producto2);

                miLista = interfazServiceProdutos.findAlertByMessageNotResponset();

            }
        }
        return miLista;
    }
}