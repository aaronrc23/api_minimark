package com.mik.minimarket.serviceImpl;

import com.mik.minimarket.entity.Categoria;
import com.mik.minimarket.repository.CategoriaRepository;

import com.mik.minimarket.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Service
public class CategoriaServiceImpl implements CategoryService {

    @Autowired
    private CategoriaRepository repository;


    @Override
    @Transactional
    public void insert(Categoria categoria) {
        repository.save(categoria);
    }

    @Override
    @Transactional
    public void update(Categoria categoria) {
        repository.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Long categoriaId) {
        repository.deleteById(categoriaId);

    }

    @Override
    @Transactional(readOnly=true)
    public Categoria findById(Long categoriaId) {
        return repository.findById(categoriaId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Categoria> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Long countByNombre(String nombre) {
        return repository.countByNombre(nombre);
    }
}
