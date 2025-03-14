package es.sebaasestrada.servicio_productos.service;

import es.sebaasestrada.servicio_productos.model.Producto;
import java.util.List;

public interface IProductoService {

    void agregarProducto(Producto producto);

    Producto obtenerProductoPorCodigo(long codigo);

    List<Producto> obtenerTodosLosProductos();

    void actualizarProducto(Producto producto);

    void eliminarProducto(long codigo);

}
