package es.sebaasestrada.servicio_carrito_compras.service;

import es.sebaasestrada.servicio_carrito_compras.model.CarritoCompra;

import java.util.ArrayList;
import java.util.List;

public interface ICarritoCompraService {

    void crearCarrito(ArrayList<Long> codigosProductos);

    CarritoCompra obtenerCarrito(long id);

    List<CarritoCompra> obtenerCarritos();

    void modificarCarrito(CarritoCompra carritoCompra);

    void eliminarCarrito(long id);

}
