package Excepciones;


/**
 * <p><b><i>ExcepcionDeCampoVacio</i></b></p>
 * <pre>public class ExcepcionDeCampoVacio extends Exception</pre>
 * <p>Excepción que se arroja -como su nombre lo indica- cuando una función pide la carga de un dato pero el usuario lo deja vacío.</P>
 * <p>Esta excepción se usa solo a modo de prueba y demostración, ya que el mismo caso se puede resolver de una manera mucho más simple.</p>
 * @author Yarossi, Candela & Trucco, Nahuel
 */
public class ExcepcionDeCampoVacio extends RuntimeException
{
	public ExcepcionDeCampoVacio()
	{
		// TODO (?
	}
	
	public ExcepcionDeCampoVacio(String mensaje)
	{
		super(mensaje);
	}
	
}
