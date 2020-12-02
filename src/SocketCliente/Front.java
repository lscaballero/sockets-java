/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketCliente;

import java.io.PrintStream;
import java.net.Socket;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Administrator
 */
public class Front extends javax.swing.JFrame {

    /**
     * Creates new form Front
     */
    public  Front() {
        initComponents();
        mostrar_clientes();  
    }
        Socket socket;
	Scanner entrada;
	PrintStream salida;
	String ip = "WIN-0F09UETMDKD";
	int puerto = 3001;
        

        
	socketserver.ConMysql obj = new socketserver.ConMysql();
     DefaultTableModel tabla = new  DefaultTableModel();
     
     void mostrar_clientes () {
         
         tabla.addColumn("id");
         tabla.addColumn("nombre");
         tabla.addColumn("apellido");
         tabla.addColumn("email");
         tabla.addColumn("direccion");
       
        try {
            
            final Connection con = obj.getConnection();
            Statement st = con.createStatement();
            
            ResultSet  rs = st.executeQuery("SELECT cli.id,\n" +
            										"cli.nombre,\n" +
                                                    "cli.apellido,\n" +
                                                    "cli.email,\n" +
                                                    "cli.direccion\n" +
                                                    "FROM clientes cli" );
            
            String datos [] = new String [5];
            
            while (rs.next()) {
                
                datos [0] = rs.getString(1);
                datos [1] = rs.getString(2);
                datos [2] = rs.getString(3);
                datos [3] = rs.getString(4);
                datos [4] = rs.getString(5);
                
                tabla.addRow(datos);
            }   
            tabla.addTableModelListener(new TableModelListener() {
                
                @Override
                public void tableChanged(TableModelEvent e) {
                    if(e.getType() == TableModelEvent.UPDATE){
                     int columna = e.getColumn();
                     int file = e.getFirstRow();
                     if (columna == 3){
                      String sqlUP = " UPDATE clientes SET ac_balance = "+tabla.getValueAt(file, columna)+" WHERE id = "+tabla.getValueAt (file, 0)+"; COMMIT; ";
                      System.out.println(sqlUP);

                     }
                     if (columna == 1){   
                     String sqlDEL = " DELETE FROM clientes WHERE id = "+tabla.getValueAt (file, 0)+"; COMMIT; ";
                     System.out.println(sqlDEL);
   
                     }
                    }
  
                }

            }   );
            {
        
         }

            jTable1.setModel(tabla);
            
        } catch (SQLException e) {
            
            System.out.println("consulta incorrecta "+e);  
            
        }
        
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            	//cada oobjeto debe tener 5 líneas
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            //encabezados de la tabla
            new String [] {
                "id","Nombre", "Apellido", "Email", "Direccion"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("CREA CLIENTE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("SALIR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton3)
                .addGap(39, 39, 39)
                .addComponent(jButton4)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
 
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        System.exit(0);
        
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         

        Connection con = obj.getConnection();
        try {
            
        	Statement cStmt = con.createStatement();
            
            //Statement stmt = con.createStatement();

            cStmt.executeUpdate("INSERT INTO clientes VALUES( 0, 'jose', 'maría','sky@sky.com', 'Av viva siempre viva') ");
            
            //cStmt.execute();    
   
            System.out.println("el cliente se ha creado correctamente!!!"); 
            
            cStmt.close();
            
            
        } catch (Exception e) {
            
            System.out.println("No se pudo crear cliente "+e); 
        }
        
    }                                        

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
            java.util.logging.Logger.getLogger(Front.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Front.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Front.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Front.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Front().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}
