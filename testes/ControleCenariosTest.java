import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ControleCenariosTest {

	private ControleCenarios ctrlCen1; 
	private ControleCenarios ctrlCen2;
	
	
	@Before
	public void inicializar() {
		this.ctrlCen1 = new ControleCenarios();
		this.ctrlCen2 = new ControleCenarios();
		ctrlCen2.cadastrarCenario("10 LP2");
		ctrlCen2.cadastrarCenario("SS+ LP2");
	}
	
	@Test(expected=NullPointerException.class)
	public void cadastrarCenarioDescricaoNula() {
		ctrlCen1.cadastrarCenario(null);
		fail("Descrição nula cadastrada");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cadastrarCenarioDescricaoVazia() {
		ctrlCen1.cadastrarCenario("");
		fail("Descrição vazia cadastrada");
	}
	
	@Test
	public void exibirCenario() {
		String esperado = "1 - 10 LP2 - Não finalizado";
		assertTrue(ctrlCen2.exibirCenario(1).equals(esperado));
	}
	
	@Test
	public void exibirCenarios() {
		String esperado = "1 - 10 LP2 - Não finalizado" + System.lineSeparator() +
						  "2 - SS+ LP2 - Não finalizado" + System.lineSeparator();
		assertTrue(ctrlCen2.exibirCenarios().equals(esperado));
	}	
	

}
