package Archivos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ClasesDePersonas.Persona;


public class GestorDeArchivos
{
	
	//TODO documentar.
	
	public static void guardar(Persona aux, String archivo)
	{
		try
        {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
    		  
            System.out.println(aux);
            oos.writeObject(aux);
            
            oos.close();
        }	
		catch (FileNotFoundException e)
        {
            System.out.println("Archivo inexistente.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
	
	
	
	public static Persona leer(String archivo)
	{
		Persona persona = null;
		
		try
        {
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
       
            persona = (Persona)ois.readObject();
   
            ois.close();
        }
		catch (FileNotFoundException e)
        {
			System.out.println("Archivo inexistente.");
        }
        catch (EOFException e)
        {
        	System.out.println("Fin del archivo.");
        }
        catch (IOException e)
        {
        	e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
		catch (Exception e)
        {
			e.printStackTrace();
        }
		
		return persona;
    }

}
