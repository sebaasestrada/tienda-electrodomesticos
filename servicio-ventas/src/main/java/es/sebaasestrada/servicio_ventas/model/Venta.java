package es.sebaasestrada.servicio_ventas.model;

import es.sebaasestrada.servicio_ventas.dto.CarritoCompraDTO;
import es.sebaasestrada.servicio_ventas.dto.ProductoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaVenta;
    @ElementCollection
    private List<ProductoDTO> listaProductosCarrito;
    private float total;

}
