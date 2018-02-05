
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ApostaTest {

	private Aposta aposta;
	
	@Before
	public void inicializar() {
		this.aposta = new Aposta(1, "Gabriel", 100, "VAI ACONTECER");	
	}
	
	@Test
	public void getValorTest() {
		assertTrue(this.aposta.getValor() == 100);
	}
	
	@Test
	public void getPrevisaoTeste() {
		assertTrue(this.aposta.getPrevisao() == true);
	}
	
	@Test
	public void getCenarioTeste() {
		assertTrue(this.aposta.getCenario() == 1);
	}
	
	@Test
	public void getToStringTeste1() {
		String correto = "Gabriel - R$1,00 - VAI ACONTECER";
		assertTrue(this.aposta.toString().equals(correto));
	}
	
	@Test
	public void getToStringTeste2() {
		Aposta aposta2 = new Aposta(2, "Matheus", 12345, "N VAI ACONTECER");
		String correto = "Matheus - R$123,45 - N VAI ACONTECER";
		assertTrue(aposta2.toString().equals(correto));
	}

}
