
public class SeguroValor extends SeguroVazio{

	public SeguroValor(int valorSeguro){
		super(valorSeguro);
	}
	
	public String toString() {
		return String.format(" - ASSEGURADA (VALOR) - %d", super.getValorSeguro());
	}
}
