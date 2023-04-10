package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Persona> personas = new ArrayList <Persona>();
		
		for (int i=0;i<100; i++)													
		{
			
		Scanner s1 = new Scanner(System.in);
	    System.out.print("Ingrese Nombre ");
	    String name = s1.next(); 
		
	    Scanner s2 = new Scanner(System.in);
	    System.out.print("Ingrese Apellido ");
	    String surname = s2.next(); 
	    
	    Scanner s3 = new Scanner(System.in);
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    System.out.print("Ingrese Fecha de Nacimiento DD/MM/AAAA ");
	    LocalDate fech = LocalDate.parse(s3.next(),formatter);
	    
	    Scanner s4 = new Scanner(System.in);
	    System.out.print("aLMACENAR ESTOS DATOS? si/no");
	    String save = s4.next();							
	    if (save.equals("si")) {
	    Persona persona = new Persona();
	    persona.setName(name);
	    persona.setSurname(surname);
	    persona.setBorn(fech);
	    personas.add(persona);
	    						}
	    Scanner s5 = new Scanner(System.in);
	    System.out.print("Fin del programa? si/no");
	    String fin = s5.next();							if (fin.equals("si")) {i=100;}
		}
		Scanner s6 = new Scanner(System.in);
	    System.out.print("desea ver los datos ingresados? si/no");
	    String show = s6.next();						
	    if (show.equals("si"))
	    		{ 
	    	for (int index=0;index<personas.size(); index++)
	    	System.out.print("nombre: "+personas.get(index).getName()+"apellido: "+" "+personas.get(index).getSurname()+" "+"Nacido: "+personas.get(index).getBorn() );   
	    					}
		
	}
}
