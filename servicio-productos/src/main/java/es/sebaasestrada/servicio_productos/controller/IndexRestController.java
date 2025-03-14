package es.sebaasestrada.servicio_productos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexRestController {

    @GetMapping
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("index of productos service.");
    }

}
