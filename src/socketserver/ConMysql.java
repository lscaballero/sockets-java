/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

/**
 *
 * @author Administrator
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class ConMysql {
  
    
   static String bd = "xyz";
   static String login = "root";
   static String password = "";
   static String url = "jdbc:mysql://localhost:3306/xyz";
   //static String url = "jdbc:oracle:thin:@localhost:1521:XE";

 
   Connection conn = null;

   public ConMysql () {
      try{
         //obtenemos el driver de para Oracle
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

