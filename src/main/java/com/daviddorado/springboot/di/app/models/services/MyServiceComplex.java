package com.daviddorado.springboot.di.app.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


//@Service("miServicioComplejo") -> Aporta semántica
@Component("miServicioComplejo")
@Primary
public class MyServiceComplex implements IMyService{
	
	public MyServiceComplex() {
		super();
	}

	public String operation(String palabra) {
		return "Ejecutando operacion Compleja " + palabra;
	}

	@Override
	public String read(String palabra) {		
		return "Reading "+ palabra + " complex";
	}
}
