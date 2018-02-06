
public class SeguroValor extends Seguro{
	
	private int valorSeguro;

	public SeguroValor(int valorSeguro){
		super(valorSeguro);
	}
	
	public String toString() {
		return String.format(" - ASSEGURADA (VALOR) - %d", valorSeguro);
	}
}
