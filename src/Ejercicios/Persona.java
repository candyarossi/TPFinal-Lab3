package Ejercicios;

import java.lang.StringBuilder;

public class Persona {
	
	//TODO Hacer ABSTRACTA Persona, la deje concreta para probar algunas cosas. 

	private String nombre;
	private String apellido;
	private StringBuilder cuil; 
	private StringBuilder dni;
	private String lugarNacimiento;
	private String nacionalidad;
	private String direccion;
	private String lugarResidencia;
	private String telefono;
	private String email; 
	public int nroLegajo; 
	public static int cantidad = 0;
	
	
	public Persona() {
		super();
		nombre = " ";
		apellido = " ";
		cuil = new StringBuilder();
		dni = new StringBuilder();
		lugarNacimiento = " ";
		nacionalidad = " ";
		direccion = " ";
		lugarResidencia = " ";
		telefono = " ";
		email = " ";
		nroLegajo = Persona.cantidad;
		cantidad++;
	}
	
	public Persona(String nombre, String apellido, StringBuilder cuil, String lugarNacimiento,
			String nacionalidad, String direccion, String lugarResidencia, String telefono, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		setDni(cuil);
		this.lugarNacimiento = lugarNacimiento;
		this.nacionalidad = nacionalidad;
		this.direccion = direccion;
		this.lugarResidencia = lugarResidencia;
		this.telefono = telefono;
		this.email = email;
		nroLegajo = Persona.cantidad;
		cantidad++;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public StringBuilder getCuil() {
		return cuil;
	} 
	
	public void setCuil(StringBuilder cuil) {
		setDni(cuil);
		this.cuil = cuil;
		cuil.insert(2, "-");
		cuil.insert(11, "-");

	}
	
	private void setDni(StringBuilder cuil) {
		dni.append(cuil.substring(2, 10));
		dni.insert(2, ".");
		dni.insert(6, ".");
	}
	
	public StringBuilder getDni () {
		return dni; 
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
	
	public void setNroLegajo() {
		nroLegajo = Persona.cantidad;
		cantidad++;	
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", cuil=" + cuil + ", dni=" + dni + ", lugarNacimiento="
				+ lugarNacimiento + ", nacionalidad=" + nacionalidad + ", direccion=" + direccion + ", lugarResidencia="
				+ lugarResidencia + ", telefono=" + telefono + ", email=" + email + ", nroLegajo=" + nroLegajo + "]";
	}

	@Override
	public int hashCode() {
		return 1;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean esIgual = false;
		Persona aux = (Persona) obj; 
		if (this.getCuil().equals(aux.getCuil())) {
			esIgual = true; 
		}
		return esIgual;
	}

}
