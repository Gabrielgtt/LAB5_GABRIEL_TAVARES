/**
 * @author Gabriel Alves Tavares
 */
public class Facade {

	private Sistema sistema;
	
	/**
	 * Inicializa o sistema de controle principal do programa
	 * @param caixa valor inicial do caixa
	 * @param taxa taxa de cálculo do lucro para o caixa do sistema
	 */
	public void inicializa(int caixa, double taxa) {
		this.sistema = new Sistema(caixa, taxa);
	}

	/**
	 * @return valor em caixa do sistema (em centavos)
	 */
	public int getCaixa() {
		return sistema.getCaixa();
	}
	
	/**
	 * Cadastra um cenário e retorna a numeração do cenário
	 * @param descricao descrição textual do cenário
	 * @return numeração do cenário
	 */
	public int cadastrarCenario(String descricao) {
		return sistema.cadastrarCenario(descricao);
	}
	
	/**
	 * Exibe a representação textual de um cenário
	 * @param cenario número do cenário
	 * @return toString do cenário escolhido
	 */
	public String exibirCenario(int cenario) {
		return sistema.exibirCenario(cenario);
	}
	
	/**
	 * @return uma lista com a representação textual de todos os cenários em ordem de cadastro
	 */
	public String exibirCenarios() {
		return sistema.exibirCenarios();
	}
	
	/**
	 * Cadastra uma nova aposta
	 * @param cenario número do cenário
	 * @param apostador nome do apostador
	 * @param valor valor da aposta (em centavos)
	 * @param previsao "VAI ACONTECER" ou "N VAI ACONTECER"
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		sistema.cadastrarAposta(cenario, apostador, valor, previsao);
	}

	/**
	 * Obtém o valor total apostado em um cenário
	 * @param cenario número do cenário
	 * @return soma do valor de todas as apostas feitas em um cenário
	 */
	public int valorTotalDeApostas(int cenario) {
		return sistema.valorTotalDeApostas(cenario);
	}
	
	/**
	 * Obtém o número de apostas feitas em um cenário
	 * @param cenario número do cenário
	 * @return número de apostas feitas em um cenário
	 */
	public int totalDeApostas(int cenario) {
		return sistema.totalDeApostas(cenario);
	}
	
	/**
	 * Exibe todas as apostas de um cenário
	 * @param cenario número do cenário
	 * @return toString de todas as apostas (uma por linha)
	 */
	public String exibeApostas(int cenario) {
		return sistema.exibeApostas(cenario);
	}

	/**
	 * Encerra um cenário (indicando se ocorreu ou não).
	 * @param cenario número do cenário
	 * @param ocorreu booleando que indica a ocorrência do cenário
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		sistema.fecharAposta(cenario, ocorreu);
	}
	
	/**
	 * Obtém o valor total de um cenário encerrado que será destinado ao caixa
	 * @param cenario número do cenário
	 * @return o valor total de um cenário encerrado que será destinado ao caixa
	 */
	public int getCaixaCenario(int cenario) {
		return sistema.getCaixaCenario(cenario);
	}
	
	/**
	 * Obtém o valor total de um cenário encerrado que será destinado a distribuição entre as apostas vencedoras
	 * @param cenario número do cenário
	 * @return o valor total de um cenário encerrado que será destinado a distribuição entre as apostas vencedoras
	 */
	public int getTotalRateioCenario(int cenario) {
		return sistema.getTotalRateioCenario(cenario);
	}

}
