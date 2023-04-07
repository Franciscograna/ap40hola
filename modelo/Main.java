package modelo;
import java.nio.charset.Charset;
import java.util.List;
import java.util.ArrayList;
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
import modelo.Ronda;

public class Main {
	public static void main(String[] args) {
		//Lectura del archivo de resultados// 
		ArrayList<ResultadoEnum> ResultadoEnumRondaPartido = new ArrayList<ResultadoEnum>(); // clase que guarda el resultado de eq1,eq2( agregue objeto para tener mas info)
		ArrayList<Partido> rondaPartido = new ArrayList<Partido>();
		ArrayList<Ronda> rondasPartido = new ArrayList<Ronda>();  //clase que guarda la clase partido y el numero de ronda
		try {
			int i=0;
			List<String> lineas = Files.readAllLines(Paths.get("C:\\Users\\Notebook\\Desktop\\FRAN\\AP40\\Workspace\\TPI\\src\\modelo\\resultados.csv"), Charset.forName("ISO-8859-1"));
			lineas.remove(0);
			for(String linea :lineas)	//loop de lectura		
			 { 
				int nroRonda  = Integer.parseInt(linea.split(";")[0]);    //guardo valores del csv en variables       
			    String equipo1Nombre  = linea.split(";")[1]; 
			    String equipo2Nombre  = linea.split(";")[4]; 
			    int equipo1Goles  = Integer.parseInt(linea.split(";")[2]);
			    int equipo2Goles  = Integer.parseInt(linea.split(";")[3]);
			    															// armo las clases equipo con los Strings leidos
				Equipo equipo1Result = new Equipo(equipo1Nombre,"");  Equipo equipo2Result = new Equipo(equipo2Nombre,"");
																							//
				String resultado1="EMPATE";								String resultado2="EMPATE";		
				if (equipo1Goles!=equipo2Goles)												//
				 	{																		//
							if (equipo1Goles>equipo2Goles)									//
									{resultado1 = "GANA";resultado2 = "PIERDE";}            //		SISTEMA DE PUNTUACION
							if (equipo1Goles<equipo2Goles)
									{resultado1 = "PIERDE";resultado2 = "GANA"	;}       
						;}
				
			//para añadir a la lista de partido y a la lista de resulltadoEnum  creo ua variable intermadia y esa deespues la añado
			Partido addPartido = new Partido(equipo1Result, equipo2Result, equipo1Goles, equipo2Goles); 
			addPartido.setEquipo1(equipo1Result);addPartido.setEquipo2(equipo2Result);addPartido.setGolesEquipo1(equipo1Goles);addPartido.setGolesEquipo1(equipo1Goles);
			rondaPartido.add(addPartido);
			//rondaPartido.add(new Partido(equipo1Result, equipo2Result, equipo1Goles, equipo2Goles));  //antes creaba mediante constructor 	
			
			Ronda addRonda = new Ronda(nroRonda,rondaPartido.get(i) );
			addRonda.setNro(nroRonda); addRonda.setPartido(rondaPartido.get(i));
			rondasPartido.add(addRonda);
			
			//rondasPartido.add(new Ronda(nroRonda, rondaPartido.get(i)));  							//antes creaba mediante constructor
			ResultadoEnum resultados= new ResultadoEnum(resultado1,resultado2); //
			resultados.setResultadoEqu1(resultado1);resultados.setResultadoEqu2(resultado2);       //  seteo, tome como referencia
			ResultadoEnumRondaPartido.add(resultados);													//
						
					 i=i+1;
			
				}
			 } 
			 catch (IOException e) {
			  e.printStackTrace();
			 }
		   System.out.println("---------");
		   System.out.println("resultados");
		   System.out.println("---------");
		   System.out.println(ResultadoEnumRondaPartido.get(0).getResultadoEqu1()+"  "+ResultadoEnumRondaPartido.get(0).getResultadoEqu2());
		   System.out.println(ResultadoEnumRondaPartido.get(1).getResultadoEqu1()+"  "+ResultadoEnumRondaPartido.get(1).getResultadoEqu2());
		   System.out.println(ResultadoEnumRondaPartido.get(2).getResultadoEqu2()+"  "+ResultadoEnumRondaPartido.get(2).getResultadoEqu1());
		   System.out.println(ResultadoEnumRondaPartido.get(3).getResultadoEqu2()+"  "+ResultadoEnumRondaPartido.get(3).getResultadoEqu1());
		   System.out.println("                               ");
		   
		   // ahora lectura apuesta
		   
																			//por ahora tiene 3 objetos como resultara el partido, el partido y el "Equipo" ganador
			ArrayList<Pronostico> pronostico = new ArrayList<Pronostico>(); //clase que guarda la apuesta que debera guardar la persona
		    
			try {

				int i=0;
				List<String> lineas = Files.readAllLines(Paths.get("C:\\Users\\Notebook\\Desktop\\FRAN\\AP40\\Workspace\\TPI\\src\\modelo\\pronosticos.csv"), Charset.forName("ISO-8859-1"));
				lineas.remove(0);
				for(String linea :lineas)			
				 {
					String resultado1a = "EMPATE";  //leo y guardo valores
					String resultado2a = "EMPATE";
					String persona       = linea.split(";")[0];    //falta esto // NO LEO EQUIPO, SUGERENCIAS?
				   String gana1          = linea.split(";")[2];
				   String empata         = linea.split(";")[3];
				   String gana2          = linea.split(";")[4];
				   Equipo eganador =null;
				   if (!empata.isEmpty())  {resultado1a="EMPATE";resultado2a="EMPATE";} //si no esta vacio es empate hay "x"
				   else {
					   	if (gana2.isEmpty()&&empata.isEmpty()) // e2 vacio gana e1
						{resultado1a = "GANA";resultado2a = "PIERDE";eganador = rondaPartido.get(i).getEquipo1();}                       //		SISTEMA DE PUNTUACION
					   	else
						{resultado1a = "PIERDE";resultado2a = "GANA";eganador = rondaPartido.get(i).getEquipo2();}                      
				   		}
				   	//variables intermedias para crear la lista pronostico y resultadoenum(delaapuesta)
					ResultadoEnum apuesta = new ResultadoEnum(resultado1a,resultado2a);  //armo clases y las añado a la lista
					apuesta.setResultadoEqu1(resultado1a);//ok
					apuesta.setResultadoEqu2(resultado2a);	   
					Pronostico pronosticoAdd= new Pronostico(apuesta, rondaPartido.get(i),eganador);
					pronosticoAdd.setResultadoApuesta(apuesta);//ok 							
					pronosticoAdd.setPartido(rondaPartido.get(i));// el partido ya lo tenia, aunque se podria formar aqui
					pronosticoAdd.setEquipo(eganador);
					pronostico.add(pronosticoAdd);
					System.out.println("---?---"+ pronostico.get(i).getResultadoApuesta().getResultadoEqu1() +"---"+pronostico.get(i).getResultadoApuesta().getResultadoEqu2());
				   i=i+1;// DA ERROR PERO ALMENOS SE VE LO QUE SE CARGA DE APUESTA POR QUE FALTA DISCRIMINAR APUESTAS POR PERSONA
				  }
				   
				  
				 } 
				 catch (IOException e) {
				  e.printStackTrace();
				 }
			   System.out.println("---------");
			   System.out.println("apuestas");
			   System.out.println("---------");
			   System.out.println(pronostico.get(0).getResultadoApuesta().getResultadoEqu1());
			   System.out.println(pronostico.get(1).getResultadoApuesta().getResultadoEqu1());
			   System.out.println(pronostico.get(2).getResultadoApuesta().getResultadoEqu1());
			   System.out.println(pronostico.get(3).getResultadoApuesta().getResultadoEqu1());
			   
			   System.out.println("aciertos:");
		   	
			 
			int aciertos=0;

					for(int index=0; index<rondaPartido.size();index++)			//lectura de datos del partido, del equipo1 
									{
						
				if (     ResultadoEnumRondaPartido.get(index).getResultadoEqu1() == pronostico.get(index).getResultadoApuesta().getResultadoEqu1()  ||     ResultadoEnumRondaPartido.get(index).getResultadoEqu2() == pronostico.get(index).getResultadoApuesta().getResultadoEqu2()  )
							    aciertos=aciertos+1;   
										
															} System.out.println(aciertos);
 
			
	}

	
}
