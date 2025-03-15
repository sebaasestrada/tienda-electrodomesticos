package es.sebaasestrada.servicio_ventas.service;

import es.sebaasestrada.servicio_ventas.dao.ICarritoCompraAPIClient;
import es.sebaasestrada.servicio_ventas.dao.IVentaRepository;
import es.sebaasestrada.servicio_ventas.dto.CarritoCompraDTO;
import es.sebaasestrada.servicio_ventas.model.Venta;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaService implements IVentaService {
    private final IVentaRepository ventaRepo;
    private final ICarritoCompraAPIClient carritoAPIClient;

    public VentaService(IVentaRepository ventaRepo, ICarritoCompraAPIClient carritoAPIClient) {
        this.ventaRepo = ventaRepo;
        this.carritoAPIClient = carritoAPIClient;
    }

    @Override
    @CircuitBreaker(name = "servicio-carrito-compras", fallbackMethod = "fallBackCrearVenta")
    @Retry(name = "servicio-carrito-compras")
    public void crearVenta(long idCarritoCompra) {
        // creamos un objeto Venta
        Venta nuevaVenta = new Venta();
        // obtenemos el carrito correspondiente a la nueva venta con la api client de carrito
        CarritoCompraDTO carritoVenta = carritoAPIClient.obtenerCarritoDeComprasPorId(idCarritoCompra);
        // obtenemos la hora y fecha actuales
        LocalDateTime horaYFechaActual = LocalDateTime.now();
        // seteamos los valores obtenidos / generados
        nuevaVenta.setFechaVenta(horaYFechaActual);
        nuevaVenta.setListaProductosCarrito(carritoVenta.getListaProductos());
        nuevaVenta.setTotal(carritoVenta.getTotal());
        // almacenamos el objeto en la base de datos
        ventaRepo.save(nuevaVenta);
    }

    public CarritoCompraDTO fallBackCrearVenta(Throwable throwable) {
        return new CarritoCompraDTO();
    }

    @Override
    public Venta obtenerVentaPorId(Long id) {
        return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Venta> obtenerTodasLasVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public void modificarVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public void eliminarVenta(long id) {
        ventaRepo.deleteById(id);
    }
}
