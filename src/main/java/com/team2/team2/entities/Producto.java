package com.team2.team2.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

//(BD)@Entity :CREA LA TABLA (Department) EN BASE EN LA CLASE  (Department)
@Entity
//@Table:CREO LA ENTIDAD (Department) EN LA BASE DE DATOS
@Table(name="Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;
    //@Column crea la columna nombre
    @Column(name = "nombre")
    private String nombre;
    //@Column crea la columna nombre
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad")
    private long cantidad;
    @Column(name = "precio")
    private long precio;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "fechaCreacion")
    private String fechaCreacion;
    @Column(name = "fechaModificacion")
    private String fechaModificacion;
    @Column(name = "estado")
    private String estado;

    private LocalDateTime fechageneraion;


    private LocalDateTime fechaActualizacion;

    //SECCION 3.1________________________________CARDINALIDA O LLAVES FORENAEAS________________________________________________________________


    //ManyToOne: DEFINICION  Many: muchas facturas (la clase facturas)
    //ManyToOne: DEFINICION  One: un Usuario (la variable Users)
    @ManyToOne
    //COLUMNA LLAVE FORANES (FK)
    @JoinColumn(name = "Producto_Categoria")
    //UNIDO AL OBJETO Users que es una entidad
    private Categoria categoria;

    //SECCION 3.2________________________________CARDINALIDA O LLAVES FORENAEAS________________________________________________________________


    //ManyToOne: DEFINICION  Many: muchas facturas (la clase facturas)
    //ManyToOne: DEFINICION  One: un Usuario (la variable Users)
    @ManyToOne
    //COLUMNA LLAVE FORANES (FK)
    @JoinColumn(name = "Producto_Marca")
    //UNIDO AL OBJETO Users que es una entidad
    private Marca marca;

    //SECCION 3.2________________________________CARDINALIDA O LLAVES FORENAEAS________________________________________________________________


    //ManyToOne: DEFINICION  Many: muchas facturas (la clase facturas)
    //ManyToOne: DEFINICION  One: un Usuario (la variable Users)
    @ManyToOne
    //COLUMNA LLAVE FORANES (FK)
    @JoinColumn(name = "Producto_Unidad")
    //UNIDO AL OBJETO Users que es una entidad
    private UnidadMedida unidadMedida;

    //SECCION 3.2________________________________CARDINALIDA O LLAVES FORENAEAS________________________________________________________________


    //ManyToOne: DEFINICION  Many: muchas facturas (la clase facturas)
    //ManyToOne: DEFINICION  One: un Usuario (la variable Users)
    @ManyToOne
    //COLUMNA LLAVE FORANES (FK)
    @JoinColumn(name = "Producto_Procso")
    //UNIDO AL OBJETO Users que es una entidad
    private Mensaje proceso;

    //SECCION 4__________________________________________CONTRUCTOR_______________________________________________________________


    public Producto(){};

    public Producto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Producto(long id, String nombre, String descripcion, long cantidad, long precio, String imagen, String fechaCreacion, String fechaModificacion, String estado, Categoria categoria, Marca marca, UnidadMedida unidadMedida, Mensaje proceso) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.imagen = imagen;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.estado = estado;
        this.categoria = categoria;
        this.marca = marca;
        this.unidadMedida = unidadMedida;
        this.proceso = proceso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Mensaje getProceso() {
        return proceso;
    }

    public void setProceso(Mensaje proceso) {
        this.proceso = proceso;
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
