package ListadosGenericos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import Archivos.GestorDeArchivos;
import ClasesDePersonas.Empleado;
import ClasesDePersonas.Empleador;
import ClasesDePersonas.Persona;
import Interfaces.ILista;


/**
 * <p><b><i>Listado <K, T extends Persona></i></b></p>
 * <pre>public class Listado <K, T extends Persona> implements Serializable</pre>
 * <p>La clase <code>Listado <K, T extends Persona></code> es una clase genérica que puede ser utilizada para generar diferentes tipos de listados, 
 * donde K sea una clave única y significativa para el objeto y T sea un objeto que extienda de <code>Persona</code>. Esta clase implementa las
 * interfaces <code>Serializable</code> y <code>ILista</code>.</p>
 * @author Yarossi, Candela & Trucco, Nahuel
 */
public class Listado <K, T extends Persona> implements Serializable, ILista<K, T>
{

	private HashMap<K, T> hMap;
	
	
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
	 * <p>Sobreescritura del método <code>guardar()</code> perteneciente a la interfaz <code>ILista</code>.</p>
	 * @param clave Recibe la clave con la que será guardada la persona.
	 * @param persona Recibe la persona a ser guardada.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	@Override
	public void agregar (K clave, T persona)
	{
		hMap.put(clave, persona);
	}
	
	
	/**
	 * <p><b><i>borrar</i></b></p>
	 * <pre>public void borrar (K clave)</pre>
	 * <p>Sobreescritura del método <code>borrar()</code> perteneciente a la interfaz <code>ILista</code>.</p>
	 * @param clave Recibe la clave de la persona a borrar.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	@Override
	public void borrar (K clave)
	{
		hMap.remove(clave);
	}
	
	
	/**
	 * <p><b><i>listar</i></b></p>
	 * <pre>public String listar ()</pre>
	 * <p>Sobreescritura del método <code>listar()</code> perteneciente a la interfaz <code>ILista</code>.</p>
	 * @return Retorna los nombres y apellidos de las personas que se encontraban en el listado en formato <code>String</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	@Override
	public String listar ()
	{
		StringBuilder strBuildable = new StringBuilder();
		Iterator <Entry<K, T>> it = hMap.entrySet().iterator();
		
		while (it.hasNext())
		{
			Map.Entry<K, T> me = (Map.Entry<K, T>) it.next();
			Persona aux = (Persona) me.getValue();
			
			strBuildable.append("- " + aux.getApellido() + ", "+ aux.getNombre() +"\n");
		}
		
		return strBuildable.toString();
	}
	

	/**
	 * <p><b><i>modificar</i></b></p>
	 * <pre>public void modificar (K clave, T nuevaPersona)</pre>
	 * <p>Sobreescritura del método <code>modificar()</code> perteneciente a la interfaz <code>ILista</code>.</p>
	 * @param clave Recibe la clave de la persona a modificar.
	 * @param nuevaPersona Recibe a la persona por la cual se reemplazará a la anterior.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	@Override
	public void modificar (K clave, T nuevaPersona)
	{
		hMap.replace(clave, nuevaPersona);
	}
	
	
	/**
	 * <p><b><i>mostrar</i></b></p>
	 * <pre>public String mostrar (K clave)</pre>
	 * <p>Sobreescritura del método <code>mostrar()</code> perteneciente a la interfaz <code>ILista</code>.</p>
	 * @param clave Recibe la clave de la persona a mostrar.
	 * @return Retorna un <code>String</code> con los datos de la persona a mostrar.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	@Override
	public String mostrar (K clave)
	{
		return hMap.get(clave).toString();
	}
	
	
	/**
	 * <p><b><i>getEmpleador</i></b></p>
	 * <pre>public Empleador getEmpleador (K clave)</pre>
	 * @param clave Recibe la clave del empleador que se busca.
	 * @return Retorna un <code>Empleador</code> con los datos de la persona correspondiente a la clave que recibe por parametro.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public Empleador getEmpleador(K clave)
	{
		return (Empleador) hMap.get(clave);
	}
	
	
	/**
	 * <p><b><i>contar</i></b></p>
	 * <pre>public int contar ()</pre>
	 * <p>Sobreescritura del método <code>contar()</code> perteneciente a la interfaz <code>ILista</code>.</p>
	 * @return Retorna un <code>int</code> indicando cuantos registros hay en el listado.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	@Override
	public int contar () 
	{
		return hMap.size();
	}
	
	
	/**
	 * <p><b><i>buscar</i></b></p>
	 * <pre>public <K, T> K buscar (String apellido, String nombre)</pre>
	 * @param apellido Recibe el apellido de la persona a buscar.
	 * @param nombre Recibe el nombre de la persona a buscar.
	 * @return Retorna un tipo genérico <code>K</code> que indica la clave de la persona buscada, o <code>null</code> si no existe.
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
	 * <pre>public JSONArray toJSON ()</pre>
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
	
	
	/**
	 * <p><b><i>setNombreArchivosEmpleadores</i></b></p>
	 * <pre>public ArrayList<String> setNombreArchivosEmpleadores ()</pre>
	 * @return Retorna un <code>ArrayList</code> con los nombres de los archivos que contienen a cada uno de los empleadores.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */ 
	public ArrayList<String> setNombreArchivosEmpleadores () 
	{
		ArrayList<String> array = new ArrayList<String>();
		
		Iterator<Entry<K, T>> it = hMap.entrySet().iterator();
		
		while (it.hasNext())
		{
			Map.Entry<K, T> me = (Map.Entry<K, T>) it.next();
			Empleador aux = (Empleador) me.getValue();
			array.add(aux.getNombreArchivo());
		}
		
		return array;
	}
	
	
	/**
	 * <p><b><i>guardarCuils</i></b></p>
	 * <pre>public static void guardarCuils (ArrayList<String> array)</pre>
	 * @param array Recibe un array con los nombres de los archivos de empleadores y los guarda.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public static void guardarCuils (ArrayList<String> array)
	{
		GestorDeArchivos.guardarCuils(array);
	}
	
	
	/**
	 * <p><b><i>leerCuils</i></b></p>
	 * <pre>public static ArrayList<String> leerCuils ()</pre>
	 * @return Retorna un <code>ArrayList</code> con los nombres de los archivos que contienen a los empleadores.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public static ArrayList<String> leerCuils ()
	{
		ArrayList<String> array = new ArrayList<String>();
		array = GestorDeArchivos.leerCuils();
		return array;
	}
	
	
	/**
	 * <p><b><i>guardarListadoEnArchivos</i></b></p>
	 * <pre>public void guardarListadoEnArchivos ()</pre>
	 * <p>Guarda el listado de empleadores en sus correspondientes archivos.</p>
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void guardarListadoEnArchivos ()
	{
		Iterator<Entry<K, T>> it = hMap.entrySet().iterator();
		
		while (it.hasNext())
		{
			Map.Entry<K, T> me = (Map.Entry<K, T>) it.next();
			Empleador aux = (Empleador) me.getValue();
			Empleador.guardarEnArchivo(aux);
		}
	}
	
	
	/**
	 * <p><b><i>generarListadoDeArchivo</i></b></p>
	 * <pre>public static Listado<Integer, Empleador> generarListadoDeArchivo ()</pre>
	 * @return Retorna un listado de empleadores generado a partir de los archivos guardados.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public static Listado<Integer, Empleador> generarListadoDeArchivo ()
	{
		Listado<Integer, Empleador> listado = new Listado<Integer, Empleador>();
		ArrayList<String> array = GestorDeArchivos.leerCuils();
		
		for(String archivo : array)
		{
			Empleador emp = GestorDeArchivos.leerEmpleador(archivo);
			listado.agregar(emp.getNroLegajo(), emp);
		}
		
		return listado;
	}
	
	
	/**
	 * <p><b><i>vaciarListado</i></b></p>
	 * <pre>public void vaciarListado ()</pre>
	 * <p>Elimina todas las asignaciones de este listado. El listado estará vacío después invocar este método.</p>
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void vaciarListado()
	{
		hMap.clear();
	}
	
	
	/**
	 * <p><b><i>getHashMap</i></b></p>
	 * <pre>public HashMap<K, T> getHashMap()</pre>
	 * @return Retorna el <code>HashMap</code> que trabaja de fondo en <code>Listado</code>
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public HashMap<K, T> getHashMap()
	{
		return hMap;
	}
	
}





