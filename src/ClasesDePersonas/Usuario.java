package ClasesDePersonas;

import org.json.JSONObject;
import Interfaces.IGenerarJSON;


/**
 * <p><b><i>Usuario</i></b></p>
 * <pre>public class Usuario</pre>
 * <p>La clase <code>Usuario</code> contiene todos los métodos necesarios para instanciar un usuario. Esta clase implementa la interfaz <code>IGenerarJSON</code>.</p>
 * @author Yarossi, Candela & Trucco, Nahuel
 */
public class Usuario implements IGenerarJSON
{
	
	//TODO esta clase probablemente ni la usemos, pero dejemosla por las dudas.
	//TODO documentar esto.
	
	private String nickname;
	private String password;
	
	
	public Usuario()
	{
		nickname = " ";
		password = " ";
	}
	
	public Usuario(String nickname, String password)
	{
		this.nickname = nickname;
		this.password = password;
	}


	public String getNickname()
	{
		return nickname;
	}
	
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "\nNickname:" + nickname + "\nPassword=" + password;
	}

	@Override
	public JSONObject toJSON() {
		// TODO Auto-generated method stub
		return null;
	} 
	
}
