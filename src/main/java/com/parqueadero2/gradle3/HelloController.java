package com.parqueadero2.gradle3;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@RestController
public class HelloController {
	
	@RequestMapping("/hola")
	public String sayHi() {
		return "Hi";
	}
	
	@RequestMapping(value = "/capacidad/{itemid}", method = RequestMethod.GET)
	public Response sayHi(@PathParam("param") String msg) {
			String output = "Bienvenido a REST! : " + msg;
			return Response.status(200).entity(output).build();
	}

	@RequestMapping("/cap")
	public @ResponseBody
	String getitem(@RequestParam(value="name", defaultValue="World") String name) {   
		Vehiculo vehiculo = new Vehiculo(2, name , name , 555, 10 , 11);
		ArrayList<Vehiculo> vehiculos = new ArrayList<>();
		String resultado ="";		
		Iterator<Vehiculo> itr = vehiculos.iterator();
	    int moto= 0;
	    int carro = 0;  
	      while(itr.hasNext()) {
	         Vehiculo element = itr.next();
	         if(element.getLlantas() == 2 ){
	        	 moto++;
	        	 if( moto > element.MAX_MOTO){
	        		 resultado = "No hay capacidad de moto";
	        	 }else{
	        		 resultado = "Puede pasar moto";
	        		 vehiculos.add(vehiculo);
	        	 }
	         }else{
	        	carro++;
	        	if( carro > element.MAX_CARRO){
	        		 resultado = "No hay capacidad de carro";
	        	 }else{
	        		 resultado = "Puede pasar carro";
	        		 vehiculos.add(vehiculo);
	        	 }
	         }
	                 
	      }
	      
	      if  (moto == 0  &&  carro == 0) {
	    	  resultado = "Parqueadero Vacio, siga adelante";
	    	  vehiculos.add(vehiculo);
	      }
	
		
		
	String output = "Bienvenido a REST! : " + resultado + " color: " + vehiculo.getColor();
	return output;
	}
}
