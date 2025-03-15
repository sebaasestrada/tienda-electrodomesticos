package es.sebaasestrada.servicio_carrito_compras.dao;

import es.sebaasestrada.servicio_carrito_compras.model.CarritoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoCompraRepository extends JpaRepository<CarritoCompra, Long> {
}
