package es.sebaasestrada.servicio_ventas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexRestController {

    @GetMapping
    public String index() {
        return "Index of servicio-ventas";
    }

}
