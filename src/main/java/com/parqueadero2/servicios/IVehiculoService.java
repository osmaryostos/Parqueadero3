package com.parqueadero2.servicios;

import java.util.ArrayList;
import java.util.List;

import com.parqueadero2.gradle3.Vehiculo;

public interface IVehiculoService {
	 List<Vehiculo> getAllVehicles();
	 
	 List<Vehiculo> ConsultarPlaca(String placa);
	 
     Vehiculo IngresarVehiculo(Vehiculo vehiculo);
     
     void salidaVehiculo(Vehiculo vehiculo);

     boolean Capacidad(ArrayList<Vehiculo> vehiculos, int tipo);
     
     boolean DiaHabil(Vehiculo vehiculo);


}
