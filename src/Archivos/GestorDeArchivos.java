package Archivos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ClasesDePersonas.Empleado;
import ClasesDePersonas.Empleador;
import ClasesDePersonas.Persona;

public class GestorDeArchivos
{
	// TODO todo. Badump tss.
	
	// ANOTACIONES por si lees esto:
	
	//Necesito manejar dos tipos de arvhivos: uno de empleadores y otro de empleados
	//Algo útil: http://chuwiki.chuidiang.org/index.php?title=Lectura_y_Escritura_de_Ficheros_en_Java
	
	
	public static void guardar(Persona aux, String archivo) 
	{
		try
        {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
    		   
            oos.writeUTF(aux.getNombre());
            oos.writeUTF(aux.getApellido());
            oos.writeObject(aux.getCuil());
            oos.writeObject(aux.getDNI());
            oos.writeUTF(aux.getLugarNacimiento());
            oos.writeUTF(aux.getNacionalidad());
            oos.writeUTF(aux.getDireccion());
            oos.writeUTF(aux.getLugarResidencia());
            oos.writeUTF(aux.getTelefono());
            oos.writeUTF(aux.getEmail());
            oos.writeInt(aux.getNroLegajo());	
            
            if(aux instanceof Empleador) 
    		{
           		Empleador empleador = (Empleador) aux;
           		oos.writeUTF(empleador.getActividad());
           		oos.writeInt(empleador.getCantidadEmpleados());
           		
           		//TODO guardarEnArchivo()
           		// empleador.getEmpleados().guardarEnArchivo(); 
    		}
           	else if (aux instanceof Empleado)
           	{
           		Empleado empleado = (Empleado) aux;
           		oos.writeUTF(empleado.getCategoria());
           		oos.writeUTF(empleado.getObraSocial());
           		oos.writeObject(empleado.getFechaIngreso());
           	}
            
            oos.close();
        }	
		catch (FileNotFoundException e)
        {
			//TODO tratamiento catch
            e.printStackTrace();
        }
        catch (EOFException e)
        {
        	//TODO tratamiento catch
        	System.out.println("Fin del archivo");
        }
        catch (IOException e)
        {
        	//TODO tratamiento catch
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
        	//TODO tratamiento catch
            e.printStackTrace();
        }
		catch (Exception e)
        {
        	//TODO tratamiento catch
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
        
            persona = new Empleador();
            	
            persona.setNombre(ois.readUTF());
            persona.setApellido(ois.readUTF());
            persona.leerCuil((String)ois.readObject());
            persona.leerDni((String)ois.readObject());
            persona.setLugarNacimiento(ois.readUTF());
            persona.setNacionalidad(ois.readUTF());
            persona.setDireccion(ois.readUTF());
            persona.setLugarResidencia(ois.readUTF());
            persona.setTelefono(ois.readUTF());
            persona.setEmail(ois.readUTF());
            persona.leerNroLegajo(ois.readInt());
        //    persona.setActividad(objectInputStream.readUTF());
        //    persona.leerCantidadEmpleados(objectInputStream.readInt());

            	
            
            
            ois.close();
        }
		catch (FileNotFoundException e)
        {
			//TODO tratamiento catch
            e.printStackTrace();
        }
        catch (EOFException e)
        {
        	//TODO tratamiento catch
        	System.out.println("Fin del archivo");
        }
        catch (IOException e)
        {
        	//TODO tratamiento catch
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
        	//TODO tratamiento catch
            e.printStackTrace();
        }
		catch (Exception e)
        {
        	//TODO tratamiento catch
            e.printStackTrace();
        }
		
		return persona;
    }
	

}
