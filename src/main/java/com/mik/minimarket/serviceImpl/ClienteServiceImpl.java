package com.mik.minimarket.serviceImpl;


import com.mik.minimarket.entity.Cliente;
import com.mik.minimarket.repository.ClienteRepository;
import com.mik.minimarket.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;


    @Override
    public void insert(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void delete(Integer clienteId) {
        repository.deleteById(clienteId);
    }

    @Override
    public Cliente findById(Integer clienteId) {
       return repository.findById(clienteId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public int isExistName(String email) {
        return repository.isExistName(email);
    }
}
