
package test;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import main.Partido;
import main.Persona;
import main.Pronostico;
import main.ResultadoEnum;
import main.Ronda;

import org.junit.Assert;
import org.junit.Test;
import com.mysql.jdbc.Driver;
public class Testeo {
	
	@Test
	public  void testsVarios() throws Exception {// ingreso planillas con valores y trato de verificar los puntos de cada persona
		
		ArrayList<ResultadoEnum> ResultadoEnumRondaPartido = new ArrayList<ResultadoEnum>(); 
		ArrayList<Ronda>         rondasPartido             = new ArrayList<Ronda>();  
		
																	
		ArrayList<Pronostico> pronostico = new ArrayList<Pronostico>();
		ArrayList<Persona> personas = new ArrayList<Persona>();
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3307/futbolapp"; //anda
			String usuario="root";
			String password="admin";
			
			Connection con=DriverManager.getConnection(url,usuario,password);
			
			if (con != null) {
			    System.out.println("Connected to the database");
			} else {
			    System.out.println("Failed to connect to the database");
			}
				 
		 
		  main.Ronda.leerresultados(ResultadoEnumRondaPartido, rondasPartido ,con);
		  
		  main.Pronostico.leerpronostico(personas, pronostico,con);
		  
		  main.Persona.calcularPuntajes( personas,  pronostico,  rondasPartido,  ResultadoEnumRondaPartido) ;
		 
		  int puntaje = personas.get(1).getPuntos();
		 // int puntaje = personas.get(0).getPuntos();
		  assertEquals(4, puntaje,0.00001);//Mariana
		 // assertEquals(1, puntaje,0.00001);//pedro 
	
		  
	
		} catch (SQLException e) {
			
			e.printStackTrace();}
		
		  
		  
	}

}
