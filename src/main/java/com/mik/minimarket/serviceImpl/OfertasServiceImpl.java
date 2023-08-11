package com.mik.minimarket.serviceImpl;


import com.mik.minimarket.entity.Ofertas;
import com.mik.minimarket.repository.OfertasRepository;
import com.mik.minimarket.service.OfertasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class OfertasServiceImpl implements OfertasService {

    @Autowired
    private OfertasRepository repository;

    @Override
    public void insert(Ofertas ofertas) {
        repository.save(ofertas);
    }

    @Override
    public void update(Ofertas ofertas) {
        repository.save(ofertas);
    }

    @Override
    public void delete(Integer ofertasId) {
        repository.deleteById(ofertasId);
    }

    @Override

    public Ofertas findById(Integer ofertaId) {
        return repository.findById(ofertaId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Ofertas> findAll() {
        return repository.findAll();
    }
}
