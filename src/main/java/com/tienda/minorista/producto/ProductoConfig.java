package com.tienda.minorista.producto;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductoConfig {

	@Bean
	CommandLineRunner commandLineRunner(ProductoRepository productoRepository) {
		return args -> {
			Producto arroz = new Producto("Arroz", "roa", "Bolsa de arroz de 5Lb", 10500, 15);
			Producto frijoles = new Producto("Frijoles", "cargamanto", "Bolsa de frijoles de 1Lb", 4500, 20);
			Producto huevos = new Producto("Huevos", "la finca", "Canasta de 30 huevos grandes", 17000, 12);
			
			productoRepository.saveAll(List.of(arroz, frijoles, huevos));
		};
	}
}
