package Ejercicios;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner tecla = new Scanner(System.in);
		Persona nueva = new Empleador();
		

		System.out.println("Ingrese el nombre de la persona: ");
		nueva.setNombres(tecla.nextLine());
		System.out.println("Ingrese el apellido de la persona: ");
		nueva.setApellidos(tecla.nextLine());
		System.out.println("Ingrese el dni de la persona: ");
		nueva.setCuil(tecla.nextLine());
		System.out.println("Ingrese el mail de la persona: ");
		nueva.setEmail(tecla.nextLine());
		System.out.println("Ingrese el telefono de la persona: ");
		nueva.setTelefono(tecla.nextLine());
	
		System.out.println(nueva.toString());
		
		tecla.close();
		
	}

}
