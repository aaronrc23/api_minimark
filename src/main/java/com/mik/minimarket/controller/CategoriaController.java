package com.mik.minimarket.controller;


import com.mik.minimarket.entity.Categoria;

import com.mik.minimarket.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoryService categoriaService;

    public CategoriaController() {
    }


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        return new ResponseEntity<>(categoriaService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Categoria categoria)
    {
        Long isExist = categoriaService.countByNombre(categoria.getNombre());

        if (isExist == 0) {
            categoriaService.insert(categoria);
            return new ResponseEntity<>("¡Categoría creada!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("¡La categoría no se puede registrar porque " + categoria.getNombre().toUpperCase() + " ya existe!", HttpStatus.CONFLICT);
        }

    }

    @PutMapping("/editar/{categoriaId}")
    public ResponseEntity<?> editar_PUT(@RequestBody Categoria categoriaNew,@PathVariable Long categoriaId)
    {
        Categoria categoriaDb=categoriaService.findById(categoriaId);

        if(categoriaDb!=null)
        {
            categoriaDb.setNombre(categoriaNew.getNombre());
            categoriaDb.setDescripcion(categoriaNew.getDescripcion());
            categoriaDb.setImagen(categoriaNew.getImagen());
            categoriaService.update(categoriaDb);
            return new ResponseEntity<>("¡Producto editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Producto ID "+categoriaId+" no encontrado!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{categoriaId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Long categoriaId)
    {
        Categoria categoriaDb=categoriaService.findById(categoriaId);

        if(categoriaDb!=null)
        {
            categoriaService.delete(categoriaId);
            return new ResponseEntity<>("¡Producto borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Producto ID "+categoriaId+" no encontrado!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{categoriaId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Long categoriaId)
    {
        Categoria categoriaDb=categoriaService.findById(categoriaId);

        if(categoriaDb!=null) {
            return new ResponseEntity<>(categoriaDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Categoria ID "+categoriaId+" no encontrado!",HttpStatus.NOT_FOUND);
    }



}
