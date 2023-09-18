
package proyectotransversal70.entidades;

import java.time.LocalDate;


public class Alumno {
    private int idAlumno;
    private int dni;
    private String apellido;
    private String nombre;
    private LocalDate fechaNacimiento;
    private boolean estado;
//-----------------------------------------------------------------------------------------------------------
    public Alumno(int idAlumno, int dni, String apellido, String nombre, LocalDate fechaNacimiento, boolean estado) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }
//-----------------------------------------------------------------------------------------------------------
    public Alumno(int dni, String apellido, String nombre, LocalDate fechaNacimiento, boolean estado) {
        
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }
//-----------------------------------------------------------------------------------------------------------
    public Alumno(){}
    
//-----------------------------------------------------------------------------------------------------------

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getfechaNacimiento() {
        return fechaNacimiento;
    }

    public void setfechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

//-----------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
         return 
              //  "-------------------------"+"\n"+
            //    "idAlumno = " + idAlumno +"\n"+ 
             //  "Dni      = " + dni +"\n"+ 
                apellido +", "+ nombre +  ", " + dni ;
              //  "Nombre: " + +
                // "Dni:" ++"\n" ;
            //    "Fecha Na = " + fechaNacimiento +"\n"+ 
            //    "Estado   = " + estado +"\n"+
             
    }
 
    
}// fin class
