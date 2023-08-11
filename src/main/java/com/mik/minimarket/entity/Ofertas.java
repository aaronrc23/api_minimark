package com.mik.minimarket.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="ofertas")
public class Ofertas implements Serializable {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ofertaId;
    @Column
    private String imagen;
    @Column
    private String titulo;

    @DateTimeFormat(pattern="yyyy-MM-dd",iso= DateTimeFormat.ISO.DATE)
    private LocalDate fecha;

    public Ofertas() {
    }

    public Ofertas(Integer ofertaId, String imagen, String titulo, LocalDate fecha) {
        this.ofertaId = ofertaId;
        this.imagen = imagen;
        this.titulo = titulo;
        this.fecha = fecha;
    }

    @PostPersist
    public void portPersist() {
        fecha=LocalDate.now();
    }

    public Integer getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(Integer ofertaId) {
        this.ofertaId = ofertaId;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
