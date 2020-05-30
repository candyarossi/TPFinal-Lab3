package Ejercicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;


public class Main {

	public static void main(String[] args) {
		// TODO ZONA DE PRUEBAS
		
		Scanner tecla = new Scanner(System.in);
		/*Persona nueva = new Persona();
		Persona nueva2 = new Persona();


		System.out.println("Ingrese el cuil sin guiones: ");
		nueva.setCuil(new StringBuilder(tecla.nextLine()));
	
		System.out.println(nueva.getCuil());
		System.out.println(nueva.getDni());
		
		System.out.println("Ingrese el cuil sin guiones: ");
		nueva2.setCuil(new StringBuilder(tecla.nextLine()));
	
		System.out.println(nueva2.getCuil());
		System.out.println(nueva2.getDni());
		
		tecla.close();
		
		System.out.println(nueva.toString());
		System.out.println(nueva2.toString());
		
		boolean esIgual = nueva.equals(nueva2);
		
		System.out.println(esIgual);*/
		
		String diaString = new String();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		Date dia1 = new Date();
		Date dia2 = new Date();
		
		System.out.println("Ingrese una fecha: ");
		diaString = tecla.nextLine();
		dia1 = (Date)diaString;
		
		
		int dias = calcularDiasTrabajadosDesdeInicioDeActividad(dia1, "2020-05-30");
		
		System.out.println(dias);
		
		
	}
	
	public int calcularDiasTrabajadosDesdeInicioDeActividad(Date dia1, Date dia2) throws ParseException {
		
		//TODO 
		
		int dias = (int)((dia2.getTime()-dia1.getTime())/86400000);
		
		return dias;
	}

}
