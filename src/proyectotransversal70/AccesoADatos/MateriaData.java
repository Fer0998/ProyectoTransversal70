/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotransversal70.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectotransversal70.entidades.Materia;


public class MateriaData {
    
    private Connection con=null;

    public MateriaData() {

        con= Conexion.getConexion();
        
    }
  public void guardarMateria(Materia materia){
       
     String sql= "INSERT INTO materia(nombre,anio,estado)"
             + "VALUES (?,?,?)";
     
      try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, materia.getNombre());
            ps.setInt(2,materia.getAnioMateria());
            ps.setBoolean(3,materia.isActivo());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()){
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Materia agregada");
            }
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error de conexion a la base");
        }
   }

  public Materia buscarMateria (int id){
  
        Materia materia=null;
        String sql= "SELECT nombre, anio, estado FROM materia WHERE idMateria=?";
        PreparedStatement ps=null;
            try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                materia=new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));
                materia.setActivo(true);
            }else{
                JOptionPane.showMessageDialog(null,"No existe la materia");
            }   
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion a la base");
        }
            return materia;
  }
  
  public void modificarMateria(Materia materia){
  
  String sql= "UPDATE materia SET nombre=?,anio=?,estado=? WHERE idMateria=?";
  PreparedStatement ps=null;
  
  try {
        ps = con.prepareStatement(sql);
        ps.setString(1, materia.getNombre());
        ps.setInt(2, materia.getAnioMateria());
        ps.setBoolean(3, materia.isActivo());
        ps.setInt(4, materia.getIdMateria());
        int mat = ps.executeUpdate();

    if (mat == 1) {
        JOptionPane.showMessageDialog(null, "Modificada Exitosamente.");
    } else {
        JOptionPane.showMessageDialog(null, "La materia no existe");
    }
        ps.close();
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia"+ex.getMessage());    
    }
  }
  
  public void eliminarMateria (int id){
      
      String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ?";
      PreparedStatement ps = null;
      
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int fila = ps.executeUpdate();
            
            if(fila == 1){
                JOptionPane.showMessageDialog(null,"Se eliminó la materia.");                           
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla Materia"+ex.getMessage());
        }
   }
  
  public List<Materia> listarMaterias(){
    
    String sql = "SELECT nombre, anio, estado FROM materia WHERE estado =1";
    ArrayList<Materia> materias = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
               Materia materia = new Materia();
               materia.setIdMateria(rs.getInt("idMateria"));
               materia.setNombre(rs.getString("nombre"));              
               materia.setAnioMateria(rs.getInt("Anio"));
               materia.setActivo(true);        
               
               materias.add(materia);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla Materia"+ex.getMessage());
        }
        
        return materias;
  
}
}
