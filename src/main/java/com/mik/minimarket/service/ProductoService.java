package com.mik.minimarket.service;

import com.mik.minimarket.entity.Categoria;
import com.mik.minimarket.entity.Producto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


public interface ProductoService {

    public abstract void insert(Producto producto);
    public abstract void update(Producto producto);
    public abstract void delete(Integer productoId);
    public abstract Producto findById(Integer productoId);
    public abstract Collection<Producto> findAll();

    public abstract int isExistName(String nombre);


    /*cammbio*/
    List<Producto> findByCategoria(Categoria categoria);



}
