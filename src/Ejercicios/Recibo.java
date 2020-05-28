package Ejercicios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.text.ParseException;


public class Recibo implements Remuneraciones, Retenciones {

	private float sueldoBasico;
	private Date fechaPago;
	private Date periodo;
	private int diasTrabajados;
	private int diasVacaciones;
	private float salarioNeto;
	private float jubilacion;
	private float ley;
	private float obraSocial;
	private float cuotaSindical;
	private float destajo;
	private float antiguedad;
	private float presentismo;
	private float sac;
	private float vacaciones;
	
	
	public Recibo() {
		super();
		sueldoBasico = 0;
		fechaPago = new Date();
		periodo = new Date();
		diasTrabajados = 0;
		diasVacaciones = 0;
		salarioNeto = 0;
		jubilacion = 0;
		ley = 0;
		obraSocial = 0;
		cuotaSindical = 0;
		destajo = 0;
		antiguedad = 0;
		presentismo = 0;
		sac = 0;
		vacaciones = 0;
	}


	public float getSueldoBasico() {
		return sueldoBasico;
	}


	public void setSueldoBasico(int sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}


	public Date getFechaPago() {
		return fechaPago;
	}


	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}


	public Date getPeriodo() {
		return periodo;
	}


	public void setPeriodo(Date periodo) {
		this.periodo = periodo;
	}


	public int getDiasTrabajados() {
		return diasTrabajados;
	}


	public void setDiasTrabajados(int diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}


	public int getDiasVacaciones() {
		return diasVacaciones;
	}


	public void setDiasVacaciones(int diasVacaciones) {
		this.diasVacaciones = diasVacaciones;
	}
	

	public float calcularSalarioNeto(float totalRemuneraciones, float totalRetenciones) {
		
		return totalRemuneraciones-totalRetenciones;
	}


	public String imprimirRecibo(String nombreObraSocial, float salarioBasico, int diasTrabajados, int diasVacaciones) {
		
		//TODO Recibo impreso 
		float remuneraciones = calcularTotalRemuneraciones(salarioBasico, diasTrabajados, diasVacaciones);
		float retenciones = calcularTotalRetenciones(salarioBasico);
		salarioNeto = calcularSalarioNeto(remuneraciones, retenciones); 
		
		return "Recibo de Sueldo"
				+ "Retenciones: [DNRP= " + jubilacion + ", INSSJP Ley 19032= " + ley + ", Obra Social " + nombreObraSocial + "= " + obraSocial + ", Cuota Sindical= " + cuotaSindical + ", Total= " + remuneraciones + "]"
				+ "Remuneraciones: [Destajo= " + destajo + ", Presentismo= " + presentismo + ", Antiguedad= " + antiguedad + ", SAC= " + sac + ", Vacaciones= " + vacaciones + ", Total= " + retenciones + "]";

		
	}
	
	
	public int calcularDiasTrabajadosDesdeInicioDeActividad() throws ParseException {
		
		//TODO 
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		Date dia1 = new Date();
		Date dia2 = new Date();

		dia1 = dateFormat.parse("2020-05-15");
		dia2 = dateFormat.parse("2020-05-22");

		int dias = (int)((dia2.getTime()-dia1.getTime())/86400000);
		
		System.out.println("dias= " + dias);
		
		return 0;
	}


	@Override
	public float calcularJubilacion(float salarioBasico) {
		
		return salarioBasico*11/100;
	}


	@Override
	public float calcularLey19032(float salarioBasico) {
		
		return salarioBasico*3/100;
	}


	@Override
	public float calcularObraSocial(float salarioBasico) {

		return salarioBasico*3/100;
	}


	@Override
	public float calcularCuotaSindical(float salarioBasico) {

		return salarioBasico*(float)2.5/100;
	}


	@Override
	public float calcularTotalRetenciones(float salarioBasico) {
		
		jubilacion = calcularJubilacion(salarioBasico);
		ley = calcularLey19032(salarioBasico);
		obraSocial = calcularObraSocial(salarioBasico);
		cuotaSindical = calcularCuotaSindical(salarioBasico);
		
		return jubilacion+ley+obraSocial+cuotaSindical; 
	}


	@Override
	public float calcularDestajo(float salarioBasico, int diasTrabajados) {
	
		return salarioBasico/30*diasTrabajados;
	}


	@Override
	public float calcularPresentismo(float salarioBasico, float antiguedad) {
		
		return (salarioBasico+antiguedad)*(float)8.33/100;
	}


	@Override
	public float calcularAntiguedad(float salarioBasico) {
		
		//TODO calcular años trabajados
		int añosTrabajados = 1;
		
		return salarioBasico*añosTrabajados/100;
	}


	@Override
	public float calcularSAC(float salarioBasico, int diasTrabajados) {
		
		//TODO calcular meses trabajados
		int mesesTrabajados = 1;
		
		if (mesesTrabajados > 6) return salarioBasico/2;
		else return salarioBasico/365*diasTrabajados;
	}


	@Override
	public float calcularVacaciones(float salarioBasico, int diasTrabajados, int diasVacaciones) {
		
		return salarioBasico/diasTrabajados*diasVacaciones;
	}


	@Override
	public float calcularTotalRemuneraciones(float salarioBasico, int diasTrabajados, int diasVacaciones) {
		
		destajo = calcularDestajo(salarioBasico, diasTrabajados);
		antiguedad = calcularAntiguedad(salarioBasico);
		presentismo = calcularPresentismo(salarioBasico, antiguedad);
		sac = calcularSAC(salarioBasico, diasTrabajados);
		vacaciones = calcularVacaciones(salarioBasico, diasTrabajados, diasVacaciones);
				
		return destajo+antiguedad+presentismo+sac+vacaciones;
	}
	
	

}
