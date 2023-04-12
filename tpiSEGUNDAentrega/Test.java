
package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import main.Partido;
import main.Persona;
import main.Pronostico;
import main.ResultadoEnum;
import main.Ronda;

import org.junit.Assert;

public class Test {
	
	
	public void testsVarios() {// ingreso planillas con valores y trato de verificar los puntos de cada persona
		
		ArrayList<ResultadoEnum> ResultadoEnumRondaPartido = new ArrayList<ResultadoEnum>(); 
		ArrayList<Partido>       rondaPartido              = new ArrayList<Partido>();
		ArrayList<Ronda>         rondasPartido             = new ArrayList<Ronda>();  
		List<String> lineas1= null;
		String ruta1="C:\\Users\\franc\\eclipse-workspace\\Maven\\src\\main\\resultados.csv" ;
	
	     
																		
		ArrayList<Pronostico> pronostico = new ArrayList<Pronostico>(); 
		ArrayList<Persona> personas = new ArrayList<Persona>();
		List<String> lineas2 = null;
		String ruta2="C:\\Users\\franc\\eclipse-workspace\\Maven\\src\\main\\pronosticos.csv" ;			 
		 
		  main.Main.leerresultados(ResultadoEnumRondaPartido,rondaPartido, rondasPartido ,lineas1,ruta1);
		  
		  main.Main.leerpronostico(personas, pronostico,lineas2,ruta2);
		  
		  main.Main.calcularPuntajes( personas,  pronostico,  rondasPartido,  ResultadoEnumRondaPartido) ;
		
		
		
		  int puntaje = personas.get(0).getPuntos();
		  
		
		assertEquals(1, puntaje,0.00001);
	}

}
