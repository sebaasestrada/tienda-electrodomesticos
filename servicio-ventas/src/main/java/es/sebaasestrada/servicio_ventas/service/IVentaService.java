package es.sebaasestrada.servicio_ventas.service;

import es.sebaasestrada.servicio_ventas.model.Venta;
import java.util.List;

public interface IVentaService {

    void crearVenta(long idCarritoCompra);

    Venta obtenerVentaPorId(Long id);

    List<Venta> obtenerTodasLasVentas();

    void modificarVenta(Venta venta);

    void eliminarVenta(long id);

}
