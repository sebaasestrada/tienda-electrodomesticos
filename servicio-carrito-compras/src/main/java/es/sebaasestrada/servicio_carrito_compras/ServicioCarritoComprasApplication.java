package es.sebaasestrada.servicio_carrito_compras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ServicioCarritoComprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioCarritoComprasApplication.class, args);
	}

}
