package es.sebaasestrada.servicio_carrito_compras.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO implements Serializable {

    private long codigo;
    private String nombre;
    private float precio;

}
