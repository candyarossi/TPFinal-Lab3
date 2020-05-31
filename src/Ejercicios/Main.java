package Ejercicios;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.TimeZone;


public class Main {

	public static void main(String[] args) {
		// TODO ZONA DE PRUEBAS
		// Estaba probando el autoincremento del nro del legajo
		// Tambien las funciones para que cree el cuil y dni apartir rel cuil sin guinoes
		
		Scanner tecla = new Scanner(System.in);
		Persona nueva = new Persona();
		Persona nueva2 = new Persona();


		System.out.println("Ingrese un cuil sin guiones: ");
		nueva.setCuil(new StringBuilder(tecla.nextLine()));
	
		System.out.println("CUIL: " + nueva.getCuil());
		System.out.println("DNI: " + nueva.getDni());
		System.out.println("Nro Legajo: " + nueva.getNroLegajo());
		
		System.out.println("Ingrese otro cuil sin guiones: ");
		nueva2.setCuil(new StringBuilder(tecla.nextLine()));
	
		System.out.println("CUIL: " + nueva2.getCuil());
		System.out.println("DNI: " + nueva2.getDni());
		System.out.println("Nro Legajo: " + nueva2.getNroLegajo());
		
		tecla.close();
		
		System.out.println(nueva.toString());
		System.out.println(nueva2.toString());
		
		boolean esIgual = nueva.equals(nueva2);
		
		if(esIgual)
			System.out.println("Son iguales");
		else
			System.out.println("No son iguales");
		
		
	}
	
	
	
}

	
	
	
	