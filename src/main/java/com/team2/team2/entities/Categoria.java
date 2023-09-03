package com.team2.team2.entities;

import jakarta.persistence.*;
@Entity
//@Table:CREO LA ENTIDAD (Users) EN LA BASE DE DATOS
@Table(name="Categoria")

public class Categoria {
    //SECCION 2__________________________________________ATRIBUTOS_________________________________________________________________

    //@Id :SEÑALA QUE EL ATRIBUTO DESPUES ES LA PRIMARY KEY
    @Id
    //@GeneratedValue :LE DA UN VALOR AUTOMATICO AL ATRIBUTO DEACUERDO A UN FUNCION EN ESTA CASO AUTO INCREMENTANDO
    @GeneratedValue(strategy = GenerationType.AUTO )
    //id :CONTIENE LO DEFINIDO EN @Id Y @GeneratedValue
    private long id;
    @Column(name = "codigo" , unique = true)
    private long codigo;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "fecha_creacion")
    private String fecha_creacion;
    @Column(name = "fecha_modidficaion")
    private String fecha_modidficaion;
    @Column(name = "estado")
    private String estado;
    //SECCION 3________________________________CARDINALIDA O LLAVES FORENAEAS________________________________________________________________


    public Categoria() {
    }

    public Categoria(long id, long codigo, String categoria, String fecha_creacion, String fecha_modidficaion, String estado) {
        this.id = id;
        this.codigo = codigo;
        this.categoria = categoria;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modidficaion = fecha_modidficaion;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getFecha_modidficaion() {
        return fecha_modidficaion;
    }

    public void setFecha_modidficaion(String fecha_modidficaion) {
        this.fecha_modidficaion = fecha_modidficaion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}




