package com.mik.minimarket.controller;


import com.mik.minimarket.entity.Cliente;
import com.mik.minimarket.entity.Ofertas;
import com.mik.minimarket.service.OfertasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ofertas")
public class OfertasController {

    @Autowired
    private OfertasService ofertasService;

    public OfertasController() {
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        return new ResponseEntity<>(ofertasService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Ofertas ofertas)
    {

        ofertasService.insert(ofertas);
        return new ResponseEntity<>("¡Oferta creada!",HttpStatus.CREATED);

    }

    @PutMapping("/editar/{ofertaId}")
    public ResponseEntity<?> editar_PUT(@RequestBody Ofertas ofertaNew, @PathVariable Integer ofertaId)
    {
        Ofertas ofertaDb=ofertasService.findById(ofertaId);

        if(ofertaDb!=null)
        {
            ofertaDb.setTitulo(ofertaNew.getTitulo());
            ofertaDb.setImagen(ofertaNew.getImagen());

            ofertasService.update(ofertaDb);
            return new ResponseEntity<>("¡Oferta editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Oferta ID "+ofertaId+" no encontrado!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{ofertaId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer ofertaId)
    {
        Ofertas ofertasDb=ofertasService.findById(ofertaId);

        if(ofertasDb!=null)
        {
            ofertasService.delete(ofertaId);
            return new ResponseEntity<>("¡Oferta borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Oferta ID "+ofertaId+" no encontrado!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{ofertaId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer ofertaId)
    {
        Ofertas ofertaDb=ofertasService.findById(ofertaId);

        if(ofertaDb!=null) {
            return new ResponseEntity<>(ofertaDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Oferta ID "+ofertaDb+" no encontrado!",HttpStatus.NOT_FOUND);
    }

}
