package Ejercicios;

import java.time.LocalDate;

public class Recibo implements IRemuneraciones, IRetenciones
{

	private Empleador empleador;
	private Empleado empleado;
	private float sueldoBasico;
	private LocalDate fechaPago;
	private LocalDate periodo;
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
	private float totalRemuneraciones;
	private float totalRetenciones;
	
	public Recibo()
	{
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
	
	public Recibo(Empleador empleador, Empleado empleado, float sueldoBasico, LocalDate fechaPago, LocalDate periodo, int diasTrabajados, int diasVacaciones, float obraSocial)
	{
		this.empleador = empleador;
		this.empleado = empleado;
		this.sueldoBasico = sueldoBasico;
		this.fechaPago = fechaPago;
		this.periodo = periodo;
		this.diasTrabajados = diasTrabajados;
		this.diasVacaciones = diasVacaciones;
		obraSocial = calcularObraSocial(sueldoBasico);
		jubilacion = calcularJubilacion(sueldoBasico);
		ley = calcularLey19032(sueldoBasico);
		cuotaSindical = calcularCuotaSindical(sueldoBasico);
		destajo = calcularDestajo(sueldoBasico, diasTrabajados);
		antiguedad = calcularAntiguedad(sueldoBasico, empleado.getFechaIngreso(), periodo);
		presentismo = calcularPresentismo(sueldoBasico, antiguedad);
		sac = calcularSAC(sueldoBasico, diasTrabajados, empleado.getFechaIngreso(), periodo);
		vacaciones = calcularVacaciones(sueldoBasico, diasTrabajados, diasVacaciones); 
		totalRemuneraciones = calcularTotalRemuneraciones(sueldoBasico, diasTrabajados, diasVacaciones, empleado.getFechaIngreso(), periodo);
		totalRetenciones = calcularTotalRetenciones(sueldoBasico);
		salarioNeto = calcularSalarioNeto(totalRemuneraciones, totalRetenciones);
	}

	public float getSueldoBasico()
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
	

	public float calcularSalarioNeto(float totalRemuneraciones, float totalRetenciones)
	{
		return totalRemuneraciones-totalRetenciones;
	}


	public StringBuilder imprimirRecibo()
	{
		
		//TODO Hacer mas bonito el recibo impreso con datos del Empleador y Empleado, lo que esta aca abajo, y el periodo y fecha de pago.
		
		StringBuilder sb = new StringBuilder();
		sb.append(empleador.toString());
		sb.append(empleado.toString());
		sb.append("Recibo de Sueldo"
				+ "Retenciones: [DNRP= " + jubilacion 
				+ ", INSSJP Ley 19032= " + ley 
				+ ", Obra Social " + empleado.getObraSocial() + "= " + obraSocial 
				+ ", Cuota Sindical= " + cuotaSindical 
				+ ", Total= " + totalRemuneraciones + "]"
				+ "Remuneraciones: [Destajo= " + destajo
				+ ", Presentismo= " + presentismo 
				+ ", Antiguedad= " + antiguedad 
				+ ", SAC= " + sac 
				+ ", Vacaciones= " + vacaciones 
				+ ", Total= " + totalRetenciones + "]"
				+ "Neto a Percibir: " + salarioNeto 
				+ "Periodo Liquidado= " + periodo 
				+ "Fecha de Pago= " + fechaPago);
		return sb;
	}
	

	@Override
	public float calcularJubilacion(float salarioBasico)
	{
		
		return salarioBasico*11/100;
	}

	
	@Override
	public float calcularLey19032(float salarioBasico)
	{
		
		return salarioBasico*3/100;
	}

	
	@Override
	public float calcularObraSocial(float salarioBasico)
	{
		return salarioBasico*3/100;
	}
	
	
	@Override
	public float calcularCuotaSindical(float salarioBasico)
	{

		return salarioBasico*(float)2.5/100;
	}

	
	@Override
	public float calcularTotalRetenciones(float salarioBasico)
	{
		
		jubilacion = calcularJubilacion(salarioBasico);
		ley = calcularLey19032(salarioBasico);
		obraSocial = calcularObraSocial(salarioBasico);
		cuotaSindical = calcularCuotaSindical(salarioBasico);
		
		return jubilacion+ley+obraSocial+cuotaSindical; 
	}

	
	@Override
	public float calcularDestajo(float salarioBasico, int diasTrabajados)
	{
	
		return salarioBasico/30*diasTrabajados;
	}

	
	@Override
	public float calcularPresentismo(float salarioBasico, float antiguedad)
	{
		
		return (salarioBasico+antiguedad)*(float)8.33/100;
	}

	
	@Override
	public float calcularAntiguedad(float salarioBasico, LocalDate ingreso, LocalDate periodo)
	{
		
		int añosTrabajados = calcularAniosTrabajados(ingreso, periodo);
		
		return salarioBasico*añosTrabajados/100;
	}

	
	@Override
	public float calcularSAC(float salarioBasico, int diasTrabajados, LocalDate ingreso, LocalDate periodo)
	{

		int mesesTrabajados = calcularMesesTrabajados(ingreso, periodo);
		
		if (mesesTrabajados > 6) return salarioBasico/2;
		else return salarioBasico/365*diasTrabajados;
	}

	
	@Override
	public float calcularVacaciones(float salarioBasico, int diasTrabajados, int diasVacaciones)
	{
		
		return salarioBasico/diasTrabajados*diasVacaciones;
	}

	
	@Override
	public float calcularTotalRemuneraciones(float salarioBasico, int diasTrabajados, int diasVacaciones, LocalDate ingreso, LocalDate periodo)
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
