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
        JOptionPane.showMessageDialog(null, "El Servicio ha sido iniciado correctamente!!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        Servidor p = new Servidor();
        servidor = new ServerSocket(530);//inicializamos el socket con el puerto 530

        p.iniciarServidor(servidor);
    }

    public Servidor() throws IOException {
        //  System.out.println("Esperando recepcion de archivos...");
    }

    public void iniciarServidor(ServerSocket servidor) {
        while (true) {
            try {
                // Creamos el socket que atendera el servidor
                Socket cliente = servidor.accept();

                // Creamos flujo de entrada para leer los datos que envia el cliente 
                DataInputStream dis = new DataInputStream(cliente.getInputStream());
                OperacionesServidor obj = new OperacionesServidor();
                String operacion = dis.readUTF().toString();
              //  JOptionPane.showMessageDialog(null, "operacion: " + operacion);

                if (operacion.equals("almacenar")) {//True, Almacenar
                  //  JOptionPane.showMessageDialog(null, "Ingreso a almacenar");
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
                   // JOptionPane.showMessageDialog(null, "Eliminar archivo");
                    String archivoEliminar = dis.readUTF();
                    //JOptionPane.showMessageDialog(null, "Nombre archivo eliminar: " + archivoEliminar);
                   boolean result = obj.EliminarArchivo(archivoEliminar);
                   DataOutputStream os = new DataOutputStream(cliente.getOutputStream());
                   os.writeBoolean(result);
                   
                    //JOptionPane.showMessageDialog(null, "Despues de funcion eliminar");
                }else if(operacion.equals("listar")){
                    String lista = obj.listarArchivos();
                    //JOptionPane.showMessageDialog(null, lista);
                    DataOutputStream os = new DataOutputStream(cliente.getOutputStream());
                    os.writeUTF(lista);
                }
                dis.close();
                cliente.close();
            } catch (Exception e) {
                System.out.println("Recibir " + e.toString());
            }

        }
    }
}
