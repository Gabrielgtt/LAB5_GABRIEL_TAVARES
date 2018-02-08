import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CenarioComBonusTest {
	
	@Test
	public void toStringTest() {
		CenarioComBonus cenario = new CenarioComBonus("Um teste", 1, 30);
		assertEquals(cenario.toString(), "1 - Um teste - Nao finalizado - 30");
	}
	
	
	
}