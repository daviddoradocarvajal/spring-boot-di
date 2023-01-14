package com.daviddorado.springboot.di.app.models.services;

import org.springframework.stereotype.Service;

//@Component -> Genérico
@Service("miServicioSimple") // -> Aporta semántica
public class MyServiceSimple implements IMyService{
	
	public MyServiceSimple() {
		super();
	}

	public String operation(String palabra) {
		return "Ejecutando operacion simple " + palabra;
	}

	@Override
	public String read(String palabra) {		
		return "Reading "+ palabra;
	}
}
