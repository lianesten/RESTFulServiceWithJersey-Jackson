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
    
    public boolean EliminarArchivo(String nombreArchivo){
        String ruta = this.rutaFichero+nombreArchivo;
        File fichero = new File(ruta);
        if(fichero.delete()){
            return true;
        }else{
            return false;
        }
    
    }
    /*
    Este metodo obtiene los ficheros almacenados en el servidor y los manda al lado del cliente para ser msotrados
    
    */
    public String listarArchivos(){
        File fichero = new File(this.rutaFichero);
        String[] ficheros = fichero.list();//Tenemos todos los archivos del fichero dado
        String resultado = "";
        if(ficheros==null){
            resultado = "No hay archivos en el servidor";
            return resultado;
        }else{
            for (String fichero1 : ficheros) {
                resultado = resultado +"\n" + fichero1;
            }
              return resultado; 
            }
                
                
        }

    }
    

