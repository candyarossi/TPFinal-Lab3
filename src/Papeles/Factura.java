package Papeles;

import ClasesDePersonas.Empleador;


public class Factura {

	private Empleador empleador; 
	private double costoPorRecibo;
	private int cantidadEmpleados;
	private double total;
	
	public Factura ()
	{
		empleador = new Empleador();
		costoPorRecibo = 0;
		cantidadEmpleados = 0;
		total = 0;
	}
	
	public Factura (Empleador empleador, double costo) 
	{
		this.empleador = empleador; 
		this.costoPorRecibo = costo;
		this.cantidadEmpleados = empleador.getCantidadEmpleados();
		this.total = costoPorRecibo*cantidadEmpleados;
	}
	
	public StringBuilder imprimirFactura () 
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\n-----------------------------------------------------\n");
		sb.append("FACTURA");
		sb.append("\n\nSr./Sra. " + empleador.getApellido() + " " + empleador.getNombre());
		sb.append("\n\nSe cobrara un total de $ " + String.format ("%.2f", total) 
				+ " \npor los gastos administrativos de " + cantidadEmpleados 
				+ " empleados\nsiendo el valor individual por cada recibo de $ " + String.format ("%.2f", costoPorRecibo));
		sb.append("\n-----------------------------------------------------\n\n");
		return sb;
	}
}
