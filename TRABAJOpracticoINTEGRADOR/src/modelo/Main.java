package modelo;
import java.nio.charset.Charset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import modelo.ResultadoEnum;
import modelo.Equipo;
import modelo.Partido;
import modelo.Pronostico;


public class Main {
	

	
	public static void main(String[] args) {
		
		
		Partido rondaPartido[]= new Partido[2] ;
		ResultadoEnum resultadoEnumRondaPartido[] = new ResultadoEnum[2]; 
	
	
		
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
				
				rondaPartido[i]= new Partido(equipo1Result,equipo2Result,equipo1Goles,equipo2Goles); 
				
				
					String resultado1="EMPATE";
					String resultado2="EMPATE";		
					if (rondaPartido[i].getGolesEquipo1()>rondaPartido[i].getGolesEquipo2())
						{resultado1 = "GANA";resultado2 = "PIERDE";}                       //		SISTEMA DE PUNTUACION
					if (rondaPartido[i].getGolesEquipo1()<rondaPartido[i].getGolesEquipo2())
						{resultado1 = "PIERDE";resultado2 = "GANA"	;}       
					
					else { resultado1="EMPATE";
						  resultado2="EMPATE";	}
					;
						
						resultadoEnumRondaPartido[i]=new ResultadoEnum(resultado1,resultado2);
					
						
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
		

		   
		   // ahora lectura y calcuo de apuesta
		   
		   
		   
			              //
			Pronostico pronostico[] = new Pronostico[2];
			
			
			
			try {
				int i=0;
				List<String> lineas = Files.readAllLines(Paths.get("C:\\Users\\Notebook\\Desktop\\FRAN\\AP40\\Workspace\\TPI\\src\\modelo\\pronosticos.csv"), Charset.forName("ISO-8859-1"));
				lineas.remove(0);
				for(String linea :lineas)			
				 {
					
				            
				   //String equipo1NombreTiket  = linea.split(";")[0]; 
				   //String equipo2NombreTiket  = linea.split(";")[5]; 
				   String gana1          = linea.split(";")[2];
				   String empata           = linea.split(";")[3];
				   String gana2           = linea.split(";")[4];
				   
					//Equipo equipo1tiket = new Equipo(equipo1NombreTiket,"");              //
					//Equipo equipo2tiket = new Equipo(equipo2NombreTiket,"");              //modificar
					
					
					//ResultadoEnum[i]= new Partido(equipo1tiket,equipo2tiket,equipo1GolesTiket,equipo2GolesTiket); //falta armar el partido

					String resultado1="EMPATE";
					String resultado2="EMPATE";	
				    ResultadoEnum apuesta = new ResultadoEnum();
					Equipo eganador =null;
						
					if (gana2.isEmpty())
						{resultado1 = "GANA";resultado2 = "PIERDE";eganador = rondaPartido[i].getEquipo1();}                       //		SISTEMA DE PUNTUACION
					if (gana1.isEmpty())
						{resultado1 = "PIERDE";resultado2 = "GANA";eganador = rondaPartido[i].getEquipo2();}                      
					else { resultado1="EMPATE";resultado2="EMPATE";	}
					
					apuesta.setResultadoEqu1(resultado1);
					apuesta.setResultadoEqu2(resultado2);
					
					pronostico[i]=new Pronostico(apuesta,rondaPartido[i], eganador );
					pronostico[i]=new Pronostico(apuesta,rondaPartido[i], eganador );
					
				   i=i+1;
				  }
				   
				  
				 } 
				 catch (IOException e) {
				  e.printStackTrace();
				 }
			   System.out.println("---------");
			   System.out.println("apuestas");
			   System.out.println("---------");
			   System.out.println(pronostico[0].getPartido().getEquipo1().getEquipo());
			   System.out.println(pronostico[0].getPartido().getGolesEquipo1());
			   System.out.println(pronostico[0].getPartido().getEquipo2().getEquipo());
			   System.out.println(pronostico[0].getPartido().getGolesEquipo2());
			   System.out.println(pronostico[1].getPartido().getEquipo1().getEquipo());
			   System.out.println(pronostico[1].getPartido().getGolesEquipo1());
			   System.out.println(pronostico[1].getPartido().getEquipo2().getEquipo());
			   System.out.println(pronostico[1].getPartido().getGolesEquipo2());
			   System.out.println("---------");
			   System.out.println("aciertos:");
		   	
			 
			int aciertos=0;

					for(int index=0; index<rondaPartido.length;index++)			//lectura de datos del partido, del equipo1 
									{
						
				if (     resultadoEnumRondaPartido[index].getResultadoEqu1() == pronostico[index].getResultadoApuesta().getResultadoEqu1()  ||     resultadoEnumRondaPartido[index].getResultadoEqu2() == pronostico[index].getResultadoApuesta().getResultadoEqu2()  )
							    aciertos=aciertos+1;   
										
															} System.out.println(aciertos);
 
			
	}

	
}
