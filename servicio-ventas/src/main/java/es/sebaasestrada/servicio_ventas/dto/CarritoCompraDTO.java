package es.sebaasestrada.servicio_ventas.dto;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarritoCompraDTO implements Serializable {

    private long id;
    private List<ProductoDTO> listaProductos;
    private float total;

}
