package mx.tecnm.itpl.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itpl.models.Calificacion;
import mx.tecnm.itpl.models.Alumno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class AlumnoJDBC {

	@Autowired	
	JdbcTemplate conexion;
	
	public List<Alumno> consultar(){
		
		String sql = "SELECT * FROM alumnos WHERE activo=1";
		return conexion.query(sql, new AlumnoRM());
		
	}

	public Alumno buscar(int id) {
		String sql = "SELECT * FROM alumnos WHERE id=? AND activo=1";
		return conexion.queryForObject(sql, new AlumnoRM(), id);
	}

	public void desactivar(int id) {
		String sql = "UPDATE alumnos SET activo = 0, deleted = now() WHERE id=?";
		conexion.update(sql,id);	
		}

	public void actualizar(Alumno alumno) {
		String sql = "UPDATE alumnos SET nombre=?, noControl=?, updated = now() WHERE id=?";
		conexion.update(sql,alumno.getNombre(),alumno.getNoControl(),alumno.getId());
		
	}

	public void insertar(Alumno alumno) {
		String sql = "INSERT INTO alumnos (nombre, noControl) VALUES (?,?)";
		conexion.update(sql,alumno.getNombre(), alumno.getNoControl());
		
	}
	
	
	public  List<Calificacion> calificacionesAlumno(long id) {
	    String sql ="SELECT a.nombre as alumno, m.nombre,c.calificacion from materias m join calificaciones c ON c.materia_id=m.id join alumnos a on a.id=c.alumno_id where alumno_id=?";
	    return  conexion.query(sql, new AlumnoRM1(),id);
	  }
	

	
	
}
