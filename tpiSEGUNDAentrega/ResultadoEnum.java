package main;

public class ResultadoEnum {
	
	private String ResultadoEqu1;   //ganador perdedor empate
	private String ResultadoEqu2;   //ganador perdedor empate
	
	
	public ResultadoEnum(String ResultadoEqu1,String ResultadoEqu2) {
	this.ResultadoEqu1 = ResultadoEqu1;
	this.ResultadoEqu2 = ResultadoEqu1;
	}

	public String getResultadoEqu1() {
		return ResultadoEqu1;
	}


	public void setResultadoEqu1(String resultadoEqu1) {
		this.ResultadoEqu1 = resultadoEqu1;
	}


	public String getResultadoEqu2() {
		return ResultadoEqu2;
	}


	public void setResultadoEqu2(String resultadoEqu2) {
		this.ResultadoEqu2 = resultadoEqu2;
	}
	
	
	
	
	
	
	

}
