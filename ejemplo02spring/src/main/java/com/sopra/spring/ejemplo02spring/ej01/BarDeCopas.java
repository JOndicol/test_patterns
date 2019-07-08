package com.sopra.spring.ejemplo02spring.ej01;

public class BarDeCopas {
	
	private String nombreDelBar;
	private String calidadDeLaBebida;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calidadDeLaBebida == null) ? 0 : calidadDeLaBebida.hashCode());
		result = prime * result + ((nombreDelBar == null) ? 0 : nombreDelBar.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BarDeCopas other = (BarDeCopas) obj;
		if (calidadDeLaBebida == null) {
			if (other.calidadDeLaBebida != null)
				return false;
		} else if (!calidadDeLaBebida.equals(other.calidadDeLaBebida))
			return false;
		if (nombreDelBar == null) {
			if (other.nombreDelBar != null)
				return false;
		} else if (!nombreDelBar.equals(other.nombreDelBar))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BarDeCopas [nombreDelBar=" + nombreDelBar + ", calidadDeLaBebida=" + calidadDeLaBebida + "]";
	}
	
	public String getNombreDelBar() {
		return nombreDelBar;
	}
	public void setNombreDelBar(String nombreDelBar) {
		this.nombreDelBar = nombreDelBar;
	}
	public String getCalidadDeLaBebida() {
		return calidadDeLaBebida;
	}
	public void setCalidadDeLaBebida(String calidadDeLaBebida) {
		this.calidadDeLaBebida = calidadDeLaBebida;
	}
	
}
