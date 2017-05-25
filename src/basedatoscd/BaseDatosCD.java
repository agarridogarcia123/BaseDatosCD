/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatoscd;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author agarridogarcia
 */
public class BaseDatosCD {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       InterfaceSQLite mibd= new InterfaceSQLite("jdbc:sqlite:ejemploBase.db");
       
       if(mibd.conectar())
            System.out.println("CONECTADO.. ");
       else
            System.out.println("Hubo problemas");
               
     
        int opcion;
      
         
         do{
             try{
                 
                 opcion=Integer.parseInt(JOptionPane.showInputDialog("***MENU***\n1 Insertar \n2 Consultar tablas \n3 Borrar \n4 \n5 Salir"));
                 
             }catch(Exception ex){
                 System.out.println(ex.getMessage());
                 opcion=0;
             }
            switch(opcion){
            case 1: mibd.insert(Integer.parseInt(JOptionPane.showInputDialog("dni")),JOptionPane.showInputDialog("nombre"));
                break;
            case 2: mibd.consultar();
                break;
            case 3:mibd.borrar("Delete from alumno where dni="+JOptionPane.showInputDialog("dni"));
                break;
            case 4:
                break;
            case 5:mibd.cerrarBD();System.exit(0);
                break;
//           
            
        }
    
    }while(opcion<5);

    
    }
}
    

