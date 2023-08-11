package com.mik.minimarket.controller;


import com.mik.minimarket.entity.Cliente;

import com.mik.minimarket.entity.Producto;
import com.mik.minimarket.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteservice;


    public ClienteController() {
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        return new ResponseEntity<>(clienteservice.findAll(), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Cliente cliente)
    {

        clienteservice.insert(cliente);
        return new ResponseEntity<>("¡Cliente creado!",HttpStatus.CREATED);

    }


    @PutMapping("/editar/{clienteId}")
    public ResponseEntity<?> editar_PUT(@RequestBody Cliente clienteNew, @PathVariable Integer clienteId)
    {
        Cliente clienteDb=clienteservice.findById(clienteId);

        if(clienteDb!=null)
        {
            clienteDb.setNombre(clienteNew.getNombre());
            clienteDb.setApellido(clienteNew.getApellido());
            clienteDb.setTelefono(clienteNew.getTelefono());
            clienteDb.setDireccion(clienteNew.getDireccion());
            clienteDb.setEmail(clienteNew.getEmail());
            clienteDb.setPassword(clienteNew.getPassword());
            clienteDb.setAvatar(clienteNew.getAvatar());

            clienteservice.update(clienteDb);
            return new ResponseEntity<>("¡Cliente editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Cliente ID "+clienteId+" no encontrado!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{clienteId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer clienteId)
    {
        Cliente clienteDb=clienteservice.findById(clienteId);

        if(clienteDb!=null)
        {
            clienteservice.delete(clienteId);
            return new ResponseEntity<>("¡Cliente borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Cliente ID "+clienteId+" no encontrado!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{clienteId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer ClienteId)
    {
        Cliente ClienteDb=clienteservice.findById(ClienteId);

        if(ClienteDb!=null) {
            return new ResponseEntity<>(ClienteDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Cliente ID "+ClienteId+" no encontrado!",HttpStatus.NOT_FOUND);
    }



}
