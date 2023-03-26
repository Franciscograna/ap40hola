package modelo;


import modelo.Partido;
import modelo.ResultadoEnum;


public class Pronostico {

	
	private Equipo equipo;
	private Partido partido;
	private ResultadoEnum resultado;
	
	
	public Pronostico() {
	}
	public Pronostico(Equipo equipo, Partido partido, ResultadoEnum resultado) {
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
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	
	
	
	public int apuesta( Partido partido[], Partido tiketJugador[]) {             //array de partidos y array de partidos apostados
										     // usan la misma clase partido
		
		Partido partid = new Partido();
		int count=0;
		
			for(int i=0; i<partido.length;i++)			//lectura de datos del partido, del equipo1 
			{
		if (partido[i].resultado(partido[i].getGolesEquipo1(),partido[i].getGolesEquipo2())== tiketJugador[i].resultado(tiketJugador[i].getGolesEquipo1(), tiketJugador[i].getGolesEquipo1()))
			
			count=count+1;
			
			
	
		}
		return count; 			//cantidad de aciertos
				
	}
		
}
