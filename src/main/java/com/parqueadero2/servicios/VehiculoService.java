package com.parqueadero2.servicios;

import java.util.ArrayList;
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
	public boolean IngresarVehiculo(Vehiculo vehiculo) {		
		
		ArrayList<Vehiculo> vehiculos = new ArrayList<>();
		boolean resultado = false;	
		vehiculos = (ArrayList<Vehiculo>) vehiculoRepositorio.findAll();
		//cargar lista con consultar todos y guardar en vehiculos 2= moto, 4 = carro
		Iterator<Vehiculo> itr = vehiculos.iterator();
	    int moto= 0;
	    int carro = 0;  
	      while(itr.hasNext()) {
	    	  Vehiculo element = itr.next();
	    	  if (vehiculo.getLlantas()== 2)  {
	    		  if(element.getLlantas() == 2 ){
	    			  moto++;
	    		  }
	    	  }
	    	  if (vehiculo.getLlantas()== 4)  {
	    		  if(element.getLlantas() == 4 ){
	    			  carro++;
	    		  }
	    	  }
	      }
	        	
	        	if( carro >= Constantes.MAX_CARRO || moto >= Constantes.MAX_MOTO) {
	        		resultado = false;
	        	 }else{
	        		 resultado = true;	  
	        		 vehiculoRepositorio.save(vehiculo);
	        	 }
	         

		return resultado;
	}

	@Override
	public boolean SalidaVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return false;
	}

}
