package cliente;

import java.io.*;

import java.net.*;
import javax.swing.JOptionPane;

public class OperacionesCliente {

    private final InetAddress direccion;
    private final Socket socket;

    public OperacionesCliente(String ip) throws UnknownHostException, IOException {
        this.direccion = InetAddress.getByName(ip);
        this.socket = new Socket(direccion, 530);
        // socket.setSoTimeout( 2000 );
        socket.setKeepAlive(true);
    }

    public void enviarArchivo(String nombreArchivo) {
        try {

            // Creamos la direccion IP de la maquina que recibira el archivo
            //     InetAddress direccion = InetAddress.getByName("192.168.0.20");
            // Creamos el Socket con la direccion y elpuerto de comunicacion
            //   Socket socket = new Socket(direccion, 530);
            socket.setSoTimeout(2000);
           // socket.setKeepAlive(true);

            // Creamos el archivo que vamos a enviar
            File archivo = new File(nombreArchivo);

            // Obtenemos el tamaño del archivo
            int tamañoArchivo = (int) archivo.length();

            // Creamos el flujo de salida, este tipo de flujo nos permite 
            // hacer la escritura de diferentes tipos de datos tales como
            // Strings, boolean, caracteres y la familia de enteros, etc.
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            System.out.println("Enviando Archivo: " + archivo.getName());

            // Enviamos el nombre del archivo 
            dos.writeUTF("almacenar");
            dos.writeUTF(archivo.getName());
            /* long a = 1234;
             JOptionPane.showMessageDialog(null, "caracter:"+a);
             dos.writeLong(a);*/
            // Enviamos el tamaño del archivo
            dos.writeInt(tamañoArchivo);
           // JOptionPane.showMessageDialog(null, "caracter:" + dos.size());
            // Creamos flujo de entrada para realizar la lectura del archivo en bytes
            FileInputStream fis = new FileInputStream(nombreArchivo);
            BufferedInputStream bis = new BufferedInputStream(fis);

            // Creamos el flujo de salida para enviar los datos del archivo en bytes
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

            // Creamos un array de tipo byte con el tamaño del archivo 
            byte[] buffer = new byte[tamañoArchivo];

            // Leemos el archivo y lo introducimos en el array de bytes 
            bis.read(buffer);

            // Realizamos el envio de los bytes que conforman el archivo
            for (int i = 0; i < buffer.length; i++) {
                bos.write(buffer[i]);
            }

            JOptionPane.showMessageDialog(null, "Archivo subido correctamente al servidor: " + archivo.getName());
            // Cerramos socket y flujos
            bis.close();
            bos.close();
            dos.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Archivo enviado");
        }

    }

    /*
     Este metodo me permite eliminar archivos almacenados previamente en el servidor dado el nombre del archivo.
     Se utiliza flag = false para diferencia la operacion eliminar.
     */
    public void eliminarArchivo(String nombreArchivo) {
        boolean resultado;
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("eliminar");
            dos.writeUTF(nombreArchivo);
            dos.flush();
            Thread.sleep(2000);
            DataInputStream is = new DataInputStream(socket.getInputStream());
            resultado=is.readBoolean();
            if(resultado){
                JOptionPane.showMessageDialog(null, "Archivo: "+nombreArchivo+" ha sido elimiando correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "Archivo: "+nombreArchivo+" no existe en el servidor");
            }
            
            //DataInputStream istream = new DataInputStream(socket.getInputStream());
            //socket.close();

        } catch (Exception e) {
            System.err.println("excepcion: " + e.toString());
            e.printStackTrace();
        }
    }

    /*
     *Este metodo recibe un Array tipo String donde cada elemento corresponde a el nombre de un archivo almacenado en el servidor.
     */
    public void listarArchivos() {
        String lista;
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("listar");
            dos.flush();

            DataInputStream is = new DataInputStream(socket.getInputStream());
            lista = is.readUTF();
            JOptionPane.showMessageDialog(null, "Archivo: " + lista);
            socket.close();

        } catch (Exception e) {
            System.err.println("excepcion: " + e.toString());
            e.printStackTrace();
        }
    }
}
