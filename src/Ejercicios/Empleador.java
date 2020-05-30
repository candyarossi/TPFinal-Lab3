package Ejercicios;

public class Empleador extends Persona {
	
	private String actividad; 
	
	public Empleador() {
		super();
		actividad = " ";
	}
	
	public Empleador(String nombre, String apellido, String cuil, String lugarNacimiento, String nacionalidad,
			String direccion, String lugarResidencia, String telefono, String email, int nroLegajo, String actividad) {
		super(nombre, apellido, new StringBuilder (cuil), lugarNacimiento, nacionalidad, direccion, lugarResidencia, telefono, email);
		this.actividad = actividad;
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
