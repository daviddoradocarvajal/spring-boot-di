package com.daviddorado.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.daviddorado.springboot.di.app.models.domain.ItemFactura;
import com.daviddorado.springboot.di.app.models.domain.Producto;
import com.daviddorado.springboot.di.app.models.services.MyServiceBean;

@Configuration
public class AppConfig {

	// @Primary -> es valido aqui también
	@Bean("ServicioBean")
	MyServiceBean registrarServicioBean() {
		return new MyServiceBean();
	}

	@Bean("itemsFactura")
	List<ItemFactura> registrarItems() {
		Producto prod1 = new Producto("Camara Sony", 50.99);
		Producto prod2 = new Producto("Bicicleta", 215.0);
		Producto prod3 = new Producto("Reloj Casio", 15.25);
		ItemFactura linea1 = new ItemFactura(prod1, 1);
		ItemFactura linea2 = new ItemFactura(prod2, 1);
		ItemFactura linea3 = new ItemFactura(prod3, 2);
		return Arrays.asList(linea1, linea2, linea3);
	}

	@Bean("itemsFacturaOficina")
	@Primary
	List<ItemFactura> registrarItemsOficina() {
		Producto prod1 = new Producto("Monitor LG", 245.99);
		Producto prod2 = new Producto("Notebook Asus", 599.0);
		Producto prod3 = new Producto("Impresora HP", 69.99);
		Producto prod4 = new Producto("Escritorio Oficina", 115.25);
		ItemFactura linea1 = new ItemFactura(prod1, 5);
		ItemFactura linea2 = new ItemFactura(prod2, 2);
		ItemFactura linea3 = new ItemFactura(prod3, 2);
		ItemFactura linea4 = new ItemFactura(prod4, 8);
		return Arrays.asList(linea1, linea2, linea3, linea4);
	}
}
