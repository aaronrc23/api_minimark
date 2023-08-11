package com.mik.minimarket.service;

import com.mik.minimarket.entity.Categoria;


import java.util.Collection;

public interface CategoryService {

    public abstract void insert(Categoria categoria);
    public abstract void update(Categoria categoria);
    public abstract void delete(Long categoriaId);
    public abstract Categoria findById(Long categoriaId);
    public abstract Collection<Categoria> findAll();

    Long countByNombre(String nombre);



}
