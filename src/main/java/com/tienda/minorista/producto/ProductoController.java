package com.tienda.minorista.producto;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/producto")
public class ProductoController {

	private final ProductoService productoService;
	
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	@GetMapping
	public List<Producto> getProductos(){
		return productoService.getAllProductos();
	}
	
	@PostMapping
	public void agregarProducto(@RequestBody Producto producto) {
		productoService.agregarProducto(producto);
	}
	
	@PutMapping()
	public void actualizarProducto(@RequestBody Producto producto) {
		productoService.actualizarProducto(producto);
	}
	
	@DeleteMapping(path = "/eliminar/{idProducto}")
	public void eliminarProducto(@PathVariable(name = "idProducto") long idProducto) {
		productoService.eliminarProducto(idProducto);
	}
}
