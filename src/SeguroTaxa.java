
public class SeguroTaxa extends SeguroVazio {
	
	private double taxa;
	
	/**
	 * Construtor de seguro por taxa. 
	 * @param valorAposta
	 * @param taxa
	 */
	public SeguroTaxa(int valorAposta, double taxa) {
		super(valorAposta);
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
