package Modelo;

public class DescuentoPorcentajeConTope extends Descuento {
	private double tope=400;    // pruebo tope


	public double getTope() {
		return tope;
	}
	public void setTope(double tope) {
		this.tope = tope;
	}
	
	@Override	
	
	
		public double valorFinal(double valorInicial) {
		if (valorInicial > tope) {
		return ( valorInicial - (valorInicial *this.getValorDesc()));
									}	
		else {
			return valorInicial;
					}
	
	
	}
	
	
}
