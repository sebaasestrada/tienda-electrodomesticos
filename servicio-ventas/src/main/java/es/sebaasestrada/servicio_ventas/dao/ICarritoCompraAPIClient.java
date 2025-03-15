package es.sebaasestrada.servicio_ventas.dao;

import es.sebaasestrada.servicio_ventas.dto.CarritoCompraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "servicio-carrito-compras")
public interface ICarritoCompraAPIClient {

    @GetMapping("/api/obtener/{id}")
    CarritoCompraDTO obtenerCarritoDeComprasPorId(@PathVariable long id);

}
