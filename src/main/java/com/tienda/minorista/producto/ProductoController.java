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

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

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
	
	@GetMapping(path = "/{idProducto}")
	public Producto getProducto(@PathVariable(name = "idProducto") long idProducto) {
		return productoService.getProducto(idProducto);
	}
	
	@PostMapping
	public void agregarProducto(@Valid @NotNull @RequestBody Producto producto) {
		productoService.agregarProducto(producto);
	}
	
	@PutMapping(path="/actualizar/{idProducto}")
	public void actualizarProducto(@PathVariable(name = "idProducto") long idProducto, 
			@Valid @NotNull @RequestBody Producto producto) {
		
		try {
			productoService.actualizarProducto(idProducto, producto);
		}catch(IllegalStateException e){
			//TODO: return appropiate status code
		}
	}
	
	@DeleteMapping(path = "/eliminar/{idProducto}")
	public void eliminarProducto(@PathVariable(name = "idProducto") long idProducto) {
		productoService.eliminarProducto(idProducto);
	}
}
