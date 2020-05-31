package Ejercicios;

import java.time.LocalDate;

public interface IRemuneraciones {
	
	float calcularDestajo(float salarioBasico, int diasTrabajados ); 
	float calcularPresentismo(float salarioBasico, float antiguedad); 
	float calcularAntiguedad(float salarioBasico, LocalDate ingreso, LocalDate periodo); 
	float calcularSAC(float salarioBasico, int diasTrabajados, LocalDate ingreso, LocalDate periodo); 
	float calcularVacaciones(float salarioBasico, int diasTrabajados, int diasVacaciones);
	float calcularTotalRemuneraciones(float salarioBasico, int diasTrabajados, int diasVacaciones, LocalDate ingreso, LocalDate periodo); 
}
