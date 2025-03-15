package es.sebaasestrada.servicio_carrito_compras.dao;

import es.sebaasestrada.servicio_carrito_compras.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "servicio-productos")
public interface IProductoAPIClient {

    @GetMapping("/api/obtener/{codigoProducto}")
    ProductoDTO obtenerProductoPorCodigoProducto(@PathVariable long codigoProducto);

}
