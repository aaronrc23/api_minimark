package com.mik.minimarket.serviceImpl;

import com.mik.minimarket.entity.Categoria;
import com.mik.minimarket.entity.Producto;
import com.mik.minimarket.repository.ProductoRepository;
import com.mik.minimarket.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;


@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repository;


    @Override
    public void insert(Producto producto) {
        repository.save(producto);
    }

    @Override
    public void update(Producto producto) {
        repository.save(producto);
    }

    @Override
    public void delete(Integer  productoId) {
        repository.deleteById(productoId);
    }

    @Override
    public Producto findById(Integer productoId) {
        return repository.findById(productoId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Producto> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public int isExistName(String nombre) {
        return repository.isExistName(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByCategoria(Categoria categoria) {
        return repository.findByCategoria(categoria);
    }


}
