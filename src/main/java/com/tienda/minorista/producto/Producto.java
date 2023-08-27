package com.tienda.minorista.producto;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProducto;
	
	@Nonnull
	private String nombre;
	
	@Nonnull
	private String marca;
	
	@Nonnull
	private String descripcion;
	
	@Nonnull
	private float precio = -1;
	
	@Nonnull
	private int cantidadDisponible = -1;

	public Producto() {
		super();
	}

	public Producto(String nombre, String marca, String descripcion, float precio, int cantidadDisponible) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadDisponible = cantidadDisponible;
	}

	public Producto(long idProducto, String nombre, String marca, String descripcion, float precio,
			int cantidadDisponible) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.marca = marca;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadDisponible = cantidadDisponible;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", marca=" + marca + ", descripcion="
				+ descripcion + ", precio=" + precio + ", cantidadDisponible=" + cantidadDisponible + "]";
	}
}
