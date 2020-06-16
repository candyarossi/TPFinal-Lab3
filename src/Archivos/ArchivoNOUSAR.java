package Archivos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import ClasesDePersonas.Empleado;
import ClasesDePersonas.Empleador;
import ClasesDePersonas.Persona;
import ListadosGenericos.Listado;






/**
 * <p><b><i>NO USAR</i></b></p>
 * <p><b><i>NO USAR</i></b></p>
 * 
 * <p><b><i>Archivo</i></b></p>
 * <pre>public class Archivo</pre>
 * <p>La clase <code>Archivo</code> contiene todos los métodos necesarios para guardar y leer los datos de los empleadores y empleados en sus correspondientes archivos. Sus métodos son de tipo estático.</p>
 * @author Yarossi, Candela & Trucco, Nahuel
 */
public class ArchivoNOUSAR {

	
	//TODO documentar esto.
	
	
	public static void guardar(Persona aux) 
	{
		try
        {
            FileOutputStream fileOutputStream = new FileOutputStream("personas.dat"); //personas.dat no va más
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    		   
            objectOutputStream.writeUTF(aux.getNombre());
			objectOutputStream.writeUTF(aux.getApellido());
			objectOutputStream.writeObject(aux.getCuil());
			objectOutputStream.writeObject(aux.getDNI());
			objectOutputStream.writeUTF(aux.getLugarNacimiento());
			objectOutputStream.writeUTF(aux.getNacionalidad());
			objectOutputStream.writeUTF(aux.getDireccion());
			objectOutputStream.writeUTF(aux.getLugarResidencia());
			objectOutputStream.writeUTF(aux.getTelefono());
			objectOutputStream.writeUTF(aux.getEmail());
			objectOutputStream.writeInt(aux.getNroLegajo());	
            
            	if(aux instanceof Empleador) 
    			{
            		Empleador empleador = (Empleador) aux;
            		objectOutputStream.writeUTF(empleador.getActividad());
            		objectOutputStream.writeInt(empleador.getCantidadEmpleados());

            		empleador.getEmpleados().guardarEnArchivo(); //TODO guardarEnArchivo()
    			}
            	else if (aux instanceof Empleado)
            	{
            		Empleado empleado = (Empleado) aux;
            		objectOutputStream.writeUTF(empleado.getCategoria());
            		objectOutputStream.writeUTF(empleado.getObraSocial());
            		objectOutputStream.writeObject(empleado.getFechaIngreso());
            	}
            
            objectOutputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	
	
	
	public static Persona leer()
	{
		Persona persona = null;
		
		try
        {
            FileInputStream fileInputStream = new FileInputStream("personas.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        
            persona = new Empleador();
            	
            persona.setNombre(objectInputStream.readUTF());
            persona.setApellido(objectInputStream.readUTF());
            persona.leerCuil((String)objectInputStream.readObject());
            persona.leerDni((String)objectInputStream.readObject());
            persona.setLugarNacimiento(objectInputStream.readUTF());
            persona.setNacionalidad(objectInputStream.readUTF());
            persona.setDireccion(objectInputStream.readUTF());
            persona.setLugarResidencia(objectInputStream.readUTF());
            persona.setTelefono(objectInputStream.readUTF());
            persona.setEmail(objectInputStream.readUTF());
            persona.leerNroLegajo(objectInputStream.readInt());
        //    persona.setActividad(objectInputStream.readUTF());
        //    persona.leerCantidadEmpleados(objectInputStream.readInt());

            	
            
            
            objectInputStream.close();
        }
		catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (EOFException ex)
        {
        	System.out.println("Fin del archivo");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
		
		return persona;
    }

}
