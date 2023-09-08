
package proyectotransversal70.entidades;


public class Inscripcion {
    
    private int idInscripto;
    private double nota;
    private Alumno idAlumno;
    private Materia IDMateria;

    public Inscripcion(int idInscripto, double nota, Alumno idAlumno, Materia IDMateria) {
        this.idInscripto = idInscripto;
        this.nota = nota;
        this.idAlumno = idAlumno;
        this.IDMateria = IDMateria;
    }

    public Inscripcion(double nota, Alumno idAlumno, Materia IDMateria) {
        this.nota = nota;
        this.idAlumno = idAlumno;
        this.IDMateria = IDMateria;
    }

    public Inscripcion() {
    }

    public int getIdInscripto() {
        return idInscripto;
    }

    public void setIdInscripto(int idInscripto) {
        this.idInscripto = idInscripto;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Materia getIDMateria() {
        return IDMateria;
    }

    public void setIDMateria(Materia IDMateria) {
        this.IDMateria = IDMateria;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripto=" + idInscripto + ", nota=" + nota + ", idAlumno=" + idAlumno + ", IDMateria=" + IDMateria + '}';
    }
    
    
    
    
}
