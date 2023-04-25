package main;

import java.util.ArrayList;

public class Persona {
private String nombre;
private int puntos;
public Persona(String nombre, int puntos) {
	this.nombre = nombre;
	this.puntos = puntos;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getPuntos() {
	return puntos;
}
public void setPuntos(int puntos) {
	this.puntos = puntos;
} 


public static void calcularPuntajes(ArrayList<Persona> personas, ArrayList<Pronostico> pronostico,ArrayList<Ronda> rondasPartido, ArrayList<ResultadoEnum> ResultadoEnumRondaPartido) {
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
								   if(pronostico.get(idx2).getResultadoApuesta().getResultadoEqu2().equals("EMPATE"))
								   		{p=personas.get(idx).getPuntos()+1; ;personas.get(idx).setPuntos(p);}    //doy el punto  si empata e incremento 
								   else 
								   		{p=personas.get(idx).getPuntos()+2; ;personas.get(idx).setPuntos(p);};   //doy dos si no es empate
								   
								   
								   											   }		}		}		}		}		}		}		} 

   																																									
 
   				
	
	for ( int index3 =0; index3<personas.size();index3++)
	{System.out.println("nombre:  "+ personas.get(index3).getNombre()  +" puntos: "+    personas.get(index3).getPuntos()              );} 
	
}



}
