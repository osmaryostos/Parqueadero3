package com.parqueadero2.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.parqueadero2.gradle3.Vehiculo;


	//@Repository 
	public interface Repositorio extends CrudRepository<Vehiculo, Long>{
	    List<Vehiculo> findByPlaca(String placa);
	} 


