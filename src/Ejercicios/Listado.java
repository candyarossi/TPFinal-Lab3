package Ejercicios;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Listado <K, T extends Persona> {

	HashMap<K, T> map;
	

	public Listado () {
		map = new HashMap<K, T>();
	}
	
	public void agregar (K clave, T persona) {
		map.put(clave, persona);
	}
	
	public void borrar (K clave) {
		map.remove(clave);
	}
	
	public void listar () {
		Iterator <Entry<K, T>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<K, T> me = (Map.Entry<K, T>) it.next();
			Persona aux = (Persona) me.getValue();
			System.out.println(me.getKey() + aux.toString());
		}
	}

	public void modificar (K clave, T nuevaPersona) {
		map.replace(clave, nuevaPersona);
	}
	
	//TODO funcion de buscar 
	
	/*public <K, T> K buscar (String apellido, String nombre) {
		Iterator <Entry<K, T>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<K, T> me = (Map.Entry<K, T>) it.next();
			Persona aux = (Persona) me.getValue();
			if (aux.getApellido().equalsIgnoreCase(apellido)) {
				if(aux.getNombre().equalsIgnoreCase(nombre))
					return me.getKey();
				else
					return null; 
			}		
		}
	}*/
	
	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		//TODO 
		boolean esIgual = false;
		return esIgual;
	}
	
	
}
