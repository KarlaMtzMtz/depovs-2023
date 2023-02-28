package mx.tecnm.itpl.models;

public class Calificacion {
    private String alumno;
    private String nombre;
    private String calificacion;


    public String getAlumno() {
        return this.alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalificacion() {
        return this.calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }
}