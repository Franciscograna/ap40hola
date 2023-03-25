package modelo;

import modelo.Partido;

public class Ronda {

	
	private int nro;
	private Partido Partido[];
	
	
	public Ronda() {
		
		
	}
	
	public Ronda(int nro, Partido Partido[]) {
		this.nro=nro;
		this.Partido=Partido;
		
	}

	
	
	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public Partido[] getPartido() {
		return Partido;
	}

	public void setPartido(Partido[] partido) {
		Partido = partido;
	}
	
	
	
	

	
}
