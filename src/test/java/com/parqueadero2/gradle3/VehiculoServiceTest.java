package com.parqueadero2.gradle3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.parqueadero2.servicios.IVehiculoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ParqueaderoBoot.class)
public class VehiculoServiceTest {
	@Autowired
	IVehiculoService vehiculoService;
	
	@Test	
	public void ProbarIngreso() {
		Vehiculo retorno = new Vehiculo();			
		retorno = vehiculoService.IngresarVehiculo(new Vehiculo(2, "oooo" , "azul" , 555, 10 , 11));		
		assertEquals(true, retorno);
		
	}
	
	@Test
	public void ProbarCapacidad(){
		ArrayList<Vehiculo> vehiculos = new ArrayList<>();
		Vehiculo vehiculo = new Vehiculo(2, "jghy" , "azul" , 555, 10 , 11);
		vehiculos.add(vehiculo);
		vehiculo = new Vehiculo(4, "jsghy" , "azul" , 555, 10 , 11);
		vehiculos.add(vehiculo);
		boolean retorno = true;			
		retorno = vehiculoService.Capacidad(vehiculos, 2);
		assertEquals(false, retorno);
	}
	
	

}
