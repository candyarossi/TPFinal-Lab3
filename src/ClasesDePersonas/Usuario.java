package ClasesDePersonas;

import org.json.JSONObject;
import Interfaces.IGenerarJSON;


public class Usuario implements IGenerarJSON
{
	
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
