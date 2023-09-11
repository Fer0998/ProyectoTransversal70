
package proyectotransversal70.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectotransversal70.entidades.Alumno;


public class AlumnoData {
    
    private Connection con= null;
    
    
    public AlumnoData(){
    
        con = Conexion.getConexion();
        
    }
//--------------------------------------------------------------------------------------
    public void guardarAlumno(Alumno alumno){
    // guarda un alumno en la base de datos
        String sql = "INSERT INTO alumno(dni, apellido, nombre,fechaNacimiento, estado)"
                + " VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1,alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4,Date.valueOf(alumno.getfechaNacimiento()));
            ps.setBoolean(5,alumno.isEstado());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()){
                alumno.setId(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Alumno agregado");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 //--------------------------------------------------------------------------------------
public Alumno buscarAlumno(int id){
    
    Alumno alumno= null;
    String sql = "SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno=? AND estado =1";
    PreparedStatement ps = null;
        try {
            ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
               alumno = new Alumno();
               alumno.setIdAlumno(id);
               alumno.setDni(rs.getInt("dni"));
               alumno.setApellido(rs.getString("apellido"));
               alumno.setNombre(rs.getString("nombre"));              
               alumno.setfechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
               alumno.setEstado(true);                    
            }else{
                JOptionPane.showMessageDialog(null,"No existe el alumno");
            } 
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla Alumno"+ex.getMessage());
        }
        
        return alumno;
}  
//---------------------------------------------------------------------------------------------------------
   
    
    
    
    
    
    
}// fin class
