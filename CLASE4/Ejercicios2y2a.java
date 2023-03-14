	import java.util.*;

	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
	import java.util.List;
	import java.nio.charset.Charset;
	import java.io.IOException;
	import java.nio.file.*;
	import java.lang.Integer;
	import java.lang.Iterable;

	
public class Clase4E2y2a {

	  public static void main(String[] args) throws IOException
	        {
	         Scanner sc = new Scanner(System.in);
	         System.out.print("escriba suma o producto");  
	         String operacion = sc.next();  
	         sc.close();
		  
	         String archivo = "C:\\Users\\Notebook\\documentos\\importar.txt" ;
		  
	         Charset cs = Charset.forName("UTF-8"); 
		  
	         long resultadoS = 0;
	         long resultadoP = 1;
	     
	        if (operacion.equals("suma"))
		{	        
	        for (String linea : Files.readString(Paths.get(archivo)))
	            {
	            int numS = Integer.parseInt(linea);
	            resultadoS = resultadoS + numS;
	            }
		}
	           
	         if (operacion.equals("producto"))
	        {
	        for (String linea1 : Files.readAllLines(Paths.get(archivo)))
	            {
	            int numP = Integer.parseInt(linea1);
	            resultadoP = resultadoP * numP;
	            }
	                        
	        } 
	         
	         
	      }

}
	       
	        
	             
	        
	  
