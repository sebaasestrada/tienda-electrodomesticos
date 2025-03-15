package es.sebaasestrada.servicio_carrito_compras.controller;

import es.sebaasestrada.servicio_carrito_compras.model.CarritoCompra;
import es.sebaasestrada.servicio_carrito_compras.service.ICarritoCompraService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class CarritoCompraRestController {
    private final ICarritoCompraService carritoService;

    public CarritoCompraRestController(ICarritoCompraService carritoService) {
        this.carritoService = carritoService;
    }

    @PostMapping("/crear")
    public String crearCarrito(@RequestBody ArrayList<Long> codigosProductos) {
        carritoService.crearCarrito(codigosProductos);
        return "Carrito creado correctamente.";
    }

    @GetMapping("/obtener/{id}")
    public CarritoCompra obtenerInfoCarrito(@PathVariable long id) {
        return carritoService.obtenerCarrito(id);
    }

}
