package com.mik.minimarket.controller;


import com.mik.minimarket.entity.Categoria;
import com.mik.minimarket.entity.Producto;
import com.mik.minimarket.service.CategoryService;
import com.mik.minimarket.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoryService categoriaService;

    public ProductoController() {
    }


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        return new ResponseEntity<>(productoService.findAll(),HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Producto producto)
    {

            productoService.insert(producto);
            return new ResponseEntity<>("¡Producto creado!",HttpStatus.CREATED);

    }

    @PutMapping("/editar/{productoId}")
    public ResponseEntity<?> editar_PUT(@RequestBody Producto productoNew,@PathVariable Integer productoId)
    {
        Producto productoDb=productoService.findById(productoId);

        if(productoDb!=null)
        {
            productoDb.setNombre(productoNew.getNombre());
            productoDb.setDescripcion(productoNew.getDescripcion());
            productoDb.setPrecio(productoNew.getPrecio());
            productoDb.setImagen(productoNew.getImagen());
            productoDb.setStock(productoNew.getStock());
            productoDb.setImagen(productoNew.getImagen());

            productoService.update(productoDb);
            return new ResponseEntity<>("¡Producto editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Producto ID "+productoId+" no encontrado!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{productoId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer productoId)
    {
        Producto productoDb=productoService.findById(productoId);

        if(productoDb!=null)
        {
            productoService.delete(productoId);
            return new ResponseEntity<>("¡Producto borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Producto ID "+productoId+" no encontrado!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{productoId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer productoId)
    {
        Producto productoDb=productoService.findById(productoId);

        if(productoDb!=null) {
            return new ResponseEntity<>(productoDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Producto ID "+productoId+" no encontrado!",HttpStatus.NOT_FOUND);
    }


    @GetMapping("/listarPorCategoria/{categoriaId}")
    public ResponseEntity<?> listarProductosPorCategoria(@PathVariable Long categoriaId) {
        Categoria categoria = categoriaService.findById(categoriaId);

        if (categoria != null) {
            List<Producto> productos = productoService.findByCategoria(categoria);
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("¡Categoría no encontrada!", HttpStatus.NOT_FOUND);
        }
    }
}
