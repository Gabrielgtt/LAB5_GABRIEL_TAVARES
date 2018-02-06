
public class SeguroTaxa extends Seguro {
	
	private double taxa;
	
	public SeguroTaxa(int valorAposta, double taxa) {
		super((int) (valorAposta * taxa)); // VERIFICAR O CÁLCULO CONFORME A TAXA É DADA
		this.taxa = taxa;
	}
	
	public int getValorSeguro() {
		return (int) (super.getValorSeguro() * taxa);
	}
	
	@Override
	public String toString() {
		return String.format(" - ASSEGURADA (TAXA) - %.0f%%", taxa*100);
	}	
}
