package es.sebaasestrada.servicio_carrito_compras.service;

import es.sebaasestrada.servicio_carrito_compras.dao.CarritoCompraRepository;
import es.sebaasestrada.servicio_carrito_compras.dao.IProductoAPIClient;
import es.sebaasestrada.servicio_carrito_compras.dto.ProductoDTO;
import es.sebaasestrada.servicio_carrito_compras.model.CarritoCompra;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoCompraService implements ICarritoCompraService {
    private final CarritoCompraRepository carritoRepo;
    private final IProductoAPIClient productoAPIClient;

    public CarritoCompraService(CarritoCompraRepository carritoRepo, IProductoAPIClient productoAPIClient) {
        this.carritoRepo = carritoRepo;
        this.productoAPIClient = productoAPIClient;
    }

    @Override
    @CircuitBreaker(name = "servicio-productos", fallbackMethod = "fallBackCrearCarrito")
    @Retry(name = "servicio-productos")
    public void crearCarrito(ArrayList<Long> codigosProductos) {
        // creamos un nuevo objeto CarritoCompra
        CarritoCompra nuevoCarrito = new CarritoCompra();
        // creamos una lista vacia para los productos
        List<ProductoDTO> listaProductos = new ArrayList<>();
        // obtenemoa la informacion completa de los productos (precio y id) a partir del id de los mismos
        for (long codigoProducto : codigosProductos) {
            listaProductos.add(
                    productoAPIClient.obtenerProductoPorCodigoProducto(codigoProducto)
            );
        }
        // seteamos la lista de productos del carrito
        nuevoCarrito.setListaProductos(listaProductos);
        nuevoCarrito.setTotal(nuevoCarrito.obtenerImporteTotalCarrito());
        // guarda el carrito
        carritoRepo.save(nuevoCarrito);
    }

    public ProductoDTO fallBackCrearCarrito(Throwable throwable) {
        return new ProductoDTO();
    }

    @Override
    public CarritoCompra obtenerCarrito(long id) {
        return carritoRepo.findById(id).orElse(null);
    }

    @Override
    public List<CarritoCompra> obtenerCarritos() {
        return carritoRepo.findAll();
    }

    @Override
    public void modificarCarrito(CarritoCompra carritoCompra) {
        CarritoCompra carritoModificado = this.obtenerCarrito(carritoCompra.getId());
        carritoModificado.setListaProductos(carritoCompra.getListaProductos());
        carritoModificado.setTotal(carritoCompra.obtenerImporteTotalCarrito());
        carritoRepo.save(carritoModificado);
    }

    @Override
    public void eliminarCarrito(long id) {
        carritoRepo.deleteById(id);
    }
}
