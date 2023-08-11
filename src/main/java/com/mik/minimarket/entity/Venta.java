package com.mik.minimarket.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="ventas")
public class Venta implements Serializable {


    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idventa;

    @Column(unique=true,nullable=false)
    private Integer numdoc;

    @Column
    private String tipopago;
    @Column
    private Double total;


    @DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
    private LocalDate fecha;
    @Column
    private boolean estado;

    @ManyToOne
    @JoinColumn(name="cliente_id",nullable=false)
    private Cliente cliente;


    public Venta() {
    }


    public Venta(Integer idventa, Integer numdoc, String tipopago, Double total, LocalDate fecha, boolean estado) {
        this.idventa = idventa;
        this.numdoc = numdoc;
        this.tipopago = tipopago;
        this.total = total;
        this.fecha = fecha;
        this.estado = estado;
    }

    @PostPersist
    public void portPersist() {
        fecha=LocalDate.now();
    }



    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public Integer getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(Integer numdoc) {
        this.numdoc = numdoc;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
