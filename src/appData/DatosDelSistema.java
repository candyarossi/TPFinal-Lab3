package appData;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <p><b><i>DatosDelSistema</i></b></p>
 * <pre>public class DatosDelSistema</pre>
 * <p>La clase <code>DatosDelSistema</code> maneja datos del sistema, como la asignación de datos de legajo</p>
 * @author Yarossi, Candela & Trucco, Nahuel
 */
public class DatosDelSistema
{
	public static final String archivoSistema = "datos.dat";
	public static int cantidadLegajos;
	
	
	public DatosDelSistema()
	{
		cantidadLegajos = DatosDelSistema.leerDatos();
	}
	
	
	public int getCantLegajos()
	{
		return cantidadLegajos;
	}
	
	public static void setCantLegajos(int cantidadLegajos)
	{
		DatosDelSistema.cantidadLegajos = cantidadLegajos;
	}

	
	/**
	 *  <p><b><i>guardarDatos</i></b></p>
	 * <pre>public static void guardarDatos ()</pre>
	 * <p>Guarda en el archvivo los datos de la clase</p>
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public static void guardarDatos()
	{
		File file = new File(archivoSistema);
		
		try
        {
            FileOutputStream fos = new FileOutputStream(archivoSistema);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
                       
        	oos.writeInt(DatosDelSistema.cantidadLegajos);
  
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
	
	
	
	/**
	 *  <p><b><i>leerDatos</i></b></p>
	 * <pre>public static int leerDatos (String archivo)</pre>
	 * @param archivo Recibe el nombre del archivo que se debe leer.
	 * @return Retorna el dato leido del archivo.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public static int leerDatos()
	{
		int dato = 0;
		
		try
        {
            FileInputStream fis = new FileInputStream(archivoSistema);
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
	
	/**
	 *  <p><b><i>set0</i></b></p>
	 * <pre>public static void set0 ()</pre>
	 * <p>Crea el archivo de <code>DatosDelSistema</code> e inicializa sus datos.</p>
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public static void set0()
	{
		File file = new File(archivoSistema);
		
		try
        {
            FileOutputStream fos = new FileOutputStream(archivoSistema);
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
