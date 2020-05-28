package Ejercicios;

import java.util.HashMap;

public class Listado <K, T extends Persona> {

	HashMap<K, T> map;
	

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		//TODO hacer esta funcion xD
		return true;
	}
	
	
}
