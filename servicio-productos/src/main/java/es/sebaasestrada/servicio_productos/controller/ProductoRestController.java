package es.sebaasestrada.servicio_productos.controller;

import es.sebaasestrada.servicio_productos.model.Producto;
import es.sebaasestrada.servicio_productos.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoRestController {
    private final ProductoService productoServ;

    // Injección de dependencias
    public ProductoRestController(ProductoService productoService) {
        this.productoServ = productoService;
    }

    // Endpoints
    @PostMapping("/crear")
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        productoServ.agregarProducto(producto);
        return new ResponseEntity<>("Producto creado correctamente con codigo: " + producto.getCodigo(), HttpStatus.CREATED);
    }

    @GetMapping("/obtener/{codigoProd}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable long codigoProd) {
        return ResponseEntity.ok(productoServ.obtenerProductoPorCodigo(codigoProd));
    }

    @GetMapping("/obtener/todos")
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
        return ResponseEntity.ok(productoServ.obtenerTodosLosProductos());
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificarProducto(@RequestBody Producto producto) {
        productoServ.actualizarProducto(producto);
        return new ResponseEntity<>("Producto modificado con codigo éxistosamente.", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/eliminar/{codigoProd}")
    public ResponseEntity<String> modificarProducto(@PathVariable long codigoProd) {
        productoServ.eliminarProducto(codigoProd);
        return new ResponseEntity<>("Producto eliminado correctamente.", HttpStatus.ACCEPTED);
    }

}
