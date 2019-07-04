package com.sopra.aulas.consola;

public class MiSingleton {
	
	//Se puede usar bien en microservicios, pero cuidado cuando haya multiples servidores en activo
	//porque pierde valor y se multiplican los singletons.
	
	private static MiSingleton instance;
	private MiSingleton() {
		
	}
	public static MiSingleton getInstance() {
		if(instance == null) {
			instance = new MiSingleton();
		}
		return instance;
	}
}
