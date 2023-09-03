package com.team2.team2.Service;

import com.team2.team2.entities.UnidadMedida;
import com.team2.team2.repositories.InterfazBaseUnidadMedida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceUnidadMedida implements InterfazServiceUnidadMedida {
    @Autowired
    private InterfazBaseUnidadMedida interfazBaseUnidadMedida;
    public UnidadMedida finbyid(long id){
        //Producto producto= new Producto(1,"zapatos","zapato de cuero",1,23000,"","2015-03-31","2015-03-31","agotado");
        UnidadMedida unidadMedida= this.interfazBaseUnidadMedida.findByid(id);
        if (unidadMedida== null){
            UnidadMedida unidadMedida1= new UnidadMedida(0,0,"","");
            return unidadMedida1;
        }else{
            return unidadMedida;
        }
    }
    @Override
    public List<UnidadMedida> findAll(){
        List<UnidadMedida> listdeUnidades=interfazBaseUnidadMedida.findAll();

        return listdeUnidades;
    }

    @Override
    public void Delete(long id) {
        this.interfazBaseUnidadMedida.deleteById(id);
    }
    @Override
    public void save(UnidadMedida unidadMedida) {
        this.interfazBaseUnidadMedida.save(unidadMedida);
    }
}
