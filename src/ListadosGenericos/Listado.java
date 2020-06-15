package ListadosGenericos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import ClasesDePersonas.Persona;
import ClasesDePersonas.Empleado;
import ClasesDePersonas.Empleador;
import Archivos.Archivo;


public class Listado <K, T extends Persona> extends HashMap implements Serializable
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
			
			strBuildable.append("- " + aux.getApellido() + ", "+ aux.getNombre() + "\n");
		}
		
		return strBuildable.toString();
	}

	public void modificar (K clave, T nuevaPersona)
	{
		hMap.replace(clave, nuevaPersona);
	}
	
	public String mostrar (K clave)
	{
		return hMap.get(clave).toString();
	}
	
	public int contar () 
	{
		return hMap.size();
	}
	
	public <K, T> K buscar (String apellido, String nombre)
	{
		//ToDo funcion de buscar (La arreglé bastante, pero sigue habiendo un problema con los tipos de datos genericos)
		//SERA PEDORRO, PERO FUNCIONA.
		
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

	public JSONArray toJSON() {
		
		JSONArray array = new JSONArray();
		
		Iterator <Entry<K, T>> it = hMap.entrySet().iterator();
		
		while (it.hasNext())
		{
			Map.Entry<K, T> me = (Map.Entry<K, T>) it.next();
			if(me.getValue() instanceof Empleado) 
			{
				Empleado aux = (Empleado) me.getValue();
				array.put(aux.toJSON());
			} 
			else if (me.getValue() instanceof Empleador) 
			{
				Empleador aux = (Empleador) me.getValue();
				array.put(aux.toJSON());
			} 
		}
				
		return array;
	}
	
	public void guardarEnArchivo () 
	{
		Iterator <Entry<K, T>> it = hMap.entrySet().iterator();
		
		while (it.hasNext())
		{
			Map.Entry<K, T> me = (Map.Entry<K, T>) it.next();
			Persona persona = me.getValue();
			Archivo.guardar(persona);
		}
	}
	
	public Listado<Integer, Persona> leerDeArchivo () 
	{
		Listado<Integer, Persona> listado = new Listado<Integer, Persona>();
		boolean x = true;
		
		while (x) 
		{
			Persona aux = Archivo.leer();
			listado.agregar(aux.getNroLegajo(), aux);
		}
		
		return listado;
	}
	
}





