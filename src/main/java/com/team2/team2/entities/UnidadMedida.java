package com.team2.team2.entities;

import jakarta.persistence.*;

//(BD)@Entity :CREA LA TABLA (Department) EN BASE EN LA CLASE  (Department)
@Entity
//@Table:CREO LA ENTIDAD (Department) EN LA BASE DE DATOS
@Table(name="UnidadMedida")
public class UnidadMedida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;
    //@Column crea la columna nombre
    @Column(name = "codigo")
    private long codigo;
    //@Column crea la columna nombre
    @Column(name = "unidad_medida")
    private String unidad_medida;
    @Column(name = "estado")
    private String estado;

    //SECCION 4__________________________________________CONTRUCTOR_______________________________________________________________


    public UnidadMedida() {
    }

    public UnidadMedida(long id, long codigo, String unidad_medida, String estado) {
        this.id = id;
        this.codigo = codigo;
        this.unidad_medida = unidad_medida;
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

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
