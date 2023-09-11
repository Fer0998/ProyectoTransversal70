/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotransversal70.AccesoADatos;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import proyectotransversal70.entidades.Alumno;
import proyectotransversal70.entidades.Materia;

public class InscripcionData {
    private Connection con=null;
    private MateriaData matData;
    private AlumnoData aluData;

    public InscripcionData() {
        
             con= Conexion.getConexion();
        
        
    }
    
    public List<Materia> obtenerMateriaNOCursadas(int id) {
        List<Materia> materiasNOCursadas = new ArrayList<>();
        return materiasNOCursadas;
    }
    
     public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {

    }
     
    public void actualizarNota(int idAlumno, int idMateria, double nota){
        
    }
    
    public List<Alumno> obtenerAlumnosXMateria(int idMateria){
        return null;
        
    }
    
}
