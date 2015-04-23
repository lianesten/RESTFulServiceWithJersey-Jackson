/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Esteban Montoya
 */
public class Archivo extends javax.swing.JFrame {
    JFileChooser dlg;
    /**
     * Creates new form Archivo
     */
    public Archivo() {
        initComponents();
        ip = JOptionPane.showInputDialog("Digite direccion IP del servidor\n ejemplo: 192.168.0.21");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        examinarBtn = new javax.swing.JButton();
        ruta = new javax.swing.JLabel();
        subirBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Archivo a Enviar");

        examinarBtn.setText("Examinar");
        examinarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinarBtnActionPerformed(evt);
            }
        });

        subirBtn.setText("Subir Archivo");
        subirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione archivos que no superen los 90 MB");

        jLabel1.setText(":::Administrador de archivos:::");

        jButton1.setText("Eliminar Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Listar Archivos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(subirBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 114, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(examinarBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(ruta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(examinarBtn)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subirBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void examinarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinarBtnActionPerformed
        // TODO add your handling code here:
        dlg = new JFileChooser();
        int opcion = dlg.showOpenDialog(this);
        if(opcion==JFileChooser.APPROVE_OPTION)
        {
            String file = dlg.getSelectedFile().getPath();
            ruta.setText(file);       
//            lblSalida.setText(file);
//            ImageIcon icon = new ImageIcon(file);            
//            Image img = icon.getImage();            
//            Image newImg = img.getScaledInstance(190, 164, java.awt.Image.SCALE_SMOOTH);            
//            ImageIcon newIcon = new ImageIcon(newImg);
//            lblImagen.setIcon(newIcon);
        }
        if(opcion==JFileChooser.CANCEL_OPTION)
        {
            JOptionPane.showMessageDialog(this, "Accion cancelada por el usuario");
        }
    }//GEN-LAST:event_examinarBtnActionPerformed

    private void subirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirBtnActionPerformed
        // TODO add your handling code here:
        //CorregirRuta corregir = new CorregirRuta(ruta.getText(), "\\", "\\\\");
        //String ruta = corregir.obtenerRutaCorregidaWindows();
       // if(ruta.getText().equals("")){
         //   JOptionPane.showMessageDialog(null, "Seleccione un archivo para subir","Mensaje",JOptionPane.INFORMATION_MESSAGE);
           // return;
       // }else{
        try{
        //System.out.println(ruta.getText());
        String rutaArchivo = ruta.getText();
        if(!rutaArchivo.isEmpty()){
            OperacionesCliente ea = new OperacionesCliente(ip);
            ea.enviarArchivo(rutaArchivo);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Seleccione un archivo a subir!!!");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Excepcion subir archivo: "+e);
        }

    //}
    }//GEN-LAST:event_subirBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      /*  File fichero = new File(ruta.getText());
        System.out.println("Fichero a eliminar: "+ruta.getText());
        if(fichero.delete()){
            System.out.println("Archivo eliminado correctamente");
        }else{
            System.out.println("No se ha podido eliminar el archivo");
        }*/
        try{
            String arc = JOptionPane.showInputDialog("Digite nombre del archivo a eliminar");
           // System.out.println("Despues de pedir archivo");
        OperacionesCliente obj = new OperacionesCliente(ip);
        //System.out.println("Despues de crear objeto");
        obj.eliminarArchivo(arc);
       // System.out.println("Despues de llamar la funcion eliminar");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        File fichero = new File("/home/julianesten/Escritorio");
        String[] ficheros = fichero.list();//Tenemos todos los archivos del fichero dado
        if(ficheros==null){
            System.out.println("No hay archivos en el servidor");
            
        }else{
              for(int i=0;i<ficheros.length;i++){
                  System.out.println(ficheros[i]);
              }
                  
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Archivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton examinarBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel ruta;
    private javax.swing.JButton subirBtn;
    // End of variables declaration//GEN-END:variables
     String ip;
}