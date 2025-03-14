package es.sebaasestrada.servicio_productos.repository;

import es.sebaasestrada.servicio_productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT prod FROM Producto prod WHERE prod.codigo = :codigo")
    Producto findByCodigo(long codigo);

    @Query("SELECT prod FROM Producto prod WHERE prod.codigo = :codigo")
    void deleteByCodigo(long codigo);
}
