/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatoscd;

import java.sql.SQLException;

/**
 *
 * @author agarridogarcia
 */
public class BaseDatosCD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       InterfaceSQLite mibd= new InterfaceSQLite();
       
       if(mibd.conectar())
            System.out.println("CONECTADO.. ");
       else
            System.out.println("Hubo problemas");
               
       mibd.insert();
       mibd.consultar();
       mibd.cerrar();
    }
    
}
