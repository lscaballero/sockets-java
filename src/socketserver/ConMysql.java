/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

/**
 *
 * @author
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author
 */
public class ConMysql {
  
    
   static String bd = "xyz";
   static String login = "root";
   static String password = "";
   static String url = "jdbc:mysql://localhost:3306/xyz";

 
   Connection conn = null;

   public ConMysql () {
      try{
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,login,password);
         
         if (conn!=null){
            System.out.println("Conexión a base de datos "+bd+". listo");
         }
      }catch(SQLException | ClassNotFoundException e){
         System.out.println(e);
      }
   }

   public Connection getConnection(){
      return conn;
   }

   public void desconectar(){
      conn = null;
      System.out.println("La conexion a la  base de datos "+bd+" a terminado");
   }
    
}

