package com.mik.minimarket.service;
import com.mik.minimarket.entity.Venta;

import java.util.Collection;

public interface VentaService {

    public abstract void insert(Venta ventas);
    public abstract void update(Venta ventas);

    public abstract void actualizarEstadoVenta(Integer idVenta, boolean nuevoEstado);
    public abstract Venta findById(Integer idventa);
    public abstract Collection<Venta> findAll();

    public abstract int isExistName(String numdoc);
}
