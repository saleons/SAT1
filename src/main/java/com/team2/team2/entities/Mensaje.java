package com.team2.team2.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

//(BD)@Entity :CREA LA TABLA (Department) EN BASE EN LA CLASE  (Department)
@Entity
//@Table:CREO LA ENTIDAD (Department) EN LA BASE DE DATOS
@Table(name="Proceso")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;
    //@Column crea la columna nombre
    @Column(name = "usuarioenvia")
    private String usuarioenvia;
    @Column(name = "usuariorecibe")
    private String usuariorecibe;
    @Column(name = "tipo")
    private String tipo;
    //@Column crea la columna nombre
    @Column(name = "mensaje")
    private String mensaje;
    @Column(name = "fecha")
    private String fecha;


    private LocalDateTime fechageneraion;


    private LocalDateTime fechaActualizacion;

    public Mensaje() {
    }

    public Mensaje(String usuarioenvia, String usuariorecibe, String tipo, String mensaje, String fecha) {
        this.usuarioenvia = usuarioenvia;
        this.usuariorecibe = usuariorecibe;
        this.tipo = tipo;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuarioenvia() {
        return usuarioenvia;
    }

    public void setUsuarioenvia(String usuarioenvia) {
        this.usuarioenvia = usuarioenvia;
    }

    public String getUsuariorecibe() {
        return usuariorecibe;
    }

    public void setUsuariorecibe(String usuariorecibe) {
        this.usuariorecibe = usuariorecibe;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public LocalDateTime getfechageneraion() {
        return fechageneraion;
    }
    public LocalDateTime getfechaActualizacion() {
        return fechaActualizacion;
    }

    @PrePersist
    protected void onCreate() {
        fechageneraion = LocalDateTime.now(ZoneId.of("America/Bogota"));
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now(ZoneId.of("America/Bogota"));
    }

}
