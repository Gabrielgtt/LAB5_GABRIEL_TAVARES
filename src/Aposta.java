/**
 * Representação de uma aposta. 
 * Armazena o cenário, nome do apostador, o valor e a previsão e tem sua específica representação textual.
 * @author Gabriel Alves Tavares
 */
public class Aposta {
	
	private int cenario;
	private String apostador;
	private int valor;
	private String previsao;

	/**
	 * Construtor de aposta que atribui seus atributos conforme recebido.
	 * @param cenario número do cenário
	 * @param apostador nome do apostador
	 * @param valor valor da aposta (em centavos)
	 * @param previsao "VAI ACONTECER" ou "N VAI ACONTECER"
	 */
	public Aposta(int cenario, String apostador, int valor, String previsao) {
		this.cenario = cenario;
		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
	}

	/**
	 * @return valor do objeto
	 */
	public int getValor() {
		return this.valor;
	}

	/**
	 * @return previsão do objeto
	 */
	public String getPrevisao() {
		return this.previsao;
	}

	/**
	 * @return número do cenário do objeto
	 */
	public int getCenario() {
		return this.cenario;
	}
	
	/**
	 * @return representação textual da aposta com nome do apostador, valor em Reais e a previsão
	 */
	public String toString() {
		double valorReais = ((double) valor) / 100;
		return String.format("%s - R$%.2f - %s", this.apostador, valorReais, this.previsao);
	}
}
