package appData;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// TODO documentar
public class DatosDelSistema
{
	public static int cantidadLegajos;
	
	public DatosDelSistema()
	{
		cantidadLegajos = DatosDelSistema.leerDatos("datos.dat");
	}
	
	
	public int getCantLegajos()
	{
		return cantidadLegajos;
	}
	
	public static void setCantLegajo(int cantidadLegajos)
	{
		DatosDelSistema.cantidadLegajos = cantidadLegajos;
	}

	
	/**
	 *  <p><b><i>guardarDatos</i></b></p>
	 * <pre>public static void guardarDatos (DatosDelSistema datos, String archivo)</pre>
	 * @param datos Recibe los datos a guardar en el archivo.
	 * @param archivo Recibe el nombre del archivo donde se va a guardar los datos.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public static void guardarDatos()
	{
		String archivo = "datos.dat";
		File file = new File(archivo);
		
		try
        {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
                       
        	oos.writeInt(DatosDelSistema.cantidadLegajos);
  
            oos.close();
         
        }	
		catch (FileNotFoundException e)
        {
            System.out.println("Archivo inexistente.----------1");
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
	 *  <p><b><i>leerDatos</i></b></p>
	 * <pre>public static DatosDelSistema leerDatos (String archivo)</pre>
	 * @param archivo Recibe el nombre del archivo que se debe leer.
	 * @return Retorna el dato leido del archivo.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public static int leerDatos(String archivo)
	{
		int dato = 0;
		
		try
        {
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
                  	
            dato = (int) ois.readInt();
                      
            ois.close();
           
        }
		catch (FileNotFoundException e)
        {
			DatosDelSistema.set0();
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
		
		return dato;
    }
	
	// TODO documentar
	public static void set0()
	{
		String archivo = "datos.dat";
		File file = new File(archivo);
		
		try
        {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
                       
        	oos.writeInt(0);
  
            oos.close();
         
        }	
		catch (FileNotFoundException e)
        {
            System.out.println("Archivo inexistente.");
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
}
