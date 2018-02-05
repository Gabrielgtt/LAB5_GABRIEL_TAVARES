
public class SeguroValor {
	
	private int valorSeguro;

	public SeguroValor(int valorSeguro){
		this.valorSeguro = valorSeguro;
	}
	
	public int getValorSeguro() {
		return this.valorSeguro;
	}
	
	public String toString() {
		return String.format(" - ASSEGURADA (VALOR) - %d", valorSeguro);
	}
}
