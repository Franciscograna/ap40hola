package Modelo;

import java.time.LocalDateTime;
import java.util.Scanner;


public class Compra {

	
	


	private LocalDateTime fechaCompra;
	private ItemCompra[] items;
	private char[] val;
	
	
	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}
	
	
		
	public Compra() {                 //constructor
	this.fechaCompra = LocalDateTime.now();
	this.items = new ItemCompra[10];  //pruebo con 10
	
		}
	
	
	public Compra(LocalDateTime fechaCompra, ItemCompra[] items) {
		
	this.fechaCompra = fechaCompra;
	this.items = items;
		
		
	}
	
	
	
	
	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	
	public ItemCompra[] getItems() {
		return items;
	}
	
	public void setItems(ItemCompra[] items) {
		this.items = items;
	}
	



	
		public double calcularTotal() {             //funcion editada del programa de la clase 5, llamo desde aqui a las clases descuento
		double total=0;
		
		Descuento desc1 = new DescuentoFijo(); 
		//Descuento desc2 = new DescuentoPorcentaje();
		Descuento desc3 = new DescuentoPorcentajeConTope();
		//leer valor
		
	
		
		//leer 
		
		Scanner sc = new Scanner(System.in);
	    System.out.print("Ingrese '%' o 'fijo': ");
	    String d = sc.next(); 
	    //sc.close();
		
	    if (d.equals("%")||d.equals("fijo"))
	    {	
	    Scanner sc2 = new Scanner(System.in);
	    System.out.print("Ingrese descuento");
	    double val = sc2.nextDouble(); 
		desc1.setValorDesc(val);
		desc3.setValorDesc(val);
		}
	    //sc2.close();

				
		
			for (int i=0; i<2;i++) {
	
	ItemCompra item = items[i];
	total = total + item.calcularSubtotal();}
			
			if (d.equals("%"))
				
		
			return desc3.valorFinal(total) ;
			
			else if (d.equals("fijo"))
				
			return desc1.valorFinal(total) ;
			
			else 
				
				return total ;
			
	
				
		
	}
		


}
