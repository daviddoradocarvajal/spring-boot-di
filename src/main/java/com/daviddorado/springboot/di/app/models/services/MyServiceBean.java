package com.daviddorado.springboot.di.app.models.services;


public class MyServiceBean implements IMyService{
	
	public MyServiceBean() {
		super();
	}

	public String operation(String palabra) {
		return "Ejecutando operacion bean " + palabra;
	}

	@Override
	public String read(String palabra) {		
		return "Reading "+ palabra;
	}
}
