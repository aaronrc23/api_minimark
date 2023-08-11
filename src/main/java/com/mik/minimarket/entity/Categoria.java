package com.mik.minimarket.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @Column(unique = true, nullable = false)
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private String imagen;


    @OneToMany(mappedBy="categoria")
    @JsonIgnore
    private Collection<Producto> itemsProducto=new ArrayList<>();

    public Categoria() {

    }

    public Categoria(Long idCategoria, String nombre, String descripcion, String imagen) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Producto> getItemsProducto() {
        return itemsProducto;
    }




    public void setItemsProducto(Collection<Producto> itemsProducto) {
        this.itemsProducto = itemsProducto;
    }
}
