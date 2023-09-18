package proyectotransversal70.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectotransversal70.entidades.Alumno;
import proyectotransversal70.entidades.Inscripcion;
import proyectotransversal70.entidades.Materia;

public class InscripcionData {
    private Connection con=null;
    private MateriaData matData=new MateriaData();
    private AlumnoData aluData =new AlumnoData();

    public InscripcionData() {
        
             con= Conexion.getConexion();
        
    }
    public void guardarIscripcion(Inscripcion insc) {
        String sql = "INSERT INTO inscripcion( nota, idAlumno, idMateria) "
                + "VALUES (?,?,?)";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {//if porque me va a devolver solo una clave del nuevo inscripto
                insc.setIdInscripto(rs.getInt(1));//Obtener el valor de la clave generada y Asignar la clave generada a la inscripción
                JOptionPane.showMessageDialog(null, "Inscripcion realizada con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion" + ex.getMessage());
        }

    }//-----------------------------------------------------------------------------------

    public List<Inscripcion> obtenerInscripciones() {//------------------------------------------------------------------------------------------------

        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Inscripcion ins = new Inscripcion();
                ins.setIdInscripto(rs.getInt("idInscripto"));//idinscripcion es tipo entero (clase inscripcion)
                ins.setNota(rs.getDouble("nota"));

                Alumno a = aluData.buscarAlumno(rs.getInt("idAlumno"));
                ins.setAlumno(a);

                Materia m = matData.buscarMateria(rs.getInt("idMateria"));
                ins.setMateria(m);

                inscripciones.add(ins);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripciones" + ex.getMessage());
        }

        return inscripciones;

    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {

        List<Inscripcion> inscAlu = new ArrayList<Inscripcion>();
        String sql = "SELECT * FROM inscripcion "
                + " WHERE idAlumno =? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);//SETTEO EL ENTERO QUE CORRESPONDE AL PRIMER PARAMETRO DINAMICO (?)
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Inscripcion inscripcion = new Inscripcion();

                inscripcion.setIdInscripto(rs.getInt("idInscripto"));
                inscripcion.setNota(rs.getInt("nota"));

                Alumno a = aluData.buscarAlumno(rs.getInt("idAlumno"));
                inscripcion.setAlumno(a);//COLOCA LA INF DEL ALUMNO PASADO POR ID

                //  int idMat = rs.getInt("idMateria");// saque el id de materia del rs
                Materia m = matData.buscarMateria(rs.getInt("idMateria"));
                //uso el resultset para recuperar el id de materia,pasarselo al metodo buscarMateria y asi obtner los datos de la materiaaaaaaaaa
                inscripcion.setMateria(m);// SETTEAR

                inscAlu.add(inscripcion);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener incripciones" + ex.getMessage());
        }

        return inscAlu;

    }

    public List<Materia> obtenerMateriasCursadas(int id) {
        List<Materia> materias = new ArrayList<Materia>();

        String sql = "SELECT inscripcion.idMateria, nombre,año FROM inscripcion,"
                + " materia  WHERE inscripcion.idMateria= materia.idMateria"
                + " AND inscripcion.idAlumno=? ";
        // EL PROFE NO USA JOIN PRODUCTO CARTESIANO'????????JAJAJA
        
        try {
             PreparedStatement  ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
               Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ACCEDER A LA TABLA INSCRIPCION" + ex.getMessage());
        }

        return materias;

    }

    public List<Materia> obtenerMateriaNOCursadas(int id) {
        List<Materia> materias = new ArrayList<Materia>();

        String sql = "SELECT *FROM materia WHERE estado=1 AND idMateria NOT IN"//
                + " (SELECT idMateria FROM inscripcion WHERE idAlumno=?)"; //el idMateria NO ESTE en el 2°select
            
              
      // el 2° select es una subconsulta para obtener los id de todas 
      //las materias a los que un alumno esta inscripto
     //  recupera todas las filas de la tabla "materia" donde el estado
     //es igual a 1 y donde el valor de "idMateria" no está presente en la tabla 
     //"inscripcion" para el alumno cuyo ID se proporciona como parámetro en la consulta. 
        
        try {
             PreparedStatement  ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
               Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ACCEDER A LA TABLA INSCRIPCION" + ex.getMessage());
        }

        return materias;

    }
    

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        String sql= "DELETE FROM inscripcion WHERE idAlumno=? AND idMateria=?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            
            int filas=ps.executeUpdate();
            
            if (filas>0) {
                JOptionPane.showMessageDialog(null, "Inscripcion eliminida");
                
            }
            ps.close();
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"No se puede conectar a la tabla inscripciones"+ ex.getMessage());
        }
        
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        String sql="UPDATE inscripcion SET nota=? "
                + "WHERE idAlumno=? AND idMateria=?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            
            int filas=ps.executeUpdate();
            
            if(filas>0){
                JOptionPane.showMessageDialog(null, "Nota Actualizada");
            }
            ps.close();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"No se puedo conectar con la tabla al intentar  actualizar la nota!"+ ex.getMessage());
        }
        
    }

    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        ArrayList<Alumno> alumnosMateria = new ArrayList<>();

        String sql = "SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento, estado"
                + " FROM inscripcion i, alumno a "
                + "WHERE i.idAlumno=a.idAlumno AND idMateria=? AND a.estado=1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setfechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));

                alumnosMateria.add(alumno);
                
               
            }
                            if(alumnosMateria.isEmpty()){
                      System.out.println("Aun no hay alumnos inscriptos en esta materia");//no muestra el msj, que este mal?
                }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnosMateria;

    }

}
