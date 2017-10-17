import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class PiramideTest{

	@Before
	public void setUp(){
		System.out.println("Iniciando...");
	}
	
	/*TESTE CLASSES VALIDAS*/
	@Test
	public void piramideTetraedroRegular1() {
		assertEquals(3, Piramide.piramide(1,1,1,1,1,1));
	}

	@Test
	public void piramideTetraedroRegular2() {
		assertEquals(3, Piramide.piramide(2,2,2,2,2,2));
	}
	
	@Test
	public void piramideTetraedroRegular14() {
		assertEquals(3, Piramide.piramide(14,14,14,14,14,14));
	}
	
	@Test
	public void piramideTetraedroRegular15() {
		assertEquals(3, Piramide.piramide(15,15,15,15,15,15));
	}
	
	/*TESTE CLASSES INVALIDAS*/	
	
	@Test
	public void base1menorQue1() {
		assertEquals(-9, Piramide.piramide(0,9,8,8,8,8));
	}
	
	@Test
	public void base1maiorQue15() {
		assertEquals(-9, Piramide.piramide(16,9,8,8,8,8));
	}
	
	@Test
	public void base2menorQue1() {
		assertEquals(-9, Piramide.piramide(9,0,8,8,8,8));
	}
	
	@Test
	public void base2maiorQue15() {
		assertEquals(-9, Piramide.piramide(10,16,8,8,8,8));
	}
	
	@Test
	public void base3menorQue1() {
		assertEquals(-9, Piramide.piramide(9,9,0,8,8,8));
	}
	
	@Test
	public void base3maiorQue15() {
		assertEquals(-9, Piramide.piramide(9,9,16,8,8,8));
	}
	
	@Test
	public void l1menorQue1() {
		assertEquals(-9, Piramide.piramide(9,9,8,0,8,8));
	}
	
	@Test
	public void l1maiorQue15() {
		assertEquals(-9, Piramide.piramide(9,9,8,16,8,8));
	}
	
	@Test
	public void l2menorQue1() {
		assertEquals(-9, Piramide.piramide(9,9,8,8,0,8));
	}
	
	@Test
	public void l2maiorQue15() {
		assertEquals(-9, Piramide.piramide(10,10,8,8,16,8));
	}
	
	@Test
	public void l3menorQue1() {
		assertEquals(-9, Piramide.piramide(9,9,9,8,8,0));
	}
	
	@Test
	public void l3maiorQue15() {
		assertEquals(-9, Piramide.piramide(9,9,9,8,8,16));
	}
	
	@Test
	public void baseCrescente1() {
		assertEquals(-4, Piramide.piramide(8,9,8,8,8,8));
	}
	
	@Test
	public void baseCrescente2() {
	assertEquals(-4, Piramide.piramide(8,8,9,9,9,9));
	}
	
	@Test
	public void baseCrescente3() {
		assertEquals(-4,Piramide.piramide(10,9,10,8,8,8));
	}
	
	@Test
	public void baseNaoFormaTriangulo1() {
		assertEquals(-1, Piramide.piramide(12,5,5,5,5,5));
	}
	
	@Test
	public void baseNaoFormaTrianguloEquilatero1() {
		assertEquals(-2, Piramide.piramide(12,11,10,10,10,10));
	}
	
	@Test
	public void baseNaoFormaTrianguloEquilatero2() {
		assertEquals(-2, Piramide.piramide(12,12,10,10,10,10));
	}
	
	@Test
	public void face1Crescente1() {
		assertEquals(-3, Piramide.piramide(9,9,9,10,9,9));
	}
	
	@Test
	public void face1Crescente2() {
		assertEquals(-3, Piramide.piramide(9,9,9,8,10,9));
	}

	@Test
	public void face1Crescente3() {
		assertEquals(-3, Piramide.piramide(10,10,10,9,10,10));
	}
	
	@Test
	public void face1NaoFormaTriangulo() {
		assertEquals(-5, Piramide.piramide(10,10,10,4,4,4));
	}
	
	@Test
	public void face1NaoFormaTrianguloEquilatero1() {
		assertEquals(-6, Piramide.piramide(8,8,8,7,6,6));
	}
	
	@Test
	public void face1NaoFormaTrianguloEquilatero2() {
		assertEquals(-6, Piramide.piramide(8,8,8,8,7,6));
	}
	
	@Test
	public void face2Crescente1() {
		assertEquals(-7, Piramide.piramide(6,6,6,6,6,7));
	}
	
	@Test
	public void face2NaoFormaTrianguloEquilatero() {
		assertEquals(-8, Piramide.piramide(6,6,6,6,6,5));
	}
	
	@After
	public void tearDown(){
		System.out.println("Finalizando...");
	}
}
