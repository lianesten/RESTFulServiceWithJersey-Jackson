/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Esteban Montoya
 */
public class Servidor {

    boolean eliminado;

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = null;
        JOptionPane.showMessageDialog(null, "El Servicio ha sido iniciado correctamente addFileDIO", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        Servidor p = new Servidor();
        servidor = new ServerSocket(530);//inicializamos el socket con el puerto 530

        p.iniciarServidor(servidor);
    }

    public Servidor() throws IOException {
        //  System.out.println("Esperando recepcion de archivos...");
    }

    public void iniciarServidor(ServerSocket servidor) {
        //boolean operacion, resultado;
        while (true) {
            try {
                // Creamos el socket que atendera el servidor
                Socket cliente = servidor.accept();

                // Creamos flujo de entrada para leer los datos que envia el cliente 
                DataInputStream dis = new DataInputStream(cliente.getInputStream());
                String operacion = dis.readUTF().toString();
                JOptionPane.showMessageDialog(null, "operacion: " + operacion);

                if (operacion.equals("almacenar")) {//True, Almacenar
                    JOptionPane.showMessageDialog(null, "Ingreso a almacenar");
                    String nombreArchivo = dis.readUTF().toString();

                    int tam = dis.readInt();

                    FileOutputStream fos = new FileOutputStream("C:\\Users\\julianesten\\Desktop\\Server\\" + nombreArchivo);
                    BufferedOutputStream out = new BufferedOutputStream(fos);
                    BufferedInputStream in = new BufferedInputStream(cliente.getInputStream());
                    // Creamos el array de bytes para leer los datos del archivo
                    byte[] buffer = new byte[tam];
                    // Obtenemos el archivo mediante la lectura de bytes enviados
                    for (int i = 0; i < buffer.length; i++) {
                        buffer[i] = (byte) in.read();
                    }
                    //Escribimos el archivo
                    out.write(buffer);
                    //Cerramos los flujos
                    out.flush();
                    in.close();
                    out.close();

                    //System.out.println("Archivo recivido " + nombreArchivo);                
                } else if (operacion.equals("eliminar")) {//False, Eliminar
                    JOptionPane.showMessageDialog(null, "Eliminar archivo");
                    String archivoEliminar = dis.readUTF();
                    JOptionPane.showMessageDialog(null, "Nombre archivo eliminar: " + archivoEliminar);
                    OperacionesServidor obj = new OperacionesServidor();
                    obj.EliminarArchivo(archivoEliminar);
                    JOptionPane.showMessageDialog(null, "Despues de funcion eliminar");
                    //Thread.sleep(2000);
                    //JOptionPane.showMessageDialog(null, "Resultado a devolver: " + operacion);
                    //DataOutputStream ostream = new DataOutputStream(sc.getOutputStream());
                    //ostream.writeBoolean(operacion);
                    //ostream.flush();

                }
                dis.close();
                cliente.close();
            } catch (Exception e) {
                System.out.println("Recibir " + e.toString());
            }

            /*try {
             // Creamos el socket que atendera el servidor
             Socket cliente = servidor.accept();
             // Creamos flujo de entrada para leer los datos que envia el cliente
             InputStream istream = cliente.getInputStream();
             ObjectInput in = new ObjectInputStream(istream);
             operacion = in.readBoolean();
             JOptionPane.showMessageDialog(null, "Operacion a realizar:" + operacion + "\n TRUE: almacenar, FALSE: Eliminar");
             //  if (operacion) {//Almacenar

             JOptionPane.showMessageDialog(null, "Almacenar");
             String nombreArchivo = in.readUTF();
             JOptionPane.showMessageDialog(null, "NombreArchivo Almacenar:" + nombreArchivo);
             int tam = in.readInt();
             JOptionPane.showMessageDialog(null, "size archivo almancenar: " + tam);
             FileOutputStream fos = new FileOutputStream("C:\\Users\\julianesten\\Desktop\\Server\\" + nombreArchivo);
             BufferedOutputStream out = new BufferedOutputStream(fos);
             BufferedInputStream bin = new BufferedInputStream(cliente.getInputStream());
             // Creamos el array de bytes para leer los datos del archivo
             byte[] buffer = new byte[tam];
             // Obtenemos el archivo mediante la lectura de bytes enviados
             for (int i = 0; i < buffer.length; i++) {
             buffer[i] = (byte) bin.read();
             }
             //Escribimos el archivo
             out.write(buffer);
             //Cerramos los flujos
             out.flush();
             bin.close();
             out.close();

             //} else {//Eliminar

             /* JOptionPane.showMessageDialog(null, "Eliminar archivo");
             String nombreArchivo = (String) in.readObject();
             JOptionPane.showMessageDialog(null, "Nombre archivo: " + nombreArchivo);
             OperacionesServidor obj = new OperacionesServidor();
             resultado = obj.EliminarArchivo(nombreArchivo);
             JOptionPane.showMessageDialog(null, "Despues de funcion eliminar");
             //Thread.sleep(2000);
             JOptionPane.showMessageDialog(null, "Resultado a devolver: " + resultado);
             DataOutputStream ostream = new DataOutputStream(cliente.getOutputStream());
             ostream.writeBoolean(operacion);
             ostream.flush();

             //}

             cliente.close();
             //System.out.println("Archivo recivido " + nombreArchivo);
             } catch (Exception e) {
             System.out.println("Recibir " + e.toString());
             }*/
        }

        /*while(true)
         {
         int operacion=0;
         try {
         // Creamos el socket que atendera el servidor
         Socket cliente = servidor.accept();
         //Creamos flujo de salida de datos
         //ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
                
         // Creamos flujo de entrada para leer los datos que envia el cliente 
         DataInputStream dis = new DataInputStream(cliente.getInputStream());
         operacion = (int) dis.readInt();
         JOptionPane.showMessageDialog(null, "operacion: "+operacion);
         if(operacion==5){//True, Borrar archivo
         JOptionPane.showMessageDialog(null, "listar archivo");
         OperacionesServidor obj = new OperacionesServidor();
         String[] lista = obj.obtenerFicheros();
                    
         }else{//False, operacion listar archivos
         InputStream istream = cliente.getInputStream();
         ObjectInput in = new ObjectInputStream(istream);
         JOptionPane.showMessageDialog(null, "Eliminar archivo");
         String nombreArchivo = (String) in.readObject();
         JOptionPane.showMessageDialog(null, "Nombre archivo: "+nombreArchivo);
         OperacionesServidor obj = new OperacionesServidor();
         obj.EliminarArchivo(nombreArchivo);
                    

                    
         }//Opcion almacenar archivo
         JOptionPane.showMessageDialog(null, "Almacenar archivo");
                
         int tam = dis.readInt();
         // Obtenemos el nombre del archivo
         String nombreArchivo = dis.readUTF().toString();

         System.out.println("Recibiendo Archivo "+nombreArchivo);
         // Creamos flujo de salida, este flujo nos sirve para 
         // indicar donde guardaremos el archivo
         //FileOutpuFileOutputStream fos = new FileOutputStream("C:\\Users\\julianesten\\Desktop\\Server\\"+nombreArchivo);
         FileOutputStream fos = new FileOutputStream("C:\\Users\\julianesten\\Desktop\\Server\\"+nombreArchivo);
         BufferedOutputStream out = new BufferedOutputStream(fos);
         BufferedInputStream in = new BufferedInputStream(cliente.getInputStream());
         // Creamos el array de bytes para leer los datos del archivo
         byte[] buffer = new byte[tam];
         // Obtenemos el archivo mediante la lectura de bytes enviados
         for(int i=0;i<buffer.length;i++)
         {
         buffer[i] = (byte)in.read();
         }
         //Escribimos el archivo
         out.write(buffer);
         //Cerramos los flujos
         out.flush();
         in.close();
         out.close();
         cliente.close();
         System.out.println("Archivo recivido "+nombreArchivo);
         Thread.sleep(2000);
         } catch (Exception e) {
         System.out.println("Recibir "+e.toString());
         }
         }*/
    }
}
