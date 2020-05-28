package Ejercicios;

public class Empleador extends Persona {
	
	private String actividad; 
	
	
	public Empleador() {
		super();
		actividad = " ";
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	@Override
	public String toString() {
		return super.toString() + "Empleador [actividad=" + actividad + "]";
	}
	
}
