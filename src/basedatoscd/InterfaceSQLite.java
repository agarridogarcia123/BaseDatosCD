/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatoscd;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author agarridogarcia
 */
public class InterfaceSQLite {
    private String url="jdbc:sqlite:ejemploBase.db";
    Connection connection; 

    
    

    
    public boolean conectar() throws ClassNotFoundException{
    
        
        Class.forName("org.sqlite.JDBC");
     
        
        
        try{ 
     connection=DriverManager.getConnection(url);
      return true;
     }catch( SQLException e){
         return false;
     }
    }
    
    
    /**
     * insert tables and lines
     * @throws SQLException 
     */
   
    public void insert() throws SQLException{
         Statement statement=connection.createStatement();
         statement.executeUpdate("drop table if exists alumno");
         statement.executeUpdate("create table alumno(dni integer, nombre string)");
         statement.executeUpdate("insert into alumno values(3456,'Ana')");
         
    }

    /**
     * 
     * @throws SQLException 
     */
    public void consultar() throws SQLException{
       Statement statement=connection.createStatement();
       ResultSet rs=statement.executeQuery("select * from alumno");
       while(rs.next()){
           System.out.println("dni="+rs.getInt("dni"));
           System.out.println("nombre="+rs.getString("nombre"));
       }
           
    }
    public void cerrar(){
      try{
        if(connection != null)
          connection.close();
          System.out.println("Base de datos cerrada.");
      }catch(SQLException e){
        // connection close failed.
        System.err.println(e);
      }
    }
}
    


