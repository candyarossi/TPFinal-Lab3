package Papeles;

import java.time.LocalDate;

import ClasesDePersonas.Empleado;
import ClasesDePersonas.Empleador;


/**
 * <p><b><i>Recibo</i></b></p>
 * <pre>public class Recibo</pre>
 * <p>La clase <code>Recibo</code> contiene todos los métodos necesarios para la impresión de un recibo por pantalla.</p>
 * @author Yarossi, Candela & Trucco, Nahuel
 */
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
	
	
	/**
	 * <p><b><i>Recibo</i></b></p>
	 * <pre>public Recibo ()</pre>
	 * <p>Constructor de la clase <code>Recibo</code>.</p>
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
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
	
	
	/**
	 * <p><b><i>Recibo</i></b></p>
	 * <pre>public Recibo (Empleador empleador, Empleado empleado, double sueldoBasico, String fPago, String period, int diasTrabajados, int diasVacaciones)</pre>
	 * <p>Constructor de la clase <code>Recibo</code>.</p>
	 * @param empleador Recibe el empleador al cual se le generará el recibo.
	 * @param empleado Recibe el empleado del cual se generará el recibo.
	 * @param sueldoBasico Recibe el valor del salario mínimo vital y móvil.
	 * @param fPago Recibe la fecha en la cual se debe realizar el pago en formato <code>yyyy-mm-dd</code>.
	 * @param period Recibe la fecha del periodo que se va a pagar en formato <code>yyyy-mm-dd</code>.
	 * @param diasTrabajados Recibe la cantidad de días que el empleado ha trabajado en este periodo.
	 * @param diasVacaciones Recibe la cantidad de días que el empleado se ha tomado de vacaciones en este periodo.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public Recibo(Empleador empleador, Empleado empleado, double sueldoBasico, String fPago, String periodo, int diasTrabajados, int diasVacaciones)
	{
		super();
		this.empleador = empleador;
		this.empleado = empleado;
		this.sueldoBasico = sueldoBasico;
		fechaPago = LocalDate.parse(fPago);
		this.periodo = LocalDate.parse(periodo);
		this.diasTrabajados = diasTrabajados;
		this.diasVacaciones = diasVacaciones;
		obraSocial = calcularObraSocial(sueldoBasico);
		jubilacion = calcularJubilacion(sueldoBasico);
		ley = calcularLey19032(sueldoBasico);
		cuotaSindical = calcularCuotaSindical(sueldoBasico);
		destajo = calcularDestajo(sueldoBasico, diasTrabajados);
		antiguedad = calcularAntiguedad(sueldoBasico, empleado.getFechaIngreso(), LocalDate.parse(periodo));
		presentismo = calcularPresentismo(sueldoBasico, antiguedad);
		sac = calcularSAC(sueldoBasico, diasTrabajados, empleado.getFechaIngreso(), LocalDate.parse(periodo));
		vacaciones = calcularVacaciones(sueldoBasico, diasTrabajados, diasVacaciones); 
		totalRemuneraciones = calcularTotalRemuneraciones(sueldoBasico, diasTrabajados, diasVacaciones, empleado.getFechaIngreso(), LocalDate.parse(periodo));
		totalRetenciones = calcularTotalRetenciones(sueldoBasico);
		salarioNeto = calcularSalarioNeto(totalRemuneraciones, totalRetenciones);
	}

	
	/**
	 * <p><b><i>getSueldoBasico</i></b></p>
	 * <pre>public double getSueldoBasico ()</pre>
	 * @return Retorna el sueldo básico en formato <code>double</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public double getSueldoBasico()
	{
		return sueldoBasico;
	}


	/**
	 * <p><b><i>setSueldoBasico</i></b></p>
	 * <pre>public void setSueldoBasico (int sueldoBasico)</pre>
	 * @param sueldoBasico Recibe el sueldo básico del empleado.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setSueldoBasico(int sueldoBasico)
	{
		this.sueldoBasico = sueldoBasico;
	}


	/**
	 * <p><b><i>getFechaPago</i></b></p>
	 * <pre>public LocalDate getFechaPago ()</pre>
	 * @return Retorna la fecha de pago en formato <code>yyyy-mm-dd</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public LocalDate getFechaPago()
	{
		return fechaPago;
	}
	
	
	/**
	 * <p><b><i>setFechaPago</i></b></p>
	 * <pre>public void setFechaPago (String fPago)</pre>
	 * @param fPago Recibe la fecha de pago en formato <code>yyyy-mm-dd</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setFechaPago(String fPago)
	{
		this.fechaPago = LocalDate.parse(fPago);
	}


	/**
	 * <p><b><i>getPeriodo</i></b></p>
	 * <pre>public String getPeriodo ()</pre>
	 * @return Retorna el periodo liquidado en formato <code>yyyy-mm</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String getPeriodo()
	{
		return periodo.getYear() + "-" + periodo.getMonthValue();
	}


	/**
	 * <p><b><i>setPeriodo</i></b></p>
	 * <pre>public void setPeriodo (String period)</pre>
	 * @param period Recibe el periodo liquidado en formato <code>yyyy-mm-dd</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setPeriodo(String period)
	{
		this.periodo = LocalDate.parse(period);
	}


	/**
	 * <p><b><i>getDiasTrabajados</i></b></p>
	 * <pre>public int getDiasTrabajados ()</pre>
	 * @return Retorna la cantidad de días trabajados en formato <code>int</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public int getDiasTrabajados()
	{
		return diasTrabajados;
	}


	/**
	 * <p><b><i>setDiasTrabajados</i></b></p>
	 * <pre>public void setDiasTrabajados (int diasTrabajados)</pre>
	 * @param diasTrabajados Recibe la cantidad de días trabajados por el empleado.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setDiasTrabajados(int diasTrabajados)
	{
		this.diasTrabajados = diasTrabajados;
	}


	/**
	 * <p><b><i>getDiasVacaciones</i></b></p>
	 * <pre>public int getDiasVacaciones ()</pre>
	 * @return Retorna la cantidad de días de vacaciones en formato <code>int</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public int getDiasVacaciones()
	{
		return diasVacaciones;
	}


	/**
	 * <p><b><i>setDiasVacaciones</i></b></p>
	 * <pre>public void setDiasVacaciones (int diasVacaciones)</pre>
	 * @param diasVacaciones Recibe la cantidad de días de vacaciones que tuvo el empleado.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setDiasVacaciones(int diasVacaciones)
	{
		this.diasVacaciones = diasVacaciones;
	}
	

	/**
	 * <p><b><i>calcularSalarioNeto</i></b></p>
	 * <pre>public double calcularSalarioNeto (double totalRemuneraciones, double totalRetenciones)</pre>
	 * @param totalRemuneraciones Recibe el total de las remuneraciones.
	 * @param totalRetenciones Recibe el total de las retenciones.
	 * @return Retorna el salario neto en formato <code>double</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public double calcularSalarioNeto(double totalRemuneraciones, double totalRetenciones)
	{
		return totalRemuneraciones-totalRetenciones;
	}


	/**
	 * <p><b><i>imprimirRecibo</i></b></p>
	 * <pre>public StringBuilder imprimirRecibo ()</pre>
	 * @return Retorna un <code>Recibo</code> en formato <code>StringBuilder</code> con todos sus datos.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String imprimirRecibo()
	{		
		StringBuilder sb = new StringBuilder();
		sb.append("\n=====================================================\n");
		sb.append("\n\t\t   :: RECIBO ::\n\n");
		
		sb.append("\n-----------------------------------");
		sb.append("\nEMPLEADOR: \n");
		sb.append(empleador.mostrarDatos());
		
		sb.append("\n-----------------------------------");
		sb.append("\nEMPLEADO: \n");
		sb.append(empleado.toString());
		
		sb.append("\n\n-----------------------------------");
		sb.append("\nRetenciones: \n\nDNRP = $ " + String.format ("%.2f", jubilacion));
		sb.append("\nINSSJP Ley 19032 = $ " + String.format ("%.2f", ley));
		sb.append("\nObra Social " + empleado.getObraSocial() + " = $ " + String.format ("%.2f", obraSocial));
		sb.append("\nCuota Sindical = $ " + String.format ("%.2f", cuotaSindical));
		sb.append("\nTotal = $ " + String.format ("%.2f", totalRetenciones) + "\n");
		
		sb.append("\n\n-----------------------------------");
		sb.append("\nRemuneraciones:\n\nDestajo = $ " + String.format ("%.2f", destajo));
		sb.append("\nPresentismo = $ " + String.format ("%.2f", presentismo) );
		sb.append("\nAntiguedad = $ " + String.format ("%.2f", antiguedad) );
		sb.append("\nSAC = $ " + String.format ("%.2f", sac) );
		sb.append("\nVacaciones = $ " + String.format ("%.2f", vacaciones) ); 
		sb.append("\nTotal = $ " + String.format ("%.2f", totalRemuneraciones) + "\n" );
		
		sb.append("\n\n-----------------------------------");
		sb.append("\nNeto a Percibir: $ " + String.format ("%.2f", salarioNeto) + "\n");
		
		sb.append("\n\n-----------------------------------");
		sb.append("\nPeriodo Liquidado: " + periodo.getYear() + "-" + periodo.getMonthValue() );
		sb.append("\nFecha de Pago: " + fechaPago);
		
		sb.append("\n\n\n=====================================================\n\n");
		return sb.toString();
	}
	

	/**
	 * <p><b><i>calcularJubilacion</i></b></p>
	 * <pre>public double calcularJubilacion (double salarioBasico)</pre>
	 * @param salarioBasico Recibe el salario básico.
	 * @return Retorna el valor del aporte jubilatorio en formato <code>double</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public double calcularJubilacion(double salarioBasico)
	{
		return salarioBasico*11/100;
	}

	
	/**
	 * <p><b><i>calcularLey19032</i></b></p>
	 * <pre>public double calcularLey19032 (double salarioBasico)</pre>
	 * @param salarioBasico Recibe el salario básico.
	 * @return Retorna el valor del aporte establecido en la ley 19.032 en formato <code>double</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public double calcularLey19032(double salarioBasico)
	{
		return salarioBasico*3/100;
	}

	
	/**
	 * <p><b><i>calcularObraSocial</i></b></p>
	 * <pre>public double calcularObraSocial (double salarioBasico)</pre>
	 * @param salarioBasico Recibe el salario básico.
	 * @return Retorna el valor del aporte a la obra social en formato <code>double</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public double calcularObraSocial(double salarioBasico)
	{
		return salarioBasico*3/100;
	}
	
	
	/**
	 * <p><b><i>calcularCuotaSindical</i></b></p>
	 * <pre>public double calcularCuotaSindical (double salarioBasico)</pre>
	 * @param salarioBasico Recibe el salario básico.
	 * @return Retorna el valor de la cuota sindical en formato <code>double</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public double calcularCuotaSindical(double salarioBasico)
	{
		return salarioBasico*(double)2.5/100;
	}

	
	/**
	 * <p><b><i>calcularTotalRetenciones</i></b></p>
	 * <pre>public double calcularTotalRetenciones (double salarioBasico)</pre>
	 * @param salarioBasico Recibe el salario básico.
	 * @return Retorna el resultado del calculo de las retenciones en formato <code>double</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public double calcularTotalRetenciones(double salarioBasico)
	{
		jubilacion = calcularJubilacion(salarioBasico);
		ley = calcularLey19032(salarioBasico);
		obraSocial = calcularObraSocial(salarioBasico);
		cuotaSindical = calcularCuotaSindical(salarioBasico);
		
		return jubilacion+ley+obraSocial+cuotaSindical; 
	}

	
	/**
	 * <p><b><i>calcularDestajo</i></b></p>
	 * <pre>public double calcularDestajo (double salarioBasico, int diasTrabajados)</pre>
	 * @param salarioBasico Recibe el salario básico.
	 * @param diasTrabajados Recibe la cantidad de días trabajados por el empleado.
	 * @return Retorna el valor del destajo en formato <code>double</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public double calcularDestajo(double salarioBasico, int diasTrabajados)
	{
		return salarioBasico/30*diasTrabajados;
	}

	
	/**
	 * <p><b><i>calcularPresentismo</i></b></p>
	 * <pre>public double calcularPresentismo (double salarioBasico, double antiguedad)</pre>
	 * @param salarioBasico Recibe el salario básico.
	 * @param antiguedad Recibe el valor de la antiguedad del empleado.
	 * @return Retorna el valor del presentismo en formato <code>double</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public double calcularPresentismo(double salarioBasico, double antiguedad)
	{
		return (salarioBasico+antiguedad)*(float)8.33/100;
	}

	
	/**
	 * <p><b><i>calcularAntiguedad</i></b></p>
	 * <pre>public double calcularAntiguedad (double salarioBasico, LocalDate ingreso, LocalDate periodo)</pre>
	 * @param salarioBasico Recibe el salario básico.
	 * @param ingreso Recibe la fecha de ingreso del empleado.
	 * @param periodo Recibe el periodo liquidado.
	 * @return Retorna el valor de la antiguedad en formato <code>double</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public double calcularAntiguedad(double salarioBasico, LocalDate ingreso, LocalDate periodo)
	{
		int añosTrabajados = calcularAniosTrabajados(ingreso, periodo);
		
		return salarioBasico*añosTrabajados/100;
	}

	
	/**
	 * <p><b><i>calcularSAC</i></b></p>
	 * <pre>public double calcularSAC (double salarioBasico, int diasTrabajados, LocalDate ingreso, LocalDate periodo)</pre>
	 * @param salarioBasico Recibe el salario básico.
	 * @param diasTrabajados Recibe la cantidad de días trabajados por el empleado.
	 * @param ingreso Recibe la fecha de ingreso del empleado.
	 * @param periodo Recibe el periodo liquidado.
	 * @return Retorna el valor del SAC (aguinaldo) en formato <code>double</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public double calcularSAC(double salarioBasico, int diasTrabajados, LocalDate ingreso, LocalDate periodo)
	{
		int mesesTrabajados = calcularMesesTrabajados(ingreso, periodo);
		
		if (mesesTrabajados > 6) return salarioBasico/2;
		else return salarioBasico/365*diasTrabajados;
	}

	
	/**
	 * <p><b><i>calcularVacaciones</i></b></p>
	 * <pre>public double calcularVacaciones(double salarioBasico, int diasTrabajados, int diasVacaciones)</pre>
	 * @param salarioBasico Recibe el salario básico.
	 * @param diasTrabajados Recibe la cantidad de días trabajados por el empleado.
	 * @param diasVacaciones Recibe la cantidad de días de vacaciones que tuvo el empleado.
	 * @return Retorna el valor de las vacaciones en formato <code>double</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public double calcularVacaciones(double salarioBasico, int diasTrabajados, int diasVacaciones)
	{
		return salarioBasico/diasTrabajados*diasVacaciones;
	}

	
	/**
	 * <p><b><i>calcularTotalRemuneraciones</i></b></p>
	 * <pre>public double calcularTotalRemuneraciones(double salarioBasico, int diasTrabajados, int diasVacaciones, LocalDate ingreso, LocalDate periodo)</pre>
	 * @param salarioBasico Recibe el salario básico.
	 * @param diasTrabajados Recibe la cantidad de días trabajados por el empleado.
	 * @param diasVacaciones Recibe la cantidad de días de vacaciones que tuvo el empleado.
	 * @param ingreso Recibe la fecha de ingreso del empleado.
	 * @param periodo Recibe el periodo liquidado.
	 * @return Retorna el resultado del calculo de las remuneraciones en formato <code>double</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public double calcularTotalRemuneraciones(double salarioBasico, int diasTrabajados, int diasVacaciones, LocalDate ingreso, LocalDate periodo)
	{	
		destajo = calcularDestajo(salarioBasico, diasTrabajados);
		antiguedad = calcularAntiguedad(salarioBasico, ingreso, periodo);
		presentismo = calcularPresentismo(salarioBasico, antiguedad);
		sac = calcularSAC(salarioBasico, diasTrabajados, ingreso, periodo);
		vacaciones = calcularVacaciones(salarioBasico, diasTrabajados, diasVacaciones);
				
		return destajo+antiguedad+presentismo+sac+vacaciones;
	}
	
	
	/**
	 * <p><b><i>calcularDiasTrabajados</i></b></p>
	 * <pre>public int calcularDiasTrabajados(LocalDate fechaGuardada, LocalDate fechaIngresada)</pre>
	 * @param fechaGuardada Recibe la fecha de ingreso del empleado.
	 * @param fechaIngresada Recibe el periodo liquidado.
	 * @return Retorna la cantidad de días en actividad desde la fecha de ingreso del empleado hasta la fecha de liquidación del recibo en formato <code>int</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
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

	
	/**
	 * <p><b><i>calcularMesesTrabajados</i></b></p>
	 * <pre>public int calcularMesesTrabajados(LocalDate fechaGuardada, LocalDate fechaIngresada)</pre>
	 * @param fechaGuardada Recibe la fecha de ingreso del empleado.
	 * @param fechaIngresada Recibe el periodo liquidado.
	 * @return Retorna la cantidad de meses en actividad desde la fecha de ingreso del empleado hasta la fecha de liquidación del recibo en formato <code>int</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public int calcularMesesTrabajados(LocalDate fechaGuardada, LocalDate fechaIngresada)
	{
		int diasTrabajados = calcularDiasTrabajados(fechaGuardada, fechaIngresada);
		
		int meses = (int)diasTrabajados/30;
				
		return meses;
	}
	
	
	/**
	 * <p><b><i>calcularAniosTrabajados</i></b></p>
	 * <pre>public int calcularAniosTrabajados(LocalDate fechaGuardada, LocalDate fechaIngresada)</pre>
	 * @param fechaGuardada Recibe la fecha de ingreso del empleado.
	 * @param fechaIngresada Recibe el periodo liquidado.
	 * @return Retorna la cantidad de años en actividad desde la fecha de ingreso del empleado hasta la fecha de liquidación del recibo en formato <code>int</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public int calcularAniosTrabajados(LocalDate fechaGuardada, LocalDate fechaIngresada)
	{
		int diasTrabajados = calcularDiasTrabajados(fechaGuardada, fechaIngresada);
		
		int meses = (int)diasTrabajados/365;
				
		return meses;
	}
	

}
