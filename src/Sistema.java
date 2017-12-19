/**
 * Classe de controle principal. 
 * Comanda o controlador de cenários e o controlador de apostas e as interações entre eles.
 * @author Gabriel Alves Tavares
 */
public class Sistema {

	private int caixa;
	private double taxa;
	private ControleCenarios ctrlCenarios;
	private ControleApostas ctrlApostas;

	/**
	 * Construtor do sistema que inicializa os controles de cenários e apostas tal como recebe
	 * o valor inicial do caixa e a taxa de lucro sobre as apostas erradas
	 * @param caixa valor inicial do caixa (em centavos)
	 * @param taxa valor da taxa de lucro sobre as apostas erradas
	 */
	public Sistema(int caixa, double taxa) {
		if (caixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		if (taxa < 0.0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		this.caixa = caixa;
		this.taxa = taxa;
		this.ctrlCenarios = new ControleCenarios();
		this.ctrlApostas = new ControleApostas();
	}

	/**
	 * @return caixa do sistema
	 */
	public int getCaixa() {
		return this.caixa;
	}

	/**
	 * Cadastra um cenário e retorna a numeração do cenário
	 * @param descricao descrição textual do cenário
	 * @return numeração do cenário
	 */
	public int cadastrarCenario(String descricao) {
		return this.ctrlCenarios.cadastrarCenario(descricao);
	}

	/**
	 * Exibe a representação textual de um cenário
	 * @param cenario número do cenário
	 * @return toString do cenário escolhido
	 */
	public String exibirCenario(int cenario) {
		return this.ctrlCenarios.exibirCenario(cenario);
	}

	/**
	 * @return uma lista com a representação textual de todos os cenários em ordem de cadastro
	 */
	public String exibirCenarios() {
		return this.ctrlCenarios.exibirCenarios();
	}

	/**
	 * Cadastra uma nova aposta
	 * @param cenario número do cenário
	 * @param apostador nome do apostador
	 * @param valor valor da aposta (em centavos)
	 * @param previsao "VAI ACONTECER" ou "N VAI ACONTECER"
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		if (cenario >= ctrlCenarios.getNumeracao()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		this.ctrlApostas.cadastrarAposta(cenario, apostador, valor, previsao);
	}

	/**
	 * Obtém o valor total apostado em um cenário
	 * @param cenario número do cenário
	 * @return soma do valor de todas as apostas feitas em um cenário
	 */
	public int valorTotalDeApostas(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		}
		if (cenario >= ctrlCenarios.getNumeracao()) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		return this.ctrlApostas.valorTotalDeApostas(cenario);
	}

	/**
	 * Obtém o número de apostas feitas em um cenário
	 * @param cenario número do cenário
	 * @return número de apostas feitas em um cenário
	 */
	public int totalDeApostas(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		}
		if (cenario >= ctrlCenarios.getNumeracao()) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
		return this.ctrlApostas.totalDeApostas(cenario);
	}
	
	/**
	 * Exibe todas as apostas de um cenário
	 * @param cenario número do cenário
	 * @return toString de todas as apostas (uma por linha)
	 */
	public String exibeApostas(int cenario) {
		return this.ctrlApostas.exibeApostas(cenario);
	}

	/**
	 * Encerra um cenário (indicando se ocorreu ou não).
	 * Adiciona ao caixa do sistema a multiplicação entre a taxa e a soma de todas as apostas erradas
	 * para o cenário fechado e salva no cenário esse valor e o rateio total.
	 * @param cenario número do cenário
	 * @param ocorreu booleando que indica a ocorrência do cenário
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		}
		if (cenario >= ctrlCenarios.getNumeracao()) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		if (ctrlCenarios.fechado(cenario)) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		
		int valorApostasErradas = this.ctrlApostas.valorApostasErradas(cenario, ocorreu);
		int valorTaxado = (int) Math.floor(((double) valorApostasErradas * taxa)); 
		int totalRateio = (valorApostasErradas - valorTaxado);
		
		this.caixa += valorTaxado;
		this.ctrlCenarios.fecharCenario(cenario, ocorreu, valorTaxado, totalRateio);
	}

	/**
	 * Obtém o valor total de um cenário encerrado que será destinado ao caixa
	 * @param cenario número do cenário
	 * @return o valor total de um cenário encerrado que será destinado ao caixa
	 */
	public int getCaixaCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		}
		if (cenario >= ctrlCenarios.getNumeracao()) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		if (!ctrlCenarios.fechado(cenario)) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
		return this.ctrlCenarios.getCaixaCenario(cenario);
	}

	/**
	 * Obtém o valor total de um cenário encerrado que será destinado a distribuição entre as apostas vencedoras
	 * @param cenario número do cenário
	 * @return o valor total de um cenário encerrado que será destinado a distribuição entre as apostas vencedoras
	 */
	public int getTotalRateioCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		}
		if (cenario >= ctrlCenarios.getNumeracao()) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		if (!ctrlCenarios.fechado(cenario)) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		return this.ctrlCenarios.getTotalRateio(cenario);
	}

}
