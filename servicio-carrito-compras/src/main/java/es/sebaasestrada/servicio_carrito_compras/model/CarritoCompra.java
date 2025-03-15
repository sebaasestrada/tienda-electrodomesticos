package es.sebaasestrada.servicio_carrito_compras.model;

import es.sebaasestrada.servicio_carrito_compras.dto.ProductoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CarritoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ElementCollection
    private List<ProductoDTO> listaProductos;
    private float total;

    /* metodo de la clase para calcular el precio totoal del carrito */
    public float obtenerImporteTotalCarrito() {
        if (listaProductos.isEmpty()) {
            return 0.00f;
        } else {
            // declaramaos la variable que almacenara el precio total de la cesta
            float precioTotal = 0.00f;
            // recorremos la lista de productos
            // con cada producto añadimos a 'precioTotal' el precio del producto multiplicado por la cantidad del mismo
            for (ProductoDTO prod : listaProductos) {
                precioTotal += prod.getPrecio();
            }
            // finalmente devolvemos 'precioTotal'
            return precioTotal;
        }
    }

}
