package com.tienda.minorista.producto;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProductoService {

	private final ProductoRepository productoRepository;

	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	public List<Producto> getAllProductos(){
		return productoRepository.findAll();
	}

	public Producto getProducto(long idProducto) {
		Producto producto = productoRepository.findById(idProducto)
				.orElseThrow(() -> new IllegalStateException("No existe el producto con id " + idProducto));
		return producto;
	}
	
	public void agregarProducto(Producto producto) {
		productoRepository.save(producto);
	}

	public void eliminarProducto(long idProducto) {
		boolean existe = productoRepository.existsById(idProducto);
		if(!existe) throw new IllegalStateException("El producto con id " + idProducto + " no existe");
		productoRepository.deleteById(idProducto);
	}

	@Transactional
	public void actualizarProducto(long idProducto, Producto productoActualizado) {
		
		Producto productoGuardado = productoRepository.findById(idProducto)
				.orElseThrow(() -> new IllegalStateException(
						"No existe el producto con id " + productoActualizado.getIdProducto()
						));
		
		String nombre = productoActualizado.getNombre();
		if(nombre != null && nombre.length() > 0 && !Objects.equals(productoGuardado.getNombre(), nombre)) {
			productoGuardado.setNombre(nombre);
		}
		
		String marca = productoActualizado.getMarca();
		if(marca != null && marca.length() > 0 && !Objects.equals(productoGuardado.getMarca(), marca)) {
			productoGuardado.setMarca(marca);
		}
		
		String descripcion = productoActualizado.getDescripcion();
		if(descripcion != null && descripcion.length() > 0 && !Objects.equals(productoGuardado.getDescripcion(), descripcion)) {
			productoGuardado.setDescripcion(descripcion);
		}		
		
		float precio = productoActualizado.getPrecio();
		if(precio != -1 && precio != productoGuardado.getPrecio()) {
			productoGuardado.setPrecio(precio);
		}

		int cantidadDisponible = productoActualizado.getCantidadDisponible();
		if(cantidadDisponible != -1 && cantidadDisponible != productoGuardado.getCantidadDisponible()) {
			productoGuardado.setCantidadDisponible(cantidadDisponible);
		}
	}
}
