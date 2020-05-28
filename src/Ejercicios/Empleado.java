package Ejercicios;

import java.util.Date;

public class Empleado extends Persona {
		
	private String categoria;
	private String obraSocial;
	private Date fechaIngreso;
	
	
	public Empleado() {
		super();
		categoria = " ";
		obraSocial = " ";
		fechaIngreso = new Date();
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getObraSocial() {
		return obraSocial;
	}
	
	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}
	
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return super.toString() +  "Empleado [categoria=" + categoria + ", obraSocial=" + obraSocial + ", fechaIngreso=" + fechaIngreso
				+ "]";
	} 
	
}
