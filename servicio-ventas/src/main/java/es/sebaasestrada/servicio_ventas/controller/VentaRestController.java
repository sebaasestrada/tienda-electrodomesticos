package es.sebaasestrada.servicio_ventas.controller;

import es.sebaasestrada.servicio_ventas.model.Venta;
import es.sebaasestrada.servicio_ventas.service.IVentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VentaRestController {
    private final IVentaService ventaServ;

    public VentaRestController(IVentaService ventaServ) {
        this.ventaServ = ventaServ;
    }

    @PostMapping("/crear")
    public String crearVenta(@RequestBody long idCarritoCompra) {
        ventaServ.crearVenta(idCarritoCompra);
        return "Venta creada correctamente.";
    }

    @GetMapping("/obtener/{idVenta}")
    public Venta obtenerVenta(@PathVariable Long idVenta) {
        return ventaServ.obtenerVentaPorId(idVenta);
    }

    @GetMapping("/obtenerTodos")
    public List<Venta> obtenerVentas() {
        return ventaServ.obtenerTodasLasVentas();
    }

}
