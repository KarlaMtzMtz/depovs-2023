package mx.tecnm.itpl.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.itpl.models.Calificacion;
import mx.tecnm.itpl.dao.AlumnoJDBC;
import mx.tecnm.itpl.models.Alumno;

@RestController
@RequestMapping("/alumnos")

public class AlumnoREST {
	
		@Autowired
		AlumnoJDBC repo;
		@GetMapping
		public List<Alumno> obtenerAlumno(){
		
			
			return repo.consultar();
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<?> buscarALumno(@PathVariable int id) {
			try {
			Alumno respuesta = repo.buscar(id);
			return new ResponseEntity<Alumno>(respuesta, HttpStatus.OK );
			} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		
		
		}
		
		@DeleteMapping("/{id}")
		public void desactivarAlumno(@PathVariable int id) {
			repo.desactivar(id);
		}
		
		@PutMapping()
		public ResponseEntity<?> actualizarAlumno(@RequestBody Alumno alumno) {
			try {
				repo.actualizar(alumno);
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
			
			
		}
		
		@PostMapping
		public ResponseEntity<?> insertarAlumno(@RequestBody Alumno alumno) {
			try {
				repo.insertar(alumno);
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
			
		}
		
	@GetMapping("/calificacion/{id}")
	public ResponseEntity<?>obtenerNomyCalificacion(@PathVariable("id") int id){
	try {
		List<Calificacion> respuesta = repo.calificacionesAlumno(id);
		return new ResponseEntity<List<Calificacion>>(respuesta, HttpStatus.OK);
	} catch (Exception e) {
		System.out.println(e);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	}
		
		

}
