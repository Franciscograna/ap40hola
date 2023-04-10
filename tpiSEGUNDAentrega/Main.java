package main;
import java.nio.charset.Charset;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
		//Lectura del archivo de resultados// 
		ArrayList<ResultadoEnum> ResultadoEnumRondaPartido = new ArrayList<ResultadoEnum>(); // clase que guarda el resultado de eq1,eq2( agregue objeto para tener mas info)
		ArrayList<Partido>       rondaPartido              = new ArrayList<Partido>();
		ArrayList<Ronda>         rondasPartido             = new ArrayList<Ronda>();  //clase que guarda la clase partido y el numero de ronda
		try {
			int i=0;
			List<String> lineas = Files.readAllLines(Paths.get("C:\\Users\\franc\\eclipse-workspace\\Maven\\src\\main\\resultados.csv"), Charset.forName("ISO-8859-1"));
			lineas.remove(0);
			for(String linea :lineas)	//loop de lectura		
			 { 
				int    nroRonda       = Integer.parseInt(linea.split(";")[0]);    //guardo valores del csv en variables       
			    String equipo1Nombre  = linea.split(";")[1]; 
			    String equipo2Nombre  = linea.split(";")[4]; 
			    int    equipo1Goles   = Integer.parseInt(linea.split(";")[2]);
			    int    equipo2Goles   = Integer.parseInt(linea.split(";")[3]);
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
		   System.out.println(ResultadoEnumRondaPartido.get(2).getResultadoEqu1()+"  "+ResultadoEnumRondaPartido.get(2).getResultadoEqu2());
		   System.out.println(ResultadoEnumRondaPartido.get(3).getResultadoEqu1()+"  "+ResultadoEnumRondaPartido.get(3).getResultadoEqu2());
		   System.out.println("                                                                                                          ");
		   
		   // ahora lectura apuesta
		   
																			//por ahora tiene 3 objetos como resultara el partido, el partido y el "Equipo" ganador
			ArrayList<Pronostico> pronostico = new ArrayList<Pronostico>(); //clase que guarda la apuesta que debera guardar la persona
			ArrayList<Persona> personas = new ArrayList<Persona>();
			try {

				int i=0;
				List<String> lineas = Files.readAllLines(Paths.get("C:\\Users\\franc\\eclipse-workspace\\Maven\\src\\main\\pronosticos.csv"), Charset.forName("ISO-8859-1"));
				lineas.remove(0);
				
				for(String linea :lineas)			
				 { 
					String persona        = linea.split(";")[0];  //leo nombre 
					Persona personaAdd = new Persona(persona,0); // para agregar persona
					
					if (i==0) {
						personaAdd.setNombre(persona); personaAdd.setPuntos(0);personas.add(personaAdd); //agrego persona
						
					}
					else  { int censo =0;
						for(int j=0; j<personas.size();j++)
							{
								if (personas.get(j).getNombre().equals(personaAdd.getNombre())) 	
									{	 
										censo=censo+1;} 
										}
						if (censo==0) {personaAdd.setNombre(persona); personaAdd.setPuntos(0);personas.add(personaAdd);}// si no lo encuentro lo agrego
						}
					
						 								
					  //la guardo para cargar en el pronostico
					 
					String resultado1a    = "EMPATE";  //leo y guardo valores
					String resultado2a    = "EMPATE";
				    String gana1          = linea.split(";")[2];
				    String empata         = linea.split(";")[3];
				    String gana2          = linea.split(";")[4];
				    String equipA1          = linea.split(";")[1];
				    String equipA2          = linea.split(";")[5];
				    Equipo equipoA1 = new Equipo(equipA1,"");                        // armo partido
				    Equipo equipoA2 = new Equipo(equipA2,"");						//
				    Partido partAdd = new Partido (equipoA1,equipoA2,0 ,0);			//
				   
				   
				   if (!empata.isEmpty())  {resultado1a="EMPATE";resultado2a="EMPATE";} //si no esta vacio es empate hay "x"
				   else {
					   	if (gana2.isEmpty()&&empata.isEmpty()) // e2 vacio gana e1
						{resultado1a = "GANA";resultado2a = "PIERDE";}                       //		SISTEMA DE PUNTUACION
					   	else
						{resultado1a = "PIERDE";resultado2a = "GANA";}                      
				   		}
				   
				   	//variables intermedias para crear la lista pronostico y resultadoenum(delaapuesta)
					ResultadoEnum apuesta = new ResultadoEnum(resultado1a,resultado2a);  //armo clases y las añado a la lista
					apuesta.setResultadoEqu1(resultado1a);//ok
					apuesta.setResultadoEqu2(resultado2a);	   
					Pronostico pronosticoAdd= new Pronostico(apuesta, partAdd,personaAdd); //hay 4 partidos y 8 apuestas
					pronosticoAdd.setResultadoApuesta(apuesta);//ok 							
					pronosticoAdd.setPartido(partAdd);// el partido ya lo tenia el real, aunque se podria formar aqui
					pronosticoAdd.setPersona(personaAdd);
					pronostico.add(pronosticoAdd);
					
				   i=i+1;
				   
				  }
				   
				  
				 } 
				 catch (IOException e) {
				  e.printStackTrace();
				 }
			   System.out.println("---------");
			   System.out.println("apuestas");
			   System.out.println("---------");
			   System.out.println(pronostico.get(0).getPartido().getEquipo1().getEquipo()+ " "+pronostico.get(0).getPartido().getEquipo2().getEquipo()+pronostico.get(0).getPersona().getNombre()+" "+pronostico.get(0).getResultadoApuesta().getResultadoEqu1()+" "+pronostico.get(0).getResultadoApuesta().getResultadoEqu2());
			   System.out.println(pronostico.get(1).getPartido().getEquipo1().getEquipo()+ " "+pronostico.get(1).getPartido().getEquipo2().getEquipo()+pronostico.get(1).getPersona().getNombre()+" "+pronostico.get(1).getResultadoApuesta().getResultadoEqu1()+" "+pronostico.get(1).getResultadoApuesta().getResultadoEqu2());
			   System.out.println(pronostico.get(2).getPartido().getEquipo1().getEquipo()+ " "+pronostico.get(2).getPartido().getEquipo2().getEquipo()+pronostico.get(2).getPersona().getNombre()+" "+pronostico.get(2).getResultadoApuesta().getResultadoEqu1()+" "+pronostico.get(2).getResultadoApuesta().getResultadoEqu2());
			   System.out.println(pronostico.get(3).getPartido().getEquipo1().getEquipo()+ " "+pronostico.get(3).getPartido().getEquipo2().getEquipo()+pronostico.get(3).getPersona().getNombre()+" "+pronostico.get(3).getResultadoApuesta().getResultadoEqu1()+" "+pronostico.get(3).getResultadoApuesta().getResultadoEqu2());
			   System.out.println(pronostico.get(4).getPartido().getEquipo1().getEquipo()+ " "+pronostico.get(4).getPartido().getEquipo2().getEquipo()+pronostico.get(4).getPersona().getNombre()+" "+pronostico.get(4).getResultadoApuesta().getResultadoEqu1()+" "+pronostico.get(4).getResultadoApuesta().getResultadoEqu2());
			   System.out.println(pronostico.get(5).getPartido().getEquipo1().getEquipo()+ " "+pronostico.get(5).getPartido().getEquipo2().getEquipo()+pronostico.get(5).getPersona().getNombre()+" "+pronostico.get(5).getResultadoApuesta().getResultadoEqu1()+" "+pronostico.get(5).getResultadoApuesta().getResultadoEqu2());
			   System.out.println(pronostico.get(6).getPartido().getEquipo1().getEquipo()+ " "+pronostico.get(6).getPartido().getEquipo2().getEquipo()+pronostico.get(6).getPersona().getNombre()+" "+pronostico.get(6).getResultadoApuesta().getResultadoEqu1()+" "+pronostico.get(6).getResultadoApuesta().getResultadoEqu2());
			   System.out.println(pronostico.get(7).getPartido().getEquipo1().getEquipo()+ " "+pronostico.get(7).getPartido().getEquipo2().getEquipo()+pronostico.get(7).getPersona().getNombre()+" "+pronostico.get(7).getResultadoApuesta().getResultadoEqu1()+" "+pronostico.get(7).getResultadoApuesta().getResultadoEqu2());
			   System.out.println("---------");
			 
			   /*

				for(int index=0; index<pronostico.size();index++)		
					
			   {    int p = 1;
			   		for (int index2=0; index2<rondasPartido.size();index2++) // si los equipo de las apuestas coinsiden con los equipos de los resultados reales  ( se podria agregar ronda )
			   			{
				   			
				   		if ( pronostico.get(index).getResultadoApuesta().getResultadoEqu1().equals(ResultadoEnumRondaPartido.get(index2).getResultadoEqu1())     &&  pronostico.get(index).getResultadoApuesta().getResultadoEqu2().equals(ResultadoEnumRondaPartido.get(index2).getResultadoEqu2())  ) 
				   		if ( pronostico.get(index).getPartido().getEquipo1().getEquipo().equals(rondasPartido.get(index2).getPartido().getEquipo1().getEquipo()) && pronostico.get(index).getPartido().getEquipo2().getEquipo().equals(rondasPartido.get(index2).getPartido().getEquipo2().getEquipo()) )		 	 
				   																													
				   					
				   			{	
				   				if (		personas.contains(     personas.get(	personas.indexOf (pronostico.get(index).getPersona())		)		)	)   { 
				   					int señaloPersona =              personas.indexOf (pronostico.get(index).getPersona());   				
				   					personas.get( señaloPersona  ).setPuntos(p);     
				   					System.out.println(p + "primer punto, dentro 2do loop nombre:  "+ personas.get(señaloPersona).getNombre()  +" puntos: "+    personas.get(señaloPersona).getPuntos()   );
				   					p=personas.get(señaloPersona).getPuntos()+1;
				   					
				   				
				   				}
				   			}
				   	 										
				   					System.out.println(p +" dentro del primer loop " + personas.get(personas.indexOf (pronostico.get(index).getPersona())).getNombre()  +" puntos: "+    personas.get(personas.indexOf (pronostico.get(index).getPersona())).getPuntos() );	//p++;	
				   				
						  }
				}		
				
				
				
			
				*/
			   
			   
			   for ( int idx=0; idx<personas.size();idx++) {
				   System.out.println("llegue 1");int p = 0;         //reseteo el contador al pasar a otra pesona
				   for ( int idx2=0; idx2<pronostico.size();idx2++) {
					   System.out.println("llegue 2");
					   for( int idx3=0; idx3<rondasPartido.size();idx3++) { 
						   System.out.println("llegue 3");
						   if ( personas.get(idx).getNombre().equals(pronostico.get(idx2).getPersona().getNombre())) { 
							   System.out.println("llegue 3");
							   if( pronostico.get(idx2).getPartido().getEquipo1().getEquipo().equals(rondasPartido.get(idx3).getPartido().getEquipo1().getEquipo()  )  ) {
								   System.out.println("llegue 4");
								   if( pronostico.get(idx2).getPartido().getEquipo2().getEquipo().equals(rondasPartido.get(idx3).getPartido().getEquipo2().getEquipo()  ))   {
									   System.out.println("llegue 5");
									   if(pronostico.get(idx2).getResultadoApuesta().getResultadoEqu1().equals(ResultadoEnumRondaPartido.get(idx3).getResultadoEqu1()   )  ) {
										   System.out.println("llegue 6"); 
										   if(pronostico.get(idx2).getResultadoApuesta().getResultadoEqu2().equals(ResultadoEnumRondaPartido.get(idx3).getResultadoEqu2()  )   ){
											   System.out.println("llegue 7"); p=personas.get(idx).getPuntos()+1; ;personas.get(idx).setPuntos(p);                 //doy el punto y incremento para la proxima coincidencia
											   
											   
											   											   }		}		}		}		}		}		}		}
			 
			   				
				
				for ( int index3 =0; index3<personas.size();index3++)
				{System.out.println("nombre:  "+ personas.get(index3).getNombre()  +" puntos: "+    personas.get(index3).getPuntos()              );}
				
	}

	
}