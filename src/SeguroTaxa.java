
public class SeguroTaxa extends SeguroValor {
	
	private double taxa;
	
	public SeguroTaxa(int valorAposta, double taxa) {
		super((int) (valorAposta * taxa / 100)); // VERIFICAR O CÁLCULO CONFORME A TAXA É DADA
		this.taxa = taxa;
	}
	
	@Override
	public String toString() {
		return String.format(" - ASSEGURADA (TAXA) - %.0f%", taxa);
	}	
}
