
package proyectotransversal70;

import java.sql.Connection;
import proyectotransversal70.AccesoADatos.AlumnoData;
import proyectotransversal70.AccesoADatos.Conexion;
import proyectotransversal70.AccesoADatos.InscripcionData;
import proyectotransversal70.AccesoADatos.MateriaData;
import proyectotransversal70.entidades.Alumno;
import proyectotransversal70.entidades.Inscripcion;
import proyectotransversal70.entidades.Materia;


public class ProyectoTransversal70 {

    
    public static void main(String[] args) {
        
       Connection con=Conexion.getConexion();
        
        AlumnoData ad=new AlumnoData();
        MateriaData md=new MateriaData();
        InscripcionData id=new InscripcionData();
        
        
        Alumno sofi=ad.buscarAlumno(26);
        Materia electricidadMag=md.buscarMateria(3);
       // Inscripcion ins=new Inscripcion(9,sofi,electricidadMag);
        
       //  id.guardarIscripcion(ins);
      // id.actualizarNota(21, 5, 5);
      id.borrarInscripcionMateriaAlumno(11, 1);
        
                
       
      
    }
    
}
