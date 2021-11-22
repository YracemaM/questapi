package ar.com.ada.api.questinados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.questinados.entities.Categoria;
import ar.com.ada.api.questinados.models.response.GenericResponse;
import ar.com.ada.api.questinados.services.CategoriaService;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> traerCategorias() {
        
        return ResponseEntity.ok(service.traerCategorias());
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<?> traerCategoriaPorId(@PathVariable Integer id) {

        GenericResponse respuesta = new GenericResponse();

        if(service.existePorId(id)) {

            return ResponseEntity.ok(service.buscarCategoriaPorId(id));

        } else {

            respuesta.isOk = false;
            respuesta.message = "La categoria no existe";

            return ResponseEntity.badRequest().body(respuesta);
        }
    }

    @PostMapping(value = "/categorias")
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria) {

        GenericResponse respuesta = new GenericResponse();

        if(service.crearCategoria(categoria)) {

            respuesta.id = categoria.getCategoriaId();
            respuesta.isOk = true;
            respuesta.message = "Categoria creada con exito";

            return ResponseEntity.ok(respuesta);

        } else {

            respuesta.isOk = false;
            respuesta.message = "Esta categoria ya esta creada";

            return ResponseEntity.badRequest().body(respuesta);
        }
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<?> eliminarCategoriaPorId(@PathVariable Integer id) {

        GenericResponse respuesta = new GenericResponse();

        if(service.eliminarCategoriaPorId(id)) {

            respuesta.isOk = true;
            respuesta.message = "La categoria fue eliminada";

            return ResponseEntity.ok(respuesta);

        } else {

            respuesta.isOk = false;
            respuesta.message = "Ocurrio un error al intentar ejecutar la solicitud";

            return ResponseEntity.badRequest().body(respuesta);
        }
    }
    
}
