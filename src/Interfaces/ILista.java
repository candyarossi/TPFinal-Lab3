package Interfaces;


/**
 * <p><b><i>ILista</i></b></p>
 * <pre>public interface ILista<K, T></pre>
 * <p>La interfaz <code>ILista</code> contiene una serie de métodos a redefinir en aquellas clases que necesiten realizar estas operaciones básicas.</p>
 * @author Yarossi, Candela & Trucco, Nahuel
 */
public interface ILista<K, T>
{
	public void agregar (K clave, T valor);
	public void borrar (K clave);
	public void modificar (K clave, T nuevoValor);
	public int contar();
	public String listar ();
	public String mostrar (K clave);
}
