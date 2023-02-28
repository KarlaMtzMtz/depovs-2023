package mx.tecnm.itpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class helloControler {
	
 @GetMapping ("/hola")
	 public String saludar() {
		 return "Hola backend";
	 }
	 
 
 @GetMapping("/saludar")
 	public String saludar(@RequestParam String nombre) {
	 return "Sin llorar..."+nombre;
 }
 
 @GetMapping ("/eco")
 public String repetir(@RequestParam String mensaje, int repetir)
 {
 	String mensajeRepetir =" ";
 	for (int i=0; i<repetir; i++){	
 	mensajeRepetir += mensaje + "<br>";
 		
 	}
 	return mensajeRepetir;
 	
 }
 
 
}
