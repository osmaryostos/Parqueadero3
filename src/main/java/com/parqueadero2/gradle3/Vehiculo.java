package com.parqueadero2.gradle3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "VEHICULO") //tambien puede dejarse por defecto y quedara en tabla vehiculo
public class Vehiculo implements Serializable  {
	
	private static final long serialVersionUID = -3009157732242241606L;
	
	@Column(name="TIPO", nullable = false)
	private int llantas;
	
	@Id
	@Column(name="PLACA", nullable = false)
	private String placa;
	@Column(name="COLOR")
	private String color;
	@Column(name="CILINDRAJE")
	private int cilindraje;
	@Column(name="H_LLEGADA", nullable = false)
	private int h_llegada;
	@Column(name="H_SALIDA")
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
		this.h_llegada = h_entrada;
		this.h_salida = h_salida;
	}
	public Vehiculo(){}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	

	
}
