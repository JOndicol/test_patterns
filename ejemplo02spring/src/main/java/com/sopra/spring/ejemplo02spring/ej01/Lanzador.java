package com.sopra.spring.ejemplo02spring.ej01;

/**
 * Hello world!
 *
 */
public class Lanzador 
{
	private static BarDeCopas miBarDeCopasFavorito;
    public static void main( String[] args )
    {
    	BarDeCopas elPersi = new BarDeCopas();
    	elPersi.setNombreDelBar("El Persi");
    	elPersi.setCalidadDeLaBebida("Te revienta el calimocho");
    	
    	Lanzador.miBarDeCopasFavorito = elPersi;
    	System.out.println(elPersi);
    	cambiarDeCalidad();
    	System.out.println(elPersi);
    }
    
    public static void cambiarDeCalidad() {
    	miBarDeCopasFavorito.setCalidadDeLaBebida("Don Rodrigo rules");
    }
    
}
