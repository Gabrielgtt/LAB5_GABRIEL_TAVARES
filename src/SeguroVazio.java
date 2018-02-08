
public class SeguroVazio {
		
	private int valorSeguro;
	
	/**
	 * Construtor de seguro
	 * @param valorSeguro valor assegurado na aposta (usados pelas classes filhas)
	 */
	public SeguroVazio(int valorSeguro){
		this.valorSeguro = valorSeguro;
	}
		
	/**
	 * @return valor do seguro
	 */
	public int getValorSeguro() {
		return this.valorSeguro;
	}
	
	/**
	 * A representação de um seguro sem tipo é vazia, pois não há seguro
	 */
	public String toString() {
		return "";
	}
}