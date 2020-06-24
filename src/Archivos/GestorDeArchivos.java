package Archivos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import ClasesDePersonas.Empleador;
import ClasesDePersonas.Persona;
import ListadosGenericos.Listado;


// TODO doc
public class GestorDeArchivos
{
	
	/**
	 *  <p><b><i></i></b></p>
	 * <pre>public static void guardar(Persona aux, String archivo)</pre>
	 * <p>Esta función recibe un empleador y lo guarda en el archivo que también recive por parametro.</p>
	 * @param persona 
	 * @param archivo
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public static void guardarEmpleado(Empleador empleador, String archivo)
	{
		File file = new File(archivo);
		
		try
        {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
                       
        	oos.writeObject(empleador);
  
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
	
	

	// TODO Documentar método
	// TODO leer
	public static Empleador leerEmpleador(String archivo)
	{
		Empleador empleador = null;
		
		try
        {
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
                  	
            empleador = (Empleador) ois.readObject();
          
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
        catch (Exception e)
        {
			e.printStackTrace();
        }
		
		
		return empleador;
    }
	
	
	//TODO DOC
	public static void guardarCuils(ArrayList<String> array)
	{
		File file = new File("cuils.dat");
		
		try
        {
            FileOutputStream fos = new FileOutputStream("cuils.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
                       
            for (String str : array)
            {
            	oos.writeUTF(str);
            }
            
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
	
	

	// TODO Documentar método
	// TODO leer
	public static ArrayList<String> leerCuils()
	{
		ArrayList<String> array = new ArrayList<String>();
		String str;
        boolean flag = true;

		
		try
        {
            FileInputStream fis = new FileInputStream("cuils.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            while (flag)
            {
            	str = ois.readUTF();
            	array.add(str);
            }
            
            ois.close();

           
        }
		catch (FileNotFoundException e)
        {
			System.out.println("Archivo inexistente.");
        }
        catch (EOFException e)
        {
        	//System.out.println("Fin del archivo de Cuils.");
        }
        catch (IOException e)
        {
        	e.printStackTrace();
        }
        catch (Exception e)
        {
			e.printStackTrace();
        }
		
		
		return array;
    }
	
	
	

}
