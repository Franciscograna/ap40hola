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
			List<String> lineas1= null;
			String ruta1="C:\\Users\\franc\\eclipse-workspace\\Maven\\src\\main\\resultados.csv" ;
		
		   // ahora lectura apuesta		   
																			//por ahora tiene 3 objetos como resultara el partido, el partido y el "Equipo" ganador
			ArrayList<Pronostico> pronostico = new ArrayList<Pronostico>(); //clase que guarda la apuesta que debera guardar la persona
			ArrayList<Persona> personas = new ArrayList<Persona>();
			List<String> lineas2 = null;
			String ruta2="C:\\Users\\franc\\eclipse-workspace\\Maven\\src\\main\\pronosticos.csv" ;			 
			  //metodos
			  leerresultados(ResultadoEnumRondaPartido,rondaPartido, rondasPartido ,lineas1,ruta1);
			  
			  leerpronostico(personas, pronostico,lineas2,ruta2);
			  
			  calcularPuntajes( personas,  pronostico,  rondasPartido,  ResultadoEnumRondaPartido) ;
					
	}

	
	
	
	
	
	
	
	
	
	private static void leerresultados(ArrayList<ResultadoEnum> ResultadoEnumRondaPartido,ArrayList<Partido> rondaPartido, ArrayList<Ronda> rondasPartido, List<String> lineas1,String ruta1) {
try {
			
			lineas1 = Files.readAllLines(Paths.get(ruta1), Charset.forName("ISO-8859-1"));
			int i=0;lineas1.remove(0);
			for(String linea :lineas1)	//loop de lectura		
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
			addPartido.setEquipo1(equipo1Result);addPartido.setEquipo2(equipo2Result);addPartido.setGolesEquipo1(equipo2Goles);addPartido.setGolesEquipo2(equipo2Goles);
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
		   System.out.println("          ");
		  for(int indice=0; indice<ResultadoEnumRondaPartido.size();indice++) {
		   System.out.println("R: "+rondasPartido.get(indice).getNro()+"  "+rondasPartido.get(indice).getPartido().getEquipo1().getEquipo()+"  "+ResultadoEnumRondaPartido.get(indice).getResultadoEqu1()+"  "+rondasPartido.get(indice).getPartido().getEquipo2().getEquipo()+"  "+ResultadoEnumRondaPartido.get(indice).getResultadoEqu2());}
		   System.out.println("                                                                                                          ");
		   	
		
	}



	private static void leerpronostico(ArrayList<Persona> personas, ArrayList<Pronostico> pronostico,List<String> lineas2,String ruta2) {
		try {

			
			lineas2 = Files.readAllLines(Paths.get(ruta2), Charset.forName("ISO-8859-1"));
			int i=0;lineas2.remove(0);
			
			for(String linea :lineas2)			
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
		   System.out.println("        ");
		   for (int indice2 =0; indice2<pronostico.size();indice2++) {
		   System.out.println(pronostico.get(indice2).getPartido().getEquipo1().getEquipo()+ " "+pronostico.get(indice2).getPartido().getEquipo2().getEquipo()+" "+pronostico.get(indice2).getPersona().getNombre()+" "+pronostico.get(indice2).getResultadoApuesta().getResultadoEqu1()+" "+pronostico.get(indice2).getResultadoApuesta().getResultadoEqu2());
		   }
		   System.out.println("---------");

		
	}

	
	
	
	private static void calcularPuntajes(ArrayList<Persona> personas, ArrayList<Pronostico> pronostico,ArrayList<Ronda> rondasPartido, ArrayList<ResultadoEnum> ResultadoEnumRondaPartido) {
		for ( int idx=0; idx<personas.size();idx++) {
		   /*System.out.println("llegue 1")*/; int p = 0;         //reseteo el contador al pasar a otra pesona
		   for ( int idx2=0; idx2<pronostico.size();idx2++) {
			   //System.out.println("llegue 2");
			   for( int idx3=0; idx3<rondasPartido.size();idx3++) { 
				   //System.out.println("llegue 3");
				   if ( personas.get(idx).getNombre().equals(pronostico.get(idx2).getPersona().getNombre())) { 
					   //System.out.println("llegue 3");
					   if( pronostico.get(idx2).getPartido().getEquipo1().getEquipo().equals(rondasPartido.get(idx3).getPartido().getEquipo1().getEquipo()  )  ) {
						   //System.out.println("llegue 4");
						   if( pronostico.get(idx2).getPartido().getEquipo2().getEquipo().equals(rondasPartido.get(idx3).getPartido().getEquipo2().getEquipo()  ))   {
							   //System.out.println("llegue 5");
							   if(pronostico.get(idx2).getResultadoApuesta().getResultadoEqu1().equals(ResultadoEnumRondaPartido.get(idx3).getResultadoEqu1()   )  ) {
								   //System.out.println("llegue 6"); 
								   if(pronostico.get(idx2).getResultadoApuesta().getResultadoEqu2().equals(ResultadoEnumRondaPartido.get(idx3).getResultadoEqu2()  )   ){
									   //System.out.println("llegue 7"); 
									   p=personas.get(idx).getPuntos()+1; ;personas.get(idx).setPuntos(p);                 //doy el punto e incremento 
									   
									   
									   											   }		}		}		}		}		}		}		} 

	   																																									
	 
	   				
		
		for ( int index3 =0; index3<personas.size();index3++)
		{System.out.println("nombre:  "+ personas.get(index3).getNombre()  +" puntos: "+    personas.get(index3).getPuntos()              );} 
		
	}



	
		
	}

