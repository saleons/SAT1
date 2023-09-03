package com.team2.team2.entities;

import jakarta.persistence.*;

//(BD)@Entity :CREA LA TABLA (Department) EN BASE EN LA CLASE  (Department)
@Entity
//@Table:CREO LA ENTIDAD (Department) EN LA BASE DE DATOS
@Table(name="Marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;
    //@Column crea la columna nombre
    @Column(name = "marca")
    private String marca;
    //@Column crea la columna nombre
    @Column(name = "estado")
    private String estado;

    //SECCION 3________________________________CARDINALIDA O LLAVES FORENAEAS________________________________________________________________



    //SECCION 4__________________________________________CONTRUCTOR_______________________________________________________________

    public Marca() {
    }

    public Marca( String marca, String estado) {

        this.marca = marca;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
