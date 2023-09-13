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
    private MateriaData matData;
    private AlumnoData aluData;

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

            if (rs.next()) {
                insc.setIdInscripto(rs.getInt(1));//Obtener el valor de la clave generada y Asignar la clave generada a la inscripción
                JOptionPane.showMessageDialog(null, "Inscripcion realizada con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion" + ex.getMessage());
        }

    }//---------------------------------------------------------------------------------------------

    public List<Inscripcion> obtenerInscripciones() {
        AlumnoData alumno = new AlumnoData();//CREO ESTOS OBJETOS PARA PODER IMPLEMETAR EL METODO BUSCARALUMNO
        MateriaData materia = new MateriaData();
        List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
        String sql = "SELECT * FROM inscripcion ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno a = new Alumno();
                Materia m = new Materia();

                Inscripcion ins = new Inscripcion();
                ins.setIdInscripto(rs.getInt("idInscripto"));//idinscripcion es tipo entero (clase inscripcion)
                ins.setNota(rs.getDouble("nota"));

                a = alumno.buscarAlumno(rs.getInt("idAlumno"));//idAlumno es tipo alumno, por eso se completa de esta forma igual para materia
                ins.setAlumno(a);

                m = materia.buscarMateria(rs.getInt("idMateria"));
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
        AlumnoData alumno = new AlumnoData();//CREO ESTOS OBJETOS PARA PODER IMPLEMETAR EL METODO BUSCARALUMNO
        MateriaData materia = new MateriaData();//CREO ESTOS OBJETOS PARA PODER IMPLEMETAR EL METODO BUSCARMATERIA

        String sql = "SELECT * FROM inscripcion "
                + " WHERE inscripcion.idAlumno =? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Inscripcion inscripcion;

            while (rs.next()) {
                Alumno a = new Alumno();
                Materia m = new Materia();
                inscripcion = new Inscripcion();

                inscripcion.setIdInscripto(rs.getInt("idInscripto"));
                inscripcion.setNota(rs.getInt("nota"));

                a = alumno.buscarAlumno(id);//ME PASA EL ID POR EL PARAMETRO, USO EL METODO DE LA CLASE ALUMNODATA PARA BUSCAR EL ALUMNO
                inscripcion.setAlumno(a);//COLOCA LA INF DEL ALUMNO PASADO POR ID

                //  int idMat = rs.getInt("idMateria");// saque el id de materia del rs
                m = materia.buscarMateria(rs.getInt("idMateria"));
//GUARDAMOS LOS DATOS EN objeto materia M; cargado con el objeto materia que trae el metodo
//buscarMateria de la clase materiadata a traves del id.
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

        String sql = "SELECT inscripcion.idMateria, nombre,año FROM incripcion JOIN"
                + "  materia ON(inscripcion.idMateria= materia.idMateria )"
                + " WHERE AND inscripcion.idAlumno=? AND ESTADO=1";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Materia materia;
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener incripciones" + ex.getMessage());
        }

        return materias;

    }

    public List<Materia> obtenerMateriaNOCursadas(int id) {
        return obtenerMateriaNOCursadas(id);
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
           JOptionPane.showMessageDialog(null,"No se puede conectar a la tabla inscripciones"+ ex.getMessage());
        }
        

    }

    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        return null;

    }

}
