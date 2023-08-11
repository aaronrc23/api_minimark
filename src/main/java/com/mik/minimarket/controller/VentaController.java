package com.mik.minimarket.controller;


import com.mik.minimarket.entity.Producto;
import com.mik.minimarket.entity.Venta;
import com.mik.minimarket.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    public VentaController() {
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        return new ResponseEntity<>(ventaService.findAll(), HttpStatus.OK);
    }


    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Venta venta)
    {

       ventaService.insert(venta);
        return new ResponseEntity<>("¡Boleta creada!",HttpStatus.CREATED);

    }

    @PutMapping("/editar/{idventa}")
    public ResponseEntity<?> editar_PUT(@RequestBody Venta ventaNew,@PathVariable Integer idventa)
    {
       Venta ventaDb=ventaService.findById(idventa);

        if(ventaDb!=null)
        {
            ventaDb.setNumdoc(ventaNew.getNumdoc());
            ventaDb.setTipopago(ventaNew.getTipopago());
            ventaDb.setTotal(ventaNew.getTotal());
            ventaDb.setEstado(ventaNew.isEstado());

            ventaService.update(ventaDb);
            return new ResponseEntity<>("¡Venta editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Venta ID "+idventa+" no encontrado!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{idventa}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer idventa) {
        Venta ventaDb = ventaService.findById(idventa);

        if (ventaDb != null) {
            ventaService.actualizarEstadoVenta(idventa, false); // Cambia el estado a false (borrado lógico)
            return new ResponseEntity<>("¡Venta borrada!", HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Venta ID " + idventa + " no encontrada!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{idventa}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer idventa)
    {
        Venta ventaDb=ventaService.findById(idventa);

        if(ventaDb!=null) {
            return new ResponseEntity<>(ventaDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Venta ID "+idventa+" no encontrado!",HttpStatus.NOT_FOUND);
    }

}
