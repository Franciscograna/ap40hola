package main;
import java.util.regex.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ronda {

	
	private int nro;
	private Partido Partido;
	
	
	public Ronda() {	
		
	}
	
	public Ronda(int nro,Partido Partido) {
		this.nro=nro;
		this.Partido=Partido;
		
	}

	
	
	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public Partido getPartido() {
		return Partido;
	}

	public void setPartido(Partido partido) {
		Partido = partido;
	}


	
	
	
public static void leerresultados(ArrayList<ResultadoEnum> ResultadoEnumRondaPartido, ArrayList<Ronda> rondasPartido, Connection con) {
try {
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from tabla_goles");
	String regex1 = "^[a-zA-Z ]{4,20}$"; //nombres
	final Pattern pattern1 = Pattern.compile(regex1);
	String regex2 = "[0-9]{1,2}";          //enteros
	final Pattern pattern2 = Pattern.compile(regex2);
	String lectura; 
	
	
	
	
	while(rs.next())	//loop de lectura		
	 { 
		//-----------------------------------------//
		lectura        = rs.getString(2);  //leo nombre 
	 	if (  pattern2.matcher(lectura).matches()  ) {
		}else {System.out.println("error de lectura");}
	 		
		int    nroRonda       =  Integer.parseInt(lectura);
		
		//---------------------------------------//
		
		
		lectura        = rs.getString(3);  
	 	if (  pattern1.matcher(lectura).matches()  ) {
		}else {System.out.println("error de lectura");}
		
	    String equipo1Nombre  = lectura;    
	    
	    //---------------------------------------//
	    
	    
	    lectura        = rs.getString(6);  
	 	if (  pattern1.matcher(lectura).matches()  ) {
		}else {System.out.println("error de lectura");}
	    
	    String equipo2Nombre  =lectura; 
	   
	    
	    //---------------------------------//
	    
	    
	    lectura        = rs.getString(4);  
	 	if (  pattern2.matcher(lectura).matches()  ) {
		}else {System.out.println("error de lectura");}
	    
	   
	    int    equipo1Goles   = Integer.parseInt(lectura);
	    
	   //-----------------------------------------------//
	    
	    lectura        = rs.getString(5);  
	 	if (  pattern2.matcher(lectura).matches()  ) {
		}else {System.out.println("error de lectura");}
	    
	    int    equipo2Goles   = Integer.parseInt(lectura);
	    
	    //---------------------------------------------//
		Equipo equipo1Result = new Equipo(equipo1Nombre,"");  Equipo equipo2Result = new Equipo(equipo2Nombre,"");
																					//
		String resultado1="EMPATE";								String resultado2="EMPATE";		
		if (equipo1Goles!=equipo2Goles)												//
		 	{																		//
					if (equipo1Goles>equipo2Goles)									//
							{resultado1 = "GANA";resultado2 = "PIERDE";}            //		SISTEMA DE PUNTUACION
					if (equipo1Goles<equipo2Goles)
							{resultado1 = "PIERDE";resultado2 = "GANA"	;}       
				;}
		
	//para añadir a la lista de partido y a la lista de resulltadoEnum  creo ua variable intermadia y esa deespues la añado
	Partido addPartido = new Partido(equipo1Result, equipo2Result, equipo1Goles, equipo2Goles); 
	addPartido.setEquipo1(equipo1Result);addPartido.setEquipo2(equipo2Result);addPartido.setGolesEquipo1(equipo2Goles);addPartido.setGolesEquipo2(equipo2Goles);
	//rondaPartido.add(addPartido);
	
	Ronda addRonda = new Ronda(nroRonda,addPartido );              //en vez re addPartido 
	addRonda.setNro(nroRonda); addRonda.setPartido(addPartido);    //ponia rondaPartido.get(i) 
	rondasPartido.add(addRonda);
	
	
	ResultadoEnum resultados= new ResultadoEnum(resultado1,resultado2); //
	resultados.setResultadoEqu1(resultado1);resultados.setResultadoEqu2(resultado2);       //  seteo, tome como referencia
	ResultadoEnumRondaPartido.add(resultados);													//
				
			
	
		}
} catch (SQLException e) {
	System.out.println("error SQL...");
	e.printStackTrace();
}
	   System.out.println("---------");
	   System.out.println("resultados");
	   System.out.println("          ");
	  for(int indice=0; indice<ResultadoEnumRondaPartido.size();indice++) {
	   System.out.println("R: "+rondasPartido.get(indice).getNro()+"  "+rondasPartido.get(indice).getPartido().getEquipo1().getEquipo()+"  "+ResultadoEnumRondaPartido.get(indice).getResultadoEqu1()+"  "+rondasPartido.get(indice).getPartido().getEquipo2().getEquipo()+"  "+ResultadoEnumRondaPartido.get(indice).getResultadoEqu2());}
	   System.out.println("                                                                                                          ");
	   	
	
	}


	

	
}