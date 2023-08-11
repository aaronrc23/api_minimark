package com.mik.minimarket.service;

import com.mik.minimarket.entity.Ofertas;


import java.util.Collection;

public interface OfertasService {

    public abstract void insert(Ofertas ofertas);
    public abstract void update(Ofertas ofertas);
    public abstract void delete(Integer ofertasId);
    public abstract Ofertas findById(Integer ofertaId);
    public abstract Collection<Ofertas> findAll();

}
