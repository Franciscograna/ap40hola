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
	
	
	
	public int apuesta( Partido[] partido, int tiketJugador[]) {             //array de partidos y array de partidos apostados
		tiketJugador[0] =3; 						 
		tiketJugador[1] =1; 						 //lectura del tiket de apuesta, desp se saca
		
		Partido partid = new Partido();
		int count=0;
		
			for(int i=0; i<partido.length;i++)			//lectura de datos del partido, del equipo1 
			{
		if (partido[i].resultado(partid.getGolesEquipo1(),partid.getGolesEquipo2())== tiketJugador[i]) // Comparacion entre tiket y resultado
			
			count=count+1;
			
			
	
		}
		return count; 			//cantidad de aciertos
				
	}
		
}
