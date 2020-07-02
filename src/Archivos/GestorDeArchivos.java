package Archivos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import ClasesDePersonas.Empleador;


/**
 * <p><b><i>GestorDeArchivos</i></b></p>
 * <pre>public class GestorDeArchivos</pre>
 * <p>La clase <code>GestorDeArchivos</code> contiene todos los métodos para leer y escribir archivos binarios.</p>
 * @author Yarossi, Candela & Trucco, Nahuel
 */
public class GestorDeArchivos
{
	
	/**
	 *  <p><b><i>guardarEmpleador</i></b></p>
	 * <pre>public static void guardarEmpleador (Empleador empleador, String archivo)</pre>
	 * @param empleador Recibe al empleador a guardar en el archivo.
	 * @param archivo Recibe el nombre del archivo donde se va a guardar el empleador.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public static void guardarEmpleador(Empleador empleador, String archivo)
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
            System.out.println("Archivo inexistente. de guardar empleador");
        }
        catch (IOException e)
        {
        	e.getMessage();
        }
        catch (Exception e)
        {
        	e.getMessage();
        }
		
	}
	
	
	/**
	 *  <p><b><i>leerEmpleador</i></b></p>
	 * <pre>public static Empleador leerEmpleador (String archivo)</pre>
	 * @param archivo Recibe el nombre del archivo que se debe leer.
	 * @return Retorna el empleador leido del archivo.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
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
			// TODO acomodat print
			System.out.println("Archivo inexistente. de leer empleador");
        }
        catch (EOFException e)
        {
        	System.out.println("Archivo leido.");
        }
        catch (IOException e)
        {
        	e.getMessage();
        }
        catch (Exception e)
        {
        	e.getMessage();
        }
		
		return empleador;
    }
	
	
	/**
	 *  <p><b><i>guardarCuils</i></b></p>
	 * <pre>public static void guardarCuils (ArrayList<String> array)</pre>
	 * @param array Recibe el array con los nombres de los archivos de los empleadores.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
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
			// TODO acomodat print
            System.out.println("Archivo inexistente. ggggggggggggggggggggggggggggg");
        }
        catch (IOException e)
        {
        	e.getMessage();
        }
        catch (Exception e)
        {
        	e.getMessage();
        }
		
	}
	
	
	/**
	 *  <p><b><i>leerCuils</i></b></p>
	 * <pre>public static ArrayList<String> leerCuils ()</pre>
	 * @return Retorna el array con los nombres de los archivos de los empleadores.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
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
			// TODO acomodat print
			System.out.println("Archivo inexistente. llllllllllllllllllllllll1");
        }
        catch (EOFException e)
        {
        	System.out.println("");
        }
        catch (IOException e)
        {
        	e.getMessage();
        }
        catch (Exception e)
        {
			e.getMessage();
        }
		
		return array;
    }
	

}
