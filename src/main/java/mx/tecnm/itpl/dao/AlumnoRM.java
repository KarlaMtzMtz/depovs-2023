package mx.tecnm.itpl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.tecnm.itpl.models.Alumno;

public class AlumnoRM implements RowMapper<Alumno>{

	@Override
	public Alumno mapRow(ResultSet rs, int rowNum) throws SQLException {
		Alumno alumno = new Alumno();
		alumno.setId(rs.getByte("id"));
		alumno.setNombre(rs.getString("nombre"));
		alumno.setNoControl(rs.getString("noControl"));
		return alumno;
	}		
	
	
}
