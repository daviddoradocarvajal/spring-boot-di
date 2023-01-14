package com.daviddorado.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
// Contexto del objeto
/*
 * Singleton -> Se crea una sola vez al arrancar y se mantiene durante toda la aplicación 
 * Request -> Se crea y se destruye cada vez que se envia una petición HTTP 
 * Sesion -> Se crea al inciar una petición y se destruye al cerrar el navegador o cuando ocurre un timeout 
 * (demasiado tiempo sin hacer nada) o cuando se invalida la sesion (caduca el token por ejemplo). Debe
 * implementar serializable  
 * Application -> Muy similar a singleton pero se guarda en el contexto del servlet en lugar del contexto de application
 * una aplicación de spring tiene un unico application context (Singleton) pero PUEDE tener varios servlet context (ApplicationScope)
 * Prototype -> Este contexto se usa en aplicaciones de escritorio/consola y nos permite tener mas de una instancia de un mismo bean en la aplicación
 */
@RequestScope
public class Factura implements Serializable {

	private static final long serialVersionUID = 7072863777813628822L;
	@Value("${factura.descripcion}")
	private String descripcion;
	@Autowired
	private Cliente cliente;
	@Autowired
	private List<ItemFactura> items;

	@PostConstruct
	public void init() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Nekrak"));
		descripcion = descripcion.concat(cliente.getNombre());
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Destruyendo factura...");
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

}
