package Ejercicios;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Listado <K, T extends Persona>
{

	HashMap<K, T> hMap;
	

	public Listado ()
	{
		hMap = new HashMap<K, T>();
	}
	
	public void agregar (K clave, T persona)
	{
		hMap.put(clave, persona);
	}
	
	public void borrar (K clave)
	{
		hMap.remove(clave);
	}
	
	public String listar ()
	{
		StringBuilder strBuildable = new StringBuilder();
		Iterator <Entry<K, T>> it = hMap.entrySet().iterator();
		
		while (it.hasNext())
		{
			Map.Entry<K, T> me = (Map.Entry<K, T>) it.next();
			Persona aux = (Persona) me.getValue();
			
			strBuildable.append(aux.toString());
		}
		
		return strBuildable.toString();
	}

	public void modificar (K clave, T nuevaPersona)
	{
		hMap.replace(clave, nuevaPersona);
	}
	
	public <K, T> K buscar (String apellido, String nombre)
	{
		//TODO funcion de buscar (La arreglé bastante, pero sigue habiendo un problema con los tipos de datos genericos)
		K respuesta = null;
		boolean encontrado = false;
		Iterator it = hMap.entrySet().iterator();
		
		
		while ( !encontrado && it.hasNext())
		{
			Map.Entry<K, T> me = (Map.Entry<K, T>) it.next();
			Persona aux = (Persona) me.getValue();
			
			if ( aux.getNombre().equalsIgnoreCase(nombre) && aux.getApellido().equalsIgnoreCase(apellido))
			{
				respuesta =  me.getKey(); 
				encontrado = true;
			}		
		}
		
		return respuesta;
	}
	


	@Override
	public boolean equals(Object obj) 
	{
		boolean respuesta = false;
		
		if ( obj != null && obj instanceof Persona )
		{
			Persona aux = (Persona)obj;
			
			//if (  )
			//TODO ¿Es necesario este equal? ¿Se estaría comparando un HashMap contra otro? ¿O para comparar personas? Ese va en la clase personas
			//		y se llamaría dentro de la función buscar de esta clase según entiendo.
		}
		
		return respuesta;
	}
	
	@Override
	public int hashCode()
	{
		return 1;
	}	
}
