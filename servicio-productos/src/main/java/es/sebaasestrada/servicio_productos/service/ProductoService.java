package es.sebaasestrada.servicio_productos.service;

import es.sebaasestrada.servicio_productos.model.Producto;
import es.sebaasestrada.servicio_productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {
    // Injección de dependencia mendiante constructor de la clase
    private final ProductoRepository productoRepo;

    public ProductoService(ProductoRepository productoRepo) {
        this.productoRepo = productoRepo;
    }

    // implementación métodos abstractos | lógica de negocio
    @Override
    public void agregarProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public Producto obtenerProductoPorCodigo(long codigo) {
        return productoRepo.findByCodigo(codigo);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepo.findAll();
    }

    @Override
    public void actualizarProducto(Producto producto) {
        this.obtenerProductoPorCodigo(producto.getCodigo());

        producto.setNombre(producto.getNombre());
        producto.setMarca(producto.getMarca());
        producto.setPrecio(producto.getPrecio());

        productoRepo.save(producto);
    }

    @Override
    public void eliminarProducto(long codigo) {
        productoRepo.deleteByCodigo(codigo);
    }
}
