package com.daviddorado.springboot.di.app.models.domain;

import java.io.Serializable;

public class ItemFactura implements Serializable {

	private static final long serialVersionUID = -6369169435681187737L;
	private Producto producto;
	private int cantidad;

	public ItemFactura(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double calcularImporte(double precio) {
		return cantidad * precio;
	}

}
