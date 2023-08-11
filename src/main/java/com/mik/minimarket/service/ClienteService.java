package com.mik.minimarket.service;

import com.mik.minimarket.entity.Cliente;
import com.mik.minimarket.entity.Producto;

import java.util.Collection;

public interface ClienteService {

    public abstract void insert(Cliente cliente);
    public abstract void update(Cliente cliente);
    public abstract void delete(Integer clienteId);
    public abstract Cliente findById(Integer clienteId);
    public abstract Collection<Cliente> findAll();

    public abstract int isExistName(String email);
}
