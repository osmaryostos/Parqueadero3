package com.parqueadero2.servicios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parqueadero2.gradle3.Constantes;
import com.parqueadero2.gradle3.Vehiculo;
import com.parqueadero2.repository.Repositorio;

@Service("IVehiculoService")
public class VehiculoService implements IVehiculoService {
	@Autowired
	Repositorio vehiculoRepositorio;

	@Override
	public List<Vehiculo> getAllVehicles() {
		return (List<Vehiculo>) vehiculoRepositorio.findAll();

	}

	@Override
	public List<Vehiculo> ConsultarPlaca(String placa) {
		return vehiculoRepositorio.findByPlaca(placa);

	}

	@Override
	public Vehiculo IngresarVehiculo(Vehiculo vehiculo) {
		
		Vehiculo save = new Vehiculo();
		ArrayList<Vehiculo> vehiculos = (ArrayList<Vehiculo>) vehiculoRepositorio.findAll();
		if (Capacidad(vehiculos, vehiculo.getLlantas())) {
			if (DiaHabil(vehiculo)) {
				 save = vehiculoRepositorio.save(vehiculo);
				//resultado = save.getPlaca() != null;
			}
		}

		return save;
	}

	@Override
	public void salidaVehiculo(Vehiculo vehiculo) {
		 vehiculoRepositorio.delete(vehiculo) ;
	}

	@Override
	public boolean Capacidad(ArrayList<Vehiculo> vehiculos, int tipo) {

		int moto = 0;
		int carro = 0;
		boolean resultado = false;

		if (vehiculos != null) {
			// cargar lista con consultar todos y guardar en vehiculos 2= moto,
			// 4 = carro
			Iterator<Vehiculo> itr = vehiculos.iterator();

			while (itr.hasNext()) {
				Vehiculo element = itr.next();
				if (tipo == 2) {
					if (element.getLlantas() == 2) {
						moto++;
					}
				} else {
					if (element.getLlantas() == 4) {
						carro++;
					}
				}
			}

			if (carro >= Constantes.MAX_CARRO || moto >= Constantes.MAX_MOTO) {
				resultado = false;
			} else {
				resultado = true;
			}

		}
		return resultado;
	}

	@Override
	public boolean DiaHabil(Vehiculo vehiculo) {
		Calendar fecha = Calendar.getInstance();
		if (vehiculo.getPlaca().toUpperCase().startsWith("A")
				&& (fecha.get(Calendar.DAY_OF_WEEK) == 1 || fecha.get(Calendar.DAY_OF_WEEK) == 2)) {
			return false;
		}
		// TODO Auto-generated method stub
		return true;
	}
}
