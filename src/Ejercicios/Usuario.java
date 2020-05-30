package Ejercicios;

public class Usuario {
	
	private String nickname;
	private String password;
	
	public Usuario() {
		
		nickname = " ";
		password = " ";
		
	}
	
	
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [nickname=" + nickname + ", password=" + password + "]";
	} 
	
}
