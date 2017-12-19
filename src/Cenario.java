/**
 * Representação de um cenário.
 * @author Gabriel Alves Tavares
 */
public class Cenario {

	private String descricao;
	private int numeracao;
	private String estado;
	private boolean finalizado;
	private int caixa;
	private int totalRateio;

	/**
	 * Construtor de um cenário.
	 * Atribui ao estado a string "Não finalizado" e o atributo 'finalizado' como false.
	 * Caixa e totalRateio começam zerados.
	 * @param descricao descrição do cenário
	 * @param numeracao número do cenário
	 */
	public Cenario(String descricao, int numeracao) {
		this.descricao = descricao;
		this.numeracao = numeracao;
		this.estado = "Não finalizado";
		this.finalizado= false;		
		this.caixa = 0;
		this.totalRateio = 0;
	}

	/**
	 * Método que auxiliar que levanta um erro caso uma ação ilegal tente ser feita em um cenário já fechado
	 */
	private void validarAcao(boolean desejado) throws IllegalAccessError {
		if (this.finalizado != desejado) {
			throw new IllegalAccessError("Cenário já foi finalizado!");
		}
	}
	
	/**
	 * Finaliza um cenário, atribuindo os valores de caixa e do rateio total conforme o ocorrimento das apostas.
	 * Modifica estado conforme o ocorrimento do cenário.
	 * @param ocorreu ocorrência do cenário (true ou false)
	 * @param valorTaxado multiplicação das apostas perdedores pela taxa do sistema
	 * @param totalRateio lucro total que será distribuído entre os que acertaram a aposta
	 */
	public void fechar(boolean ocorreu, int valorTaxado, int totalRateio) throws IllegalAccessError {
		validarAcao(false);
		this.finalizado = true;
		if (ocorreu) {
			this.estado = "Finalizado (ocorreu)";
		} else {
			this.estado = "Finalizado (n ocorreu)"; 
		}
		
		this.caixa = valorTaxado;
		this.totalRateio = totalRateio;		
	}

	/**
	 * @return caixa do cenário
	 */
	public int getCaixa() throws IllegalAccessError {
		validarAcao(true);
		return this.caixa;
	}	

	/** 
	 * @return rateio total do cenário
	 */
	public int getTotalRateio() throws IllegalAccessError {
		validarAcao(true);
		return totalRateio;
	}

	/**
	 * @return representação textual do cenário que contém a numeração, descrição e estado do mesmo.
	 */
	public String toString() {
		return String.format("%d - %s - %s", this.numeracao, this.descricao, this.estado);
	}

}
