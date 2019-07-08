package com.sopra.spring.ejemplo02spring.ej04;

public class Cafe {
	private String marca;
	private String sabor;
	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	@Override
	public String toString() {
		return "Cafe [marca=" + marca + ", sabor=" + sabor + "]";
	}
	
	
	
}
