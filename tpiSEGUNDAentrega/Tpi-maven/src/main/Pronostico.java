package main;

public class Pronostico {
	private ResultadoEnum resultadoApuesta;
	private Partido partido;
	private Persona persona;
	
	public Pronostico () {	
	}

	public Pronostico ( ResultadoEnum resultadoApuesta, Partido partido,  Persona persona) {
		this.resultadoApuesta=resultadoApuesta;
		this.partido=partido;
		this.persona = persona;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public ResultadoEnum getResultadoApuesta() {
		return resultadoApuesta;
	}

	public void setResultadoApuesta(ResultadoEnum resultadoApuesta) {
		this.resultadoApuesta = resultadoApuesta;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}


	
}
