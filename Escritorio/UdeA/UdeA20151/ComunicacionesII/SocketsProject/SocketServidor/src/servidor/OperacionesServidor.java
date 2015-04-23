/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author julianesten
 */
public class OperacionesServidor {
    private final String rutaFichero= "C:\\Users\\julianesten\\Desktop\\Server\\";
    
    public void EliminarArchivo(String nombreArchivo){
        JOptionPane.showMessageDialog(null, "Entro a funcion eliminar!!!!");
        String ruta = this.rutaFichero+nombreArchivo;
        File fichero = new File(ruta);
        if(fichero.delete()){
            JOptionPane.showMessageDialog(null, "Archivo: "+nombreArchivo+" ha sido elimiando correctamente");
            //return true;
        }else{
            
            JOptionPane.showMessageDialog(null, "Archivo: "+nombreArchivo+" no existe en el servidor");
            //return false;
        }
    
    }
    /*
    Este metodo obtiene los ficheros almacenados en el servidor y los manda al lado del cliente para ser msotrados
    
    */
    public String[] obtenerFicheros(){
        File fichero = new File(this.rutaFichero);
        String[] ficheros = fichero.list();//Tenemos todos los archivos del fichero dado
        if(ficheros==null){
            System.out.println("No hay archivos en el servidor");
            return null;
        }else{
              return ficheros; 
            }
                
                
        }

    }
    

