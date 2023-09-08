
package proyectotransversal70.entidades;

import java.time.LocalDate;


public class Alumno {
      private int id;
    private int dni;
    private String apellido;
    private String nombre;
    private LocalDate fechaNacimiento;
    private boolean estado;
//-----------------------------------------------------------------------------------------------------------
    public Alumno(int id, int dni, String apellido, String nombre, LocalDate fNacimiento, boolean estado) {
        this.id = id;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fNacimiento;
        this.estado = estado;
    }
//-----------------------------------------------------------------------------------------------------------
    public Alumno(int dni, String apellido, String nombre, LocalDate fNacimiento, boolean estado) {
        
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fNacimiento;
        this.estado = estado;
    }
//-----------------------------------------------------------------------------------------------------------
    public Alumno(){}
    
//-----------------------------------------------------------------------------------------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getfNacimiento() {
        return fechaNacimiento;
    }

    public void setfNacimiento(LocalDate fNacimiento) {
        this.fechaNacimiento = fNacimiento;
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
         return "Alumno\n"+
                "-------------------------"+"\n"+
                "Id       = " + id +"\n"+ 
                "Dni      = " + dni +"\n"+ 
                "Apellido = " + apellido +"\n"+ 
                "Nombre   = " + nombre + "\n"+
                "Fecha Na = " + fechaNacimiento +"\n"+ 
                "Estado   = " + estado +"\n"+
                "-------------------------";
    }
    
}// fin class
