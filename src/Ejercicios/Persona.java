package Ejercicios;

import java.lang.StringBuilder;

public abstract class Persona {

	private String nombres;
	private String apellidos;
	private String cuil; 
	private StringBuilder dni;
	private String lugarNacimiento;
	private String nacionalidad;
	private String direccion;
	private String lugarResidencia;
	private String telefono;
	private String email; 
	private int nroLegajo;
	
	
	public Persona() {
		super();
		nombres = " ";
		apellidos = " ";
		cuil = " ";
		dni = new StringBuilder();
		lugarNacimiento = " ";
		nacionalidad = " ";
		direccion = " ";
		lugarResidencia = " ";
		telefono = " ";
		email = " ";
		nroLegajo = 0;
	}
	
	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getCuil() {
		return cuil;
	} 
	
	public void setCuil(String cuil) {
		this.cuil = cuil;
		setDni(cuil);
	}
	
	public void setDni(String cuil) {
		dni.append(cuil.substring(3, 11));
		dni.insert(2, ".");
		dni.insert(6, ".");
	}
	
	public String getLugarNacimiento() {
		return lugarNacimiento;
	}
	
	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getLugarResidencia() {
		return lugarResidencia;
	}
	
	public void setLugarResidencia(String lugarResidencia) {
		this.lugarResidencia = lugarResidencia;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getNroLegajo() {
		return nroLegajo;
	}
	
	public void setNroLegajo(int nroLegajo) {
		this.nroLegajo = nroLegajo;
	}

	@Override
	public String toString() {
		return "Persona [nombres=" + nombres + ", apellidos=" + apellidos + ", cuil=" + cuil + ", dni=" + dni + ", lugarNacimiento="
				+ lugarNacimiento + ", nacionalidad=" + nacionalidad + ", direccion=" + direccion + ", lugarResidencia="
				+ lugarResidencia + ", telefono=" + telefono + ", email=" + email + ", nroLegajo=" + nroLegajo + "]";
	}

}
