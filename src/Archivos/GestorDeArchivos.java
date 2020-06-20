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
import java.util.HashMap;
import java.util.Set;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

import ClasesDePersonas.Persona;
import ListadosGenericos.Listado;


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
	public static void guardar(Persona persona, String archivo)
	{
		File file = new File(archivo);
		boolean append = file.exists();
		
		try
        {
            FileOutputStream fos = new FileOutputStream(archivo);
            AppendableObjectOutputStream aoos = new AppendableObjectOutputStream(fos, append);
            
            aoos.writeObject(persona);
           
            aoos.close();
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
	public static Listado<Integer, Persona> leer(String archivo)
	{
		Listado<Integer, Persona> listado = new Listado<Integer, Persona>();
		Object obj;
		
		try
        {
            FileInputStream fis = new FileInputStream(archivo);
            System.out.println("----------------" + archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            obj = ois.readObject();
            
            while ( obj != null )
            {
            	Persona persona = (Persona)obj;
            	listado.agregar(persona.nroLegajo, persona);
            }
            /*
            while ( (persona = (Persona)ois.readObject()) != null )
            {
            	listado.agregar(persona.nroLegajo, persona);
            }
            */
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
		
		return listado;
    }
	
	
	
	
	
	
	

}
