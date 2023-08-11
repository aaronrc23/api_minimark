package com.mik.minimarket.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer clienteId;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String telefono;

    @Column
    private String direccion;

    @Column(unique=true,nullable=false)
    private String email;

    @Column
    private String password;

    @Lob
    @JsonIgnore
    private Blob avatar;

    @OneToMany(mappedBy="cliente")
    @JsonIgnore
    private Collection<Venta> itemsCliente=new ArrayList<>();


    public Cliente() {
    }


    public Cliente(Integer clienteId, String nombre, String apellido, String telefono, String direccion, String email, String password, Blob avatar) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
    }


    public Collection<Venta> getItemsCliente() {
        return itemsCliente;
    }

    public void setItemsCliente(Collection<Venta> itemsCliente) {
        this.itemsCliente = itemsCliente;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }
}

