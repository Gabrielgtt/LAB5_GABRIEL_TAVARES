
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class CenarioTest {
	
	private Cenario cenario;
	private Cenario cenarioFechado1;
	private Cenario cenarioFechado2;

	@Before
	public void inicializar() {
		this.cenario = new Cenario ("Tirar 10 no Lab5", 1);
		
		this.cenarioFechado1 = new Cenario ("Tirar A+ no Lab5", 2);
		cenarioFechado1.fechar(true, 200, 100);
		
		this.cenarioFechado2 = new Cenario ("Tirar A+ no Lab5", 3);
		cenarioFechado2.fechar(false, 200, 100);
	}
	
	@Test
	public void toStringTest() {
		String esperado = "1 - Tirar 10 no Lab5 - Não finalizado";
		assertTrue(this.cenario.toString().equals(esperado));
	}

	@Test(expected=IllegalAccessError.class)
	public void getCaixaCenarioAberto() {
		cenario.getCaixa();
		fail("caixa de um cenário foi acessado sem ele ter sido finalizado");
	}
	
	@Test(expected=IllegalAccessError.class)
	public void getTotalRateioCenarioAberto() {
		cenario.getTotalRateio();
		fail("rateio de um cenário foi acessado sem ele ter sido finalizado");
	}
	
	@Test
	public void getCaixaCenarioFechado() {
		assertTrue(this.cenarioFechado1.getCaixa() == 200);
	}
	
	@Test
	public void getTotalRateioCenarioFechado() {
		assertEquals(true, this.cenarioFechado1.getTotalRateio() == 100);
	}
	
	@Test(expected=IllegalAccessError.class)
	public void fecharTestFechado() {
		cenarioFechado1.fechar(true, 100, 200);
	}
	
	@Test
	public void CenarioFechado1ToStringTest() {
		String esperado = "2 - Tirar A+ no Lab5 - Finalizado (ocorreu)";
		assertTrue(this.cenarioFechado1.toString().equals(esperado));
	}
	
	@Test
	public void CenarioFechado2ToStringTest() {
		String esperado = "3 - Tirar A+ no Lab5 - Finalizado (n ocorreu)";
		assertTrue(this.cenarioFechado2.toString().equals(esperado));
	}
	

}
