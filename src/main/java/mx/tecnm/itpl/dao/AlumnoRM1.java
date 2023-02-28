package mx.tecnm.itpl.dao;

import mx.tecnm.itpl.models.Calificacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.lang.Nullable;

public class AlumnoRM1 implements RowMapper <Calificacion> {

	@Override
	@Nullable
	
	public Calificacion mapRow(ResultSet rs, int rowNum) throws SQLException {
        Calificacion alumno = new Calificacion();
        alumno.setAlumno(rs.getString("alumno"));
        alumno.setNombre(rs.getString("nombre"));
        alumno.setCalificacion(rs.getString("calificacion"));

        return alumno;
    }
}
