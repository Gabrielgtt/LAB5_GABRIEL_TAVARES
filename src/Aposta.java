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
	private Seguro seguro;

	/**
	 * Construtor de aposta que atribui seus atributos conforme recebido.
	 * @param cenario número do cenário
	 * @param apostador nome do apostador
	 * @param valor valor da aposta (em centavos)
	 * @param previsao "VAI ACONTECER" ou "N VAI ACONTECER"
	 */
	public Aposta(int cenario, String apostador, int valor, String previsao) {
		this.validarCadastroAposta(cenario, apostador, valor, previsao);
		this.cenario = cenario;
		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
		this.setSeguro(0);
	}
	
	/**
	 * Construtor de aposta que atribui seus atributos conforme recebido.
	 * @param cenario número do cenário
	 * @param apostador nome do apostador
	 * @param valor valor da aposta (em centavos)
	 * @param previsao "VAI ACONTECER" ou "N VAI ACONTECER"
	 * @param valorSeguro valor que o apostador receberá caso perca a aposta
	 */
	public Aposta(int cenario, String apostador, int valor, String previsao, int valorSeguro) {
		this(cenario, apostador, valor, previsao);
		this.setSeguro(valorSeguro);
	}
	
	/**
	 * Construtor de aposta que atribui seus atributos conforme recebido.
	 * @param cenario número do cenário
	 * @param apostador nome do apostador
	 * @param valor valor da aposta (em centavos)
	 * @param previsao "VAI ACONTECER" ou "N VAI ACONTECER"
	 * @param taxa taxa da aposta que será segurada para o apostador caso perca
	 */
	public Aposta(int cenario, String apostador, int valor, String previsao, double taxa) {
		this(cenario, apostador, valor, previsao);
		this.setSeguro(taxa);
	}
	
	/**
	 * Modifica o seguro dessa aposta para um do tipo Valor
	 * @param valorSeguro valor assegurado pelo apostador caso perca a aposta
	 */
	public void setSeguro(int valorSeguro) {
		this.seguro = new SeguroValor(valorSeguro);
	}
	
	/**
	 * Modifica o seguro dessa aposta para um do tipo Taxa
	 * @param taxa taxa da aposta que será segurada para o apostador caso perca
	 */
	public void setSeguro(double taxa) {
		this.seguro = new SeguroTaxa(this.valor, taxa);
	}
	
	private void validarCadastroAposta(int cenario, String apostador, int valor, String previsao) {
		if (apostador == null || apostador.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao == null || previsao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		if (!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
	}

	/**
	 * @return valor da aposta
	 */
	public int getValor() {
		return this.valor;
	}

	/**
	 * @return se a previsão é de que o cenário ocorrerá, retorna true, do contrário false
	 */
	public boolean getPrevisao() {
		if (this.previsao.equals("VAI ACONTECER")) return true;
		return false;
	}
	
	/**
	 * @return valor do seguro da aposta
	 */
	public int getValorSeguro() {
		return this.seguro.getValorSeguro();
	}

	/**
	 * @return número do cenário da aposta
	 */
	public int getCenario() {
		return this.cenario;
	}
	
	/**
	 * @return representação textual da aposta com nome do apostador, valor em Reais e a previsão
	 */
	public String toString() {
		double valorReais = ((double) valor) / (double) 100;		
		return String.format("%s - R$%.2f - %s", this.apostador, valorReais, this.previsao) + seguro.toString();
	}
}
