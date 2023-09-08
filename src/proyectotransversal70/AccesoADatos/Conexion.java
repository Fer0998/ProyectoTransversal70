
package proyectotransversal70.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB="unlp";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    private static Connection connection;
    
    private Conexion(){
        
    }
    
    public static Connection getConexion(){
        if(connection==null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection=DriverManager.getConnection(URL+DB,USUARIO,PASSWORD);
                
                JOptionPane.showMessageDialog(null, "Base de datos connectado");
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "No se cargaron los drivers");
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo conectar con la Base de datos");
            }
             
        }
   return connection;
       
    
    }
}//fin clase
