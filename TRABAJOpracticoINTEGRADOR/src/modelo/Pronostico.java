package modelo;


import modelo.Partido;
import modelo.ResultadoEnum;


public class Pronostico {

	
	private Equipo equipo;
	private Partido partido[];
	private ResultadoEnum resultado;
	
	
	public Pronostico() {
	}
	public Pronostico(Equipo equipo, Partido partido[]) {
			this.partido = partido;
			this.equipo = equipo;
			this.resultado = resultado;
	}
	
	
	
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public Partido[] getPartido() {
		return partido;
	}
	public void setPartido(Partido[] partido) {
		this.partido = partido;
	}
	
	
	
	public int apuesta( Partido partido[]) {        	    // Comparacion entre tiket y resultado
		int tiketJugador = 0;                              // variable provisoria despues aca se lee la apuesta
		Partido partid = new Partido(); 		  //para poder ingresar al metodo resultado
		int count=0;
		for (int i =0; i<partido.length;i++) {
			
			if (partido[i].resultado(partid.getGolesEquipo1(),partid.getGolesEquipo2())== tiketJugador)  {     // comparara si el equipo1 es 3(ganador), 1(empatador) o 0(perdedor) 
			count=count+1;
			
			}		
	
		}
		return count;
				
	}
		
}
