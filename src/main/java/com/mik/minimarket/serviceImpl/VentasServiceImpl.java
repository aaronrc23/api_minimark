package com.mik.minimarket.serviceImpl;

import com.mik.minimarket.entity.Venta;
import com.mik.minimarket.repository.VentaRepository;
import com.mik.minimarket.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VentasServiceImpl implements VentaService {


    @Autowired
    private VentaRepository repository;



    @Override
    public void insert(Venta ventas) {

        repository.save(ventas);

    }

    @Override
    public void update(Venta ventas) {
        repository.save(ventas);
    }

    @Override
    public void actualizarEstadoVenta(Integer idVenta, boolean nuevoEstado) {
        Venta venta = repository.findById(idVenta).orElse(null);
        if (venta != null) {
            venta.setEstado(nuevoEstado);
            repository.save(venta);
        }
    }


    @Override
    public Venta findById(Integer idventa) {
        return repository.findById(idventa).orElse(null);
    }

    @Override
    public Collection<Venta> findAll() {
        return repository.findAll();
    }

    @Override
    public int isExistName(String numdoc) {
        return repository.isExistName(numdoc);
    }
}
