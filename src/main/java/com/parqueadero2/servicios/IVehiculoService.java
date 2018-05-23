package com.parqueadero2.servicios;

import java.util.List;

import com.parqueadero2.gradle3.Vehiculo;

public interface IVehiculoService {
	 List<Vehiculo> getAllVehicles();
	 
	 List<Vehiculo> ConsultarPlaca(String placa);
	 
     boolean IngresarVehiculo(Vehiculo vehiculo);
     
     boolean SalidaVehiculo(Vehiculo vehiculo);


}
