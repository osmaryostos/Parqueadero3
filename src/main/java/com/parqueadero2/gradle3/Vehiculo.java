package com.parqueadero2.gradle3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vehiculo {
	static final int MAX_MOTO = 1;
	static final int MAX_CARRO = 2;
	static final int HORA_CARRO = 1000;
	static final int HORA_MOTO = 500;
	static final int DIA_MOTO = 4000;
	static final int DIA_CARRO = 8000;
	private int llantas;
	private String placa;
	private String color;
	private int cilindraje;
	private int h_llegada;
	private int h_salida;	

	public int getH_llegada() {
		return h_llegada;
	}

	public void setH_llegada(int h_llegada) {
		this.h_llegada = h_llegada;
	}

	public int getH_salida() {
		return h_salida;
	}

	public void setH_salida(int h_salida) {
		this.h_salida = h_salida;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public int getLlantas() {
		return llantas;
	}

	public void setLlantas(int llantas) {
		this.llantas = llantas;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Vehiculo(int llantas, String placa, String color, int cilindraje, int h_entrada, int h_salida) {
		super();
		this.llantas = llantas;
		this.placa = placa;
		this.color = color;
		this.cilindraje = cilindraje;
		this.h_llegada = h_llegada;
		this.h_salida = h_salida;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	

	
}
