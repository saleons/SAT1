package com.team2.team2.Service;

import com.team2.team2.entities.Categoria;
import com.team2.team2.repositories.InterfazBaseCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceCategoria implements InterfazServiceCategoria{
    @Autowired
    private InterfazBaseCategoria interfazBaseCategoria;

    @Override
    public Categoria finbyid(long id){

        Categoria categoria= this.interfazBaseCategoria.findByid(id);
        if (categoria== null){
            Categoria categoria1= new Categoria(0,0,"","","","");
            return categoria1;
        }else{
            return categoria;
        }
    }
    @Override
    public List<Categoria> findAll(){
        List<Categoria> listdeproducto=this.interfazBaseCategoria.findAll();
        return listdeproducto;
    }
    @Override
    public void Delete(long id) {
        this.interfazBaseCategoria.deleteById(id);
    }
    @Override
    public void save(Categoria categoria) {
        this.interfazBaseCategoria.save(categoria);
    }

}
