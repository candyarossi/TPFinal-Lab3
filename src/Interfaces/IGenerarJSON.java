package Interfaces;

import org.json.JSONObject;


/**
 * <p><b><i>IGenerarJSON</i></b></p>
 * <pre>public interface IGenerarJSON</pre>
 * <p>La interfaz <code>IGenerarJSON</code> contiene un único método a definir en aquellas clases que necesiten ser convertidas a <code>JSON</code> y retornar un <code>JSONObject</code>.</p>
 * @author Yarossi, Candela & Trucco, Nahuel
 */
public interface IGenerarJSON
{
	JSONObject toJSON();
}
