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
import Archivos.GestorDeArchivos;


/**
 * <p><b><i>Listado <K, T extends Persona></i></b></p>
 * <pre>public class Listado <K, T extends Persona> implements Serializable</pre>
 * <p>La clase <code>Listado <K, T extends Persona></code> es una clase genérica que puede ser utilizada para generar diferentes tipos de listados, 
 * donde K sea una clave única y significativa para el objeto y T sea un objeto que extienda de <code>Persona</code>. Esta clase implementa la
 * interfaz <code>Serializable</code>.</p>
 * @author Yarossi, Candela & Trucco, Nahuel
 */
public class Listado <K, T extends Persona> extends HashMap implements Serializable
{

	private HashMap<K, T> hMap;
	public static String ARCHIVO = "empleadores.dat";
	
	
	/**
	 * <p><b><i>Listado</i></b></p>
	 * <pre>public Listado ()</pre>
	 * <p>Constructor de la clase <code>Listado</code>.</p>
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public Listado ()
	{
		hMap = new HashMap<K, T>();
	}
	
	
	/**
	 * <p><b><i>agregar</i></b></p>
	 * <pre>public void agregar (K clave, T persona)</pre>
	 * @param clave Recibe la clave con la que será guardada la persona.
	 * @param persona Recibe la persona a ser guardada.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void agregar (K clave, T persona)
	{
		hMap.put(clave, persona);
	}
	
	
	/**
	 * <p><b><i>borrar</i></b></p>
	 * <pre>public void borrar (K clave)</pre>
	 * @param clave Recibe la clave de la persona a borrar.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void borrar (K clave)
	{
		hMap.remove(clave);
	}
	
	
	/**
	 * <p><b><i>listar</i></b></p>
	 * <pre>public String listar ()</pre>
	 * @return Retorna los nombres y apellidos de las personas que se encontraban en el listado en formato <code>String</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
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

	
	/**
	 * <p><b><i>modificar</i></b></p>
	 * <pre>public void modificar (K clave, T nuevaPersona)</pre>
	 * @param clave Recibe la clave de la persona a modificar.
	 * @param nuevaPersona Recibe a la persona por la cual se reemplazará a la anterior.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void modificar (K clave, T nuevaPersona)
	{
		hMap.replace(clave, nuevaPersona);
	}
	
	
	/**
	 * <p><b><i>mostrar</i></b></p>
	 * <pre>public String mostrar (K clave)</pre>
	 * @param clave Recibe la clave de la persona a mostrar.
	 * @return Retorna un <code>String</code> con los datos de la persona a mostrar.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String mostrar (K clave)
	{
		return hMap.get(clave).toString();
	}
	
	
	/**
	 * <p><b><i>contar</i></b></p>
	 * <pre>public int contar ()</pre>
	 * @return Retorna un <code>int</code> indicando cuantos registros hay en el listado.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public int contar () 
	{
		return hMap.size();
	}
	
	
	/**
	 * <p><b><i>buscar</i></b></p>
	 * <pre>public <K, T> K buscar (String apellido, String nombre)</pre>
	 * @param apellido Recibe el apellido de la persona a buscar.
	 * @param nombre Recibe el nombre de la persona a buscar.
	 * @return Retorna un tipo genérico <code>K</code> que indica la clave de la persona buscada.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public <K, T> K buscar (String apellido, String nombre)
	{		
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

	
	/**
	 * <p><b><i>toJSON</i></b></p>
	 * <pre>public JSONArray toJSON()</pre>
	 * @return Retorna un <code>JSONArray</code> con los datos del listado que ha llamado al método.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
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
	
	
	//TODO Documentar.
	
	public static void guardarEnArchivo (Listado<Integer, Persona> listado) 
	{
		Iterator <Entry<Integer, Persona>> it = listado.entrySet().iterator();
		
		while (it.hasNext())
		{
			Map.Entry<Integer, Persona> me = (Map.Entry<Integer, Persona>) it.next();
			Persona persona = me.getValue();
			GestorDeArchivos.guardar(persona, ARCHIVO); 
		}
	}
	
	public static Listado<Integer, Persona> leerDeArchivo () 
	{
		Listado<Integer, Persona> listado = new Listado<Integer, Persona>();
		
		//TODO aca hay una excepcion hecha asi nomas.
		
		try
		{
			Persona aux = GestorDeArchivos.leer(ARCHIVO);
			listado.agregar(aux.getNroLegajo(), aux);
		}
		catch (Exception e)
		{
			System.out.println("No se pudo leer el archivo");
		}
		
		return listado;
	}
	
}





