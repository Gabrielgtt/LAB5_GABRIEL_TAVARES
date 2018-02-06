
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ApostaTest {

	private Aposta aposta;
	private Aposta aposta2;
	private Aposta aposta3;
	private Aposta aposta4;
	
	@Before
	public void inicializar() {
		double taxa = 0.5;
		int valorSeguro = 200;
		this.aposta = new Aposta(1, "Gabriel", 100, "VAI ACONTECER");	
		this.aposta2 = new Aposta(2, "Matheus", 12345, "N VAI ACONTECER");
		this.aposta3 = new Aposta(2, "Matheus", 1234, "N VAI ACONTECER", taxa);
		this.aposta4 = new Aposta(2, "Matheus", 12355, "N VAI ACONTECER", valorSeguro);
	}
	
	@Test
	public void getValorTest() {
		assertTrue(this.aposta.getValor() == 100);
	}
	
	@Test
	public void getPrevisaoTest() {
		assertTrue(this.aposta.getPrevisao() == true);
	}
	
	@Test
	public void getCenarioTest() {
		assertTrue(this.aposta.getCenario() == 1);
	}
	
	@Test
	public void getToStringTest1() {
		assertEquals("Gabriel - R$1,00 - VAI ACONTECER", aposta.toString());
	}
	
	@Test
	public void getToStringTest2() {
		assertEquals("Matheus - R$123,45 - N VAI ACONTECER", aposta2.toString());
	}

	@Test
	public void getToStringSeguroTaxa() {
		assertEquals("Matheus - R$12,34 - N VAI ACONTECER - ASSEGURADA (TAXA) - 50%", aposta3.toString());
	}
}
