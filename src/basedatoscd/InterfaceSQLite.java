/*
 * This class configures the database
 * 
 * 
 */
package basedatoscd;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author agarridogarcia
 */




public class InterfaceSQLite {

    public InterfaceSQLite(String url) throws ClassNotFoundException, SQLException {
        this.url=url;
        conectar();
        Statement statement= connection.createStatement();
        statement.executeUpdate("drop table if exists alumno");
        statement.executeUpdate("create table alumno(dni integer, nombre string)");
       
    }
    
    private String url;
    Connection connection; 
    

    
    /**
     * 
     * @return boolean: true if it can connect or false 
     * @throws ClassNotFoundException 
     */

    
    public boolean conectar() throws ClassNotFoundException{
        
        try{ 
       connection=DriverManager.getConnection(url);
       return true;
       }catch( SQLException e){
         return false;
       }
       }
    
    
    /**
     * 
     * @param insert:  insert tables and lines 
     * 
     * @throws SQLException 
     */
   
    public boolean insert(int dni, String nombre ) throws SQLException{
         String pedir="insert into alumno values("+ dni + ", '" + nombre + "')";
         Statement statement=connection.createStatement();
        statement.executeUpdate(pedir);
//         statement.executeUpdate("insert into alumno values(123,'Ana')");

    }

    /**
     * consultar() is for search in the database
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
    /**
     * cerrarBD is for close the database
     */
    public void cerrarBD(){
      try{
        if(connection != null)
          connection.close();
          System.out.println("Base de datos cerrada.");
      }catch(SQLException e){
       System.err.println("Error no se puede cerrar la base de datos"+e);
      }
    }
    
    public void borrar(String borrar) throws SQLException{
        Statement stat=connection.createStatement();
        stat.executeUpdate(borrar);
    }
}
    


