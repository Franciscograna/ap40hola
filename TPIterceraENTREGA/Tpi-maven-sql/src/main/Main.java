package main;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import main.ResultadoEnum;
import main.Equipo;
import main.Partido;
import main.Pronostico;
import main.Ronda;
import main.Persona;

public class Main {
	public static void main(String[] args) {
					
			ArrayList<ResultadoEnum> ResultadoEnumRondaPartido = new ArrayList<ResultadoEnum>(); // clase que guarda el resultado de eq1,eq2( agregue objeto para tener mas info)
			ArrayList<Ronda>         rondasPartido             = new ArrayList<Ronda>();  //clase que guarda la clase partido y el numero de ronda
			   																		
			ArrayList<Pronostico> pronostico = new ArrayList<Pronostico>(); //clase que guarda la apuesta que debera guardar la persona
			ArrayList<Persona> personas = new ArrayList<Persona>();
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3307/pronosticosyresultados"; //anda
				String usuario="root";
				String password="";
				
				Connection con=DriverManager.getConnection(url,usuario,password);
				
				if (con != null) {
				    System.out.println("conectado a la base de datos");
				} else {
				    System.out.println("fallo la conexion con la base de datos");
				}
				
				
				
				//metodos
				  Ronda.leerresultados(ResultadoEnumRondaPartido, rondasPartido ,con);
				  
				  Pronostico.leerpronostico(personas, pronostico,con);
				  
				  Persona.calcularPuntajes( personas,  pronostico,  rondasPartido,  ResultadoEnumRondaPartido) ;	
				
				  con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			  				
		}
	}

