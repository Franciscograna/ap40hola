package modelo;

public class Pronostico {
	private ResultadoEnum resultadoApuesta;
	private Partido partido;
	private Equipo equipo;
	
	public Pronostico () {	
	}

	public Pronostico ( ResultadoEnum resultadoApuesta, Partido partido, Equipo equipo) {
		this.resultadoApuesta=resultadoApuesta;
		this.equipo=equipo;
		this.partido=partido;
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

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	
	
}
