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
	
	
	

				
	}
		
}
