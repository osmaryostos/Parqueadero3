package com.parqueadero2.gradle3;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

//import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.parqueadero2.servicios.IVehiculoService;
import com.sun.jersey.api.uri.UriTemplate;

import net.minidev.json.JSONObject;

//si se quiere activar el cors a todo el controladot@CrossOrigin(origins = "http://domain2.com", maxAge = 3600)
@RestController
public class HelloController {
	  protected final Log logger = LogFactory.getLog(getClass());
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
		Vehiculo retorno = new Vehiculo();
		retorno = VehicleService.IngresarVehiculo(new Vehiculo(2, "jghy" , "azul" , 555, 10 , 11));
		retorno = VehicleService.IngresarVehiculo(new Vehiculo(4, "ssss" , "azul" , 555, 11 , 11));
		retorno = VehicleService.IngresarVehiculo(new Vehiculo(4, "wrer" , "rojo" , 555, 12 , 11));	
////		retorno = VehicleService.IngresarVehiculo(new Vehiculo(4, "wrser" , "rojo" , 555, 12 , 11));	
        return "{'placa': 'done'}";
    }
	@CrossOrigin
	@RequestMapping("/articles")
	public ResponseEntity<List<Vehiculo>> getAllVehicles(@RequestParam(value="placa", defaultValue="xxxx") String placa) {		
		List<Vehiculo> vehiculos = VehicleService.ConsultarPlaca(placa) ;		
		return new ResponseEntity<List<Vehiculo>>(vehiculos, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/salida", produces={"application/json"},  method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public String salidaVehiculo(@RequestParam(value="placa") String placa) {
		Vehiculo vehiculo = new Vehiculo();
		String plac;
		List<Vehiculo> vehiculos = VehicleService.ConsultarPlaca(placa) ;	
		Integer i = 0; 
		Iterator<Vehiculo> it = vehiculos.iterator();
		while(it.hasNext()) {
			 Vehiculo element = it.next();
			 plac = element.getPlaca();
		
			//if (plac == placa) {			 
				VehicleService.salidaVehiculo(element);
				 return "Eliminado";
				 
			//}
			//i++;
		}
		
				
		 return i.toString();
	}
	
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
    public ResponseEntity<List<Vehiculo>> listAllUsers() {
		return (ResponseEntity<List<Vehiculo>>) VehicleService.getAllVehicles();
    }
 
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/vehiculo", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Vehiculo vehiculo, HttpServletRequest request, HttpServletResponse response)
           // throws ServletException, IOException {
    {
	
		VehicleService.IngresarVehiculo(new Vehiculo(2, "ggg" , "azul" , 555, 10 , 11));
		
		String requestUrl = request.getRequestURL().toString();
		//URI uri = new UriTemplate("{requestUrl}/article").expand;
		 UriTemplate template = new UriTemplate("{requestUrl}/article?=xxxx");
		 response.setHeader("Location",template.toString());
       
    }
	
	@RequestMapping(value="/stt", produces={"application/json"},  method = RequestMethod.POST)
    public String addMessage(){
         return "post works";
	}
	
	@CrossOrigin
	@PostMapping(value = "/registrar",  consumes = "application/json")
	public ResponseEntity<Vehiculo> registrar(@RequestBody Vehiculo vehiculo) {
		
		Vehiculo vehiculoObj = VehicleService.IngresarVehiculo(vehiculo);
		
		//if (VehicleService.vehiculoEsNulo(vehiculoObj)) {
			//return ResponseEntity.badRequest().header("Error", "10" ).body(vehiculoObj);
		//}else {
			return ResponseEntity.ok().body(vehiculoObj);
		//}
		
		
	}	
	
	

	
}
