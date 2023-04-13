package main;

public class Equipo {
	
	private String equipo;
	private String descripcion;
		
	public Equipo() {
	//Constructor vacio	
						}
	public Equipo(String equipo, String descripcion ) {
		
		this.equipo=equipo;
		this.descripcion= descripcion;
		
					}

	public String getEquipo() {           // 
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;						//area de get y set
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {   //
		this.descripcion = descripcion;
	}
}