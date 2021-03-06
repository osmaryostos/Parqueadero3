package com.parqueadero2.gradle3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.parqueadero2.gradle3.Constantes;



public class Parqueadero {

	public static void main(String[] args) {		
		
		int valor_scan;
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingresar nuevo (1), Salir (0)");
		valor_scan =  Integer.parseInt(scan.nextLine());
		while(valor_scan != 0) {
			boolean retorno = Ingreso();
			System.out.println("Ingresar otro vehiculo?: Si(1), No(0) ");
			valor_scan = Integer.parseInt(scan.nextLine());
		}
		


	}
	
	public static boolean Ingreso(){
		
		int cilindraje, hora_llegada, hora_salida;
		Integer tipo;
		String placa, color;		
		Boolean cap;
		Scanner scan = new Scanner(System.in);
		ArrayList<Vehiculo> vehiculos = new ArrayList<>();
		
	
		System.out.println("Digite Tipo: Moto (2), Carro (4): ");			
		tipo = Integer.parseInt(scan.nextLine());
		System.out.println("Digite Placa: ");
		placa = scan.nextLine();
		System.out.println("Digite Color: ");
		color = scan.nextLine();
		System.out.println("Digite cilindraje: ");
		cilindraje = Integer.parseInt(scan.nextLine());
		Date d=new Date(); 
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		System.out.println(Integer.toString(cal.get(Calendar.HOUR) )); 
		hora_llegada = cal.get(Calendar.HOUR);
		hora_salida = hora_llegada;
		Vehiculo vehiculo = new Vehiculo(tipo, placa, color,cilindraje, hora_llegada, hora_salida);
		
		if (capacidad(vehiculos)){
			vehiculos.add(vehiculo);		
			
			return true;
			
		}else{
			System.out.println("No hay puesto");
			return false;			
		}
		
	
	
	}
	
	public Parqueadero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static boolean capacidad(List<Vehiculo> vehiculos){
		//contar el numero de carros y motos en la lista para ver si sumando uno mas
		Iterator<Vehiculo> itr = vehiculos.iterator();
	    int moto= 0;
	    int carro = 0;  
	      while(itr.hasNext()) {
	         Vehiculo element = itr.next();
	         if(element.getLlantas() == 2 ){
	        	 moto++;
	        	 if( moto > Constantes.MAX_MOTO){
	        		 return false;
	        	 }
	         }else{
	        	carro++;
	        	if( carro > Constantes.MAX_CARRO){
	        		 return false;
	        	 }
	         }
	                 
	      }
		return true;
	} 
	

}
