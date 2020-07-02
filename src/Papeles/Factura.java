package Papeles;

import ClasesDePersonas.Empleador;


/**
 * <p><b><i>Factura</i></b></p>
 * <pre>public class Factura</pre>
 * <p>La clase <code>Factura</code> contiene todos los métodos necesarios para la impresión de una factura por pantalla.</p>
 * @author Yarossi, Candela & Trucco, Nahuel
 */
public class Factura {

	private Empleador empleador; 
	private double costoPorRecibo;
	private int cantidadEmpleados;
	private double total;
	
	
	/**
	 * <p><b><i>Factura</i></b></p>
	 * <pre>public Factura ()</pre>
	 * <p>Constructor de la clase <code>Factura</code>.</p>
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public Factura ()
	{
		empleador = new Empleador();
		costoPorRecibo = 0;
		cantidadEmpleados = 0;
		total = 0;
	}
	
	
	/**
	 * <p><b><i>Factura</i></b></p>
	 * <pre>public Factura (Empleador empleador, double costo)</pre>
	 * <p>Constructor de la clase <code>Factura</code>.</p>
	 * @param empleador Recibe el empleador al cual se le generará la factura.
	 * @param costo Recibe el costo unitario de cada recibo hecho.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public Factura (Empleador empleador, double costo) 
	{
		this.empleador = empleador; 
		this.costoPorRecibo = costo;
		this.cantidadEmpleados = empleador.getCantidadEmpleados();
		this.total = costoPorRecibo*cantidadEmpleados;
	}
	
	
	/**
	 * <p><b><i>imprimirFactura</i></b></p>
	 * <pre>public StringBuilder imprimirFactura ()</pre>
	 * @return Retorna una <code>Factura</code> en formato <code>StringBuilder</code> con todos sus datos.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public StringBuilder imprimirFactura () 
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\n=====================================================\n");
		sb.append("\n\t\t   :: FACTURA ::\n\n");
		
		sb.append("\n\n  Sr./Sra. " + empleador.getApellido() + " " + empleador.getNombre());
		
		sb.append("\n\nSe cobrara un total de $ " + String.format ("%.2f", total) + ","); 
		sb.append(" \npor los gastos administrativos de " + cantidadEmpleados );
		
		sb.append(" empleados:\n\n" + empleador.verEmpleados() + "\n\n" );
		
		sb.append("Siendo el valor individual por cada recibo: $ " + String.format ("%.2f", costoPorRecibo));
		sb.append("\n=====================================================\n");
		
		return sb;
	}
}
