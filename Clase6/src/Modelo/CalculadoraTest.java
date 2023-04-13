package Modelo;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.Assert;
public class CalculadoraTest {
	@Test
    public void testCalcularResta() {
        Calculadora calc = new Calculadora(90, 50);
        double resultado = 15*calc.calcularResta();
        assertEquals(605, resultado, 0.0001);          
    }
	
	@Test
    public void testCalcularSuma() {
		
        Calculadora calc = new Calculadora(150, 180);   
        double resultado = calc.calcularSuma()/3;
        assertEquals(110, resultado, 0.0001);        
    }
	@Test
    public void testCalcularProd() {
        Calculadora calc = new Calculadora(80, 3);
        double resultado = calc.calcularProd();
        assertEquals(240, resultado, 0.0001);
    }
	@Test
    public void testCalcularDiv() {
        Calculadora calc = new Calculadora(150, 180);
        double resultado = calc.calcularDiv()/3;
        Assertions.assertNotEquals(110, resultado, 0.0001);
    }
	@Test
    public void testCalcularSuma2() {
		
        Calculadora calc = new Calculadora(70, 40);
        
        double resultado = calc.calcularSuma()*25;
        Assertions.assertNotEquals(2700, resultado, 0.0001);        
    }
	
	
	
	
	
	
}
