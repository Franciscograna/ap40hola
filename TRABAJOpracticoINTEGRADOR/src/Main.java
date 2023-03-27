package modelo;
import java.nio.charset.Charset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import modelo.Equipo;
import modelo.Partido;


public class Main {
	

	
	public static void main(String[] args) {
		
		
		Partido partido[] = new Partido[2];
		Partido tiketJugador[] = new Partido[2];

		Equipo equipo1tiket = new Equipo();
		Equipo equipo2tiket = new Equipo();
		
		
		try {
			int i=0;
			List<String> lineas = Files.readAllLines(Paths.get("C:\\Users\\Notebook\\Desktop\\FRAN\\AP40\\Workspace\\TPI\\src\\modelo\\resultados.csv"), Charset.forName("ISO-8859-1"));
			lineas.remove(0);
			for(String linea :lineas)			
			 {
				
			            
			   String equipo1Nombre  = linea.split(";")[0]; 
			   String equipo2Nombre  = linea.split(";")[2]; 
			   int equipo1Goles  = Integer.parseInt(linea.split(";")[1]);
			   int equipo2Goles  = Integer.parseInt(linea.split(";")[3]);
			   
				Equipo equipo1Result = new Equipo(equipo1Nombre,"");
				Equipo equipo2Result = new Equipo(equipo2Nombre,"");
				
				partido[i]= new Partido(equipo1Result,equipo2Result,equipo1Goles,equipo2Goles); //falta armar el partido
			   
			 System.out.println(equipo1Result.getEquipo());     //test de salida
			   System.out.println(equipo2Result.getEquipo());
			   System.out.println(equipo1Goles);
			   System.out.println(equipo2Goles);
			   
			   
			   i++;
			  }
			   
			  
			 } 
			 catch (IOException e) {
			  e.printStackTrace();
			 }
			
	}

	private static char[] Str(int equipo1Goles) {
		// TODO Auto-generated method stub
		return null;
	}
		
}	
