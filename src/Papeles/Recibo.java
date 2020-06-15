package Papeles;

import java.time.LocalDate;

import ClasesDePersonas.Empleado;
import ClasesDePersonas.Empleador;


public class Recibo
{

	private Empleador empleador;
	private Empleado empleado;
	private double sueldoBasico;
	private LocalDate fechaPago;
	private LocalDate periodo;
	private int diasTrabajados;
	private int diasVacaciones;
	private double salarioNeto;
	private double jubilacion;
	private double ley;
	private double obraSocial;
	private double cuotaSindical;
	private double destajo;
	private double antiguedad;
	private double presentismo;
	private double sac;
	private double vacaciones;
	private double totalRemuneraciones;
	private double totalRetenciones;
	
	public Recibo()
	{
		super();
		empleador = new Empleador();
		empleado = new Empleado();
		sueldoBasico = 0;
		fechaPago = LocalDate.parse("");
		periodo = LocalDate.parse("");
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
		totalRemuneraciones = 0;
		totalRetenciones = 0;
	}
	
	public Recibo(Empleador empleador, Empleado empleado, double sueldoBasico, String fPago, String period, int diasTrabajados, int diasVacaciones)
	{
		super();
		this.empleador = empleador;
		this.empleado = empleado;
		this.sueldoBasico = sueldoBasico;
		fechaPago = LocalDate.parse(fPago);
		periodo = LocalDate.parse(period);
		this.diasTrabajados = diasTrabajados;
		this.diasVacaciones = diasVacaciones;
		obraSocial = calcularObraSocial(sueldoBasico);
		jubilacion = calcularJubilacion(sueldoBasico);
		ley = calcularLey19032(sueldoBasico);
		cuotaSindical = calcularCuotaSindical(sueldoBasico);
		destajo = calcularDestajo(sueldoBasico, diasTrabajados);
		antiguedad = calcularAntiguedad(sueldoBasico, empleado.getFechaIngreso(), LocalDate.parse(period));
		presentismo = calcularPresentismo(sueldoBasico, antiguedad);
		sac = calcularSAC(sueldoBasico, diasTrabajados, empleado.getFechaIngreso(), LocalDate.parse(period));
		vacaciones = calcularVacaciones(sueldoBasico, diasTrabajados, diasVacaciones); 
		totalRemuneraciones = calcularTotalRemuneraciones(sueldoBasico, diasTrabajados, diasVacaciones, empleado.getFechaIngreso(), LocalDate.parse(period));
		totalRetenciones = calcularTotalRetenciones(sueldoBasico);
		salarioNeto = calcularSalarioNeto(totalRemuneraciones, totalRetenciones);
	}

	public double getSueldoBasico()
	{
		return sueldoBasico;
	}


	public void setSueldoBasico(int sueldoBasico)
	{
		this.sueldoBasico = sueldoBasico;
	}


	public LocalDate getFechaPago()
	{
		return fechaPago;
	}


	public void setFechaPago(LocalDate fechaPago)
	{
		this.fechaPago = fechaPago;
	}


	public LocalDate getPeriodo()
	{
		return periodo;
	}


	public void setPeriodo(LocalDate periodo)
	{
		this.periodo = periodo;
	}


	public int getDiasTrabajados()
	{
		return diasTrabajados;
	}


	public void setDiasTrabajados(int diasTrabajados)
	{
		this.diasTrabajados = diasTrabajados;
	}


	public int getDiasVacaciones()
	{
		return diasVacaciones;
	}


	public void setDiasVacaciones(int diasVacaciones)
	{
		this.diasVacaciones = diasVacaciones;
	}
	

	public double calcularSalarioNeto(double totalRemuneraciones, double totalRetenciones)
	{
		return totalRemuneraciones-totalRetenciones;
	}


	public StringBuilder imprimirRecibo()
	{		
		StringBuilder sb = new StringBuilder();
		sb.append("\n-----------------------------------------------------\n");
		sb.append("RECIBO \n\n");
		sb.append("EMPLEADOR: \n");
		sb.append(empleador.toString());
		sb.append("\nEMPLEADO: \n");
		sb.append(empleado.toString());
		sb.append("\n\n\nRetenciones: \nDNRP = $ " + String.format ("%.2f", jubilacion)
				+ "\nINSSJP Ley 19032 = $ " + String.format ("%.2f", ley) 
				+ "\nObra Social " + empleado.getObraSocial() + " = $ " + String.format ("%.2f", obraSocial) 
				+ "\nCuota Sindical = $ " + String.format ("%.2f", cuotaSindical) 
				+ "\nTotal = $ " + String.format ("%.2f", totalRetenciones) + "\n"
				+ "\nRemuneraciones: \nDestajo = $ " + String.format ("%.2f", destajo)
				+ "\nPresentismo = $ " + String.format ("%.2f", presentismo) 
				+ "\nAntiguedad = $ " + String.format ("%.2f", antiguedad) 
				+ "\nSAC = $ " + String.format ("%.2f", sac) 
				+ "\nVacaciones = $ " + String.format ("%.2f", vacaciones) 
				+ "\nTotal = $ " + String.format ("%.2f", totalRemuneraciones) + "\n"
				+ "\nNeto a Percibir: $ " + String.format ("%.2f", salarioNeto) 
				+ "\n\nPeriodo Liquidado: " + periodo.getYear() + "-" + periodo.getMonthValue() 
				+ "\nFecha de Pago: " + fechaPago);
		sb.append("\n-----------------------------------------------------\n\n");
		return sb;
	}
	

	public double calcularJubilacion(double salarioBasico)
	{
		
		return salarioBasico*11/100;
	}

	
	public double calcularLey19032(double salarioBasico)
	{
		
		return salarioBasico*3/100;
	}

	
	
	public double calcularObraSocial(double salarioBasico)
	{
		return salarioBasico*3/100;
	}
	
	
	public double calcularCuotaSindical(double salarioBasico)
	{

		return salarioBasico*(double)2.5/100;
	}

	
	public double calcularTotalRetenciones(double salarioBasico)
	{
		
		jubilacion = calcularJubilacion(salarioBasico);
		ley = calcularLey19032(salarioBasico);
		obraSocial = calcularObraSocial(salarioBasico);
		cuotaSindical = calcularCuotaSindical(salarioBasico);
		
		return jubilacion+ley+obraSocial+cuotaSindical; 
	}

	
	public double calcularDestajo(double salarioBasico, int diasTrabajados)
	{
	
		return salarioBasico/30*diasTrabajados;
	}

	
	public double calcularPresentismo(double salarioBasico, double antiguedad)
	{
		
		return (salarioBasico+antiguedad)*(float)8.33/100;
	}

	
	public double calcularAntiguedad(double salarioBasico, LocalDate ingreso, LocalDate periodo)
	{
		
		int añosTrabajados = calcularAniosTrabajados(ingreso, periodo);
		
		return salarioBasico*añosTrabajados/100;
	}

	
	public double calcularSAC(double salarioBasico, int diasTrabajados, LocalDate ingreso, LocalDate periodo)
	{

		int mesesTrabajados = calcularMesesTrabajados(ingreso, periodo);
		
		if (mesesTrabajados > 6) return salarioBasico/2;
		else return salarioBasico/365*diasTrabajados;
	}

	
	public double calcularVacaciones(double salarioBasico, int diasTrabajados, int diasVacaciones)
	{
		
		return salarioBasico/diasTrabajados*diasVacaciones;
	}

	
	public double calcularTotalRemuneraciones(double salarioBasico, int diasTrabajados, int diasVacaciones, LocalDate ingreso, LocalDate periodo)
	{	
		destajo = calcularDestajo(salarioBasico, diasTrabajados);
		antiguedad = calcularAntiguedad(salarioBasico, ingreso, periodo);
		presentismo = calcularPresentismo(salarioBasico, antiguedad);
		sac = calcularSAC(salarioBasico, diasTrabajados, ingreso, periodo);
		vacaciones = calcularVacaciones(salarioBasico, diasTrabajados, diasVacaciones);
				
		return destajo+antiguedad+presentismo+sac+vacaciones;
	}
	
	
	public int calcularDiasTrabajados(LocalDate fechaGuardada, LocalDate fechaIngresada)
	{
		int cantidadDias = fechaIngresada.getDayOfMonth()-fechaGuardada.getDayOfMonth();
		int cantidadMeses = fechaIngresada.getMonthValue()-fechaGuardada.getMonthValue();
		int cantidadAnios = fechaIngresada.getYear()-fechaGuardada.getYear();
		
		int dias = cantidadDias + (cantidadMeses*30) + (cantidadAnios*365);
		
		if (dias<0)
			dias = dias*(-1);
		
		return dias;
	}

	
	public int calcularMesesTrabajados(LocalDate fechaGuardada, LocalDate fechaIngresada)
	{
		int diasTrabajados = calcularDiasTrabajados(fechaGuardada, fechaIngresada);
		
		int meses = (int)diasTrabajados/30;
				
		return meses;
	}
	
	
	public int calcularAniosTrabajados(LocalDate fechaGuardada, LocalDate fechaIngresada)
	{
		int diasTrabajados = calcularDiasTrabajados(fechaGuardada, fechaIngresada);
		
		int meses = (int)diasTrabajados/365;
				
		return meses;
	}
	

}
