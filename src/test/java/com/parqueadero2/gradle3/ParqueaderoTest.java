package com.parqueadero2.gradle3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ParqueaderoTest {

	@Test
	public void ProbarCapacidad() {
		boolean resultado;
		Parqueadero parqueadero = new Parqueadero();
		ArrayList<Vehiculo> vehiculos = new ArrayList<>();
		Vehiculo vehiculo = new Vehiculo(2,"SDSD" ,"azul",555, 10, 10);		
		vehiculos.add(vehiculo);		
		resultado = parqueadero.capacidad(vehiculos);
		assertEquals(true, resultado);
		// fail("Not yet implemented");
	}
	
	
}
