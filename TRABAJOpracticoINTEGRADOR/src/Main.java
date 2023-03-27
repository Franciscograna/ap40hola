package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import modelo.Equipo;
import modelo.Partido;


public class Main {
	

	
	public static void main(String[] args) {
		
		BufferedReader bufferLectura = null;
		Partido partido[] = new Partido[2];
		Partido tiketJugador[] = new Partido[2];

		Equipo equipo1tiket = new Equipo();
		Equipo equipo2tiket = new Equipo();
		
		
		try {
			  // Abrir el .csv en buffer de lectura
			  bufferLectura = new BufferedReader(new FileReader("C:\\Users\\Notebook\\Desktop\\FRAN\\AP40\\Workspace\\TPI\\src\\modelo\\resultados.csv"));
			  
			  // Leer una linea del archivo
			  
			  String linea = bufferLectura.readLine();
			
			  while (linea != null) {
				  int i=0;
			   // Sepapar la linea leída con el separador definido previamente
			   String equipo1Nombre  = linea.split(";")[0]; 
			   String equipo2Nombre  = linea.split(";")[2]; 
			   int equipo1Goles  = Integer.parseInt(linea.split(";")[1]);
			   int equipo2Goles  = Integer.parseInt(linea.split(";")[3]);
			   
				Equipo equipo1Result = new Equipo(equipo1Nombre,"");
				Equipo equipo2Result = new Equipo(equipo2Nombre,"");
				
				partido[i]= new Partido(equipo1Result,equipo2Result,equipo1Goles,equipo2Goles);
			   
			   System.out.println(partido);   // viendo si guarda y muestra
			   
			   // Volver a leer otra línea del fichero
			   linea = bufferLectura.readLine();
			   i++;
			  }
			  
			 	  
			  
			 } 
			 catch (IOException e) {
			  e.printStackTrace();
			 }
			 finally {
			  // Cierro el buffer de lectura
			  if (bufferLectura != null) {
			   try {
			    bufferLectura.close();
			   } 
			   catch (IOException e) {
			    e.printStackTrace();
			   }
			  }
			 }
	}
		
}	

