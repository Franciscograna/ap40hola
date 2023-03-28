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
		
		
		Partido rondaPartido[]= new Partido[2] ;
	

	
		
		
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
				
				rondaPartido[i]= new Partido(equipo1Result,equipo2Result,equipo1Goles,equipo2Goles); //falta armar el partido
			   
			
			   
				
				
			   
			   i=i+1;
			  }
			   
			  
			 } 
			 catch (IOException e) {
			  e.printStackTrace();
			 }
		   System.out.println("---------");
		   System.out.println("resultados");
		   System.out.println("---------");
		   System.out.println(rondaPartido[0].getEquipo1().getEquipo());
		   System.out.println(rondaPartido[0].getGolesEquipo1());
		   System.out.println(rondaPartido[0].getEquipo2().getEquipo());
		   System.out.println(rondaPartido[0].getGolesEquipo2());
		   System.out.println(rondaPartido[1].getEquipo1().getEquipo());
		   System.out.println(rondaPartido[1].getGolesEquipo1());
		   System.out.println(rondaPartido[1].getEquipo2().getEquipo());
		   System.out.println(rondaPartido[1].getGolesEquipo2());
		

		   
		   
		   
		   
		   
			Partido tiketJugador[]= new Partido[2] ;

			
			
			
			try {
				int i=0;
				List<String> lineas = Files.readAllLines(Paths.get("C:\\Users\\Notebook\\Desktop\\FRAN\\AP40\\Workspace\\TPI\\src\\modelo\\pronosticos.csv"), Charset.forName("ISO-8859-1"));
				lineas.remove(0);
				for(String linea :lineas)			
				 {
					
				            
				   String equipo1NombreTiket  = linea.split(";")[0]; 
				   String equipo2NombreTiket  = linea.split(";")[2]; 
				   int equipo1GolesTiket           = Integer.parseInt(linea.split(";")[1]);
				   int equipo2GolesTiket           = Integer.parseInt(linea.split(";")[3]);
				   
					Equipo equipo1tiket = new Equipo(equipo1NombreTiket,"");
					Equipo equipo2tiket = new Equipo(equipo2NombreTiket,"");
					
					tiketJugador[i]= new Partido(equipo1tiket,equipo2tiket,equipo1GolesTiket,equipo2GolesTiket); //falta armar el partido
				   
						
				   
				   i=i+1;
				  }
				   
				  
				 } 
				 catch (IOException e) {
				  e.printStackTrace();
				 }
			   System.out.println("---------");
			   System.out.println("apuestas");
			   System.out.println("---------");
			   System.out.println(tiketJugador[0].getEquipo1().getEquipo());
			   System.out.println(tiketJugador[0].getGolesEquipo1());
			   System.out.println(tiketJugador[0].getEquipo2().getEquipo());
			   System.out.println(tiketJugador[0].getGolesEquipo2());
			   System.out.println(tiketJugador[1].getEquipo1().getEquipo());
			   System.out.println(tiketJugador[1].getGolesEquipo1());
			   System.out.println(tiketJugador[1].getEquipo2().getEquipo());
			   System.out.println(tiketJugador[1].getGolesEquipo2());
			   System.out.println("---------");
			   System.out.println("aciertos:");
		   	

			int aciertos=0;

					for(int index=0; index<rondaPartido.length;index++)			//lectura de datos del partido, del equipo1 
									{
						int gol1r=rondaPartido[index].getGolesEquipo1() ; int gol2r=rondaPartido[index].getGolesEquipo1() ; int gol1t = tiketJugador[index].getGolesEquipo1() ; int gol2t = tiketJugador[index].getGolesEquipo2();
							if (             rondaPartido[index].resultado(gol1r,gol2r ) == tiketJugador[index].resultado(gol1t,gol2t )            )

										aciertos=aciertos+1;

															}
 			//cantidad de aciertos
System.out.println(aciertos);

			
	}	
}
