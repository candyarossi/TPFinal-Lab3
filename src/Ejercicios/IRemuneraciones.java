package Ejercicios;

public interface IRemuneraciones {
	
	float calcularDestajo(float salarioBasico, int diasTrabajados ); 
	float calcularPresentismo(float salarioBasico, float antiguedad); 
	float calcularAntiguedad(float salarioBasico); 
	float calcularSAC(float salarioBasico, int diasTrabajados); 
	float calcularVacaciones(float salarioBasico, int diasTrabajados, int diasVacaciones);
	float calcularTotalRemuneraciones(float salarioBasico, int diasTrabajados, int diasVacaciones); 
}
