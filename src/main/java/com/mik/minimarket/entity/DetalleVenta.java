package com.mik.minimarket.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="detalleventa")
public class DetalleVenta implements Serializable {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddetalle;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;


    @Column
    private Integer cantidad;
    @Column
    private Double precio;


    public DetalleVenta() {
    }

    public DetalleVenta(Integer iddetalle, Integer cantidad, Double precio) {
        this.iddetalle = iddetalle;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(Integer iddetalle) {
        this.iddetalle = iddetalle;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
