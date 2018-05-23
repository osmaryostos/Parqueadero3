package com.parqueadero2.gradle3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.parqueadero2.servicios.IVehiculoService;


@RestController
public class HelloController {
	
	@Autowired
	private IVehiculoService VehicleService;
	
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
	        	 if( moto > Constantes.MAX_MOTO){
	        		 resultado = "No hay capacidad de moto";
	        	 }else{
	        		 resultado = "Puede pasar moto";
	        		 vehiculos.add(vehiculo);
	        	 }
	         }else{
	        	carro++;
	        	if( carro > Constantes.MAX_CARRO){
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
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello(@RequestParam(value="name", defaultValue="World") String name) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello");         
        String str = "Hello Worldsss! " + name;
        mav.addObject("message", str);
 
        return mav;
    
	}
	
	@RequestMapping("/save")
    public String process(){
		boolean retorno = true;
		retorno = VehicleService.IngresarVehiculo(new Vehiculo(2, "jghy" , "azul" , 555, 10 , 11));
		retorno = VehicleService.IngresarVehiculo(new Vehiculo(4, "ssss" , "azul" , 555, 11 , 11));
		retorno = VehicleService.IngresarVehiculo(new Vehiculo(4, "wrer" , "rojo" , 555, 12 , 11));	
		retorno = VehicleService.IngresarVehiculo(new Vehiculo(4, "wrser" , "rojo" , 555, 12 , 11));	
        return "Done";
    }
	
	@RequestMapping("/articles")
	public ResponseEntity<List<Vehiculo>> getAllVehicles(@RequestParam(value="placa", defaultValue="xxxx") String placa) {		
		List<Vehiculo> vehiculos = VehicleService.ConsultarPlaca(placa) ;		
		return new ResponseEntity<List<Vehiculo>>(vehiculos, HttpStatus.OK);
	}
	
	/*@RequestMapping(value = "/todos/", method = RequestMethod.GET)
    public ResponseEntity<List<Vehiculo>> listAllUsers() {
        List<Vehiculo> vehicles = VehicleService.
        if (vehicles.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Vehiculo>>(vehicles, HttpStatus.OK);
    }*/
 
}
