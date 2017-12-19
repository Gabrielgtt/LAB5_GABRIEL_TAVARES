/**
 * Classe que controla o armazenamento e retorno de informações sobre os cenários.
 * @author Gabriel Alves Tavares
 */
import java.util.ArrayList;
public class ControleCenarios {

	private ArrayList <Cenario> cenarios;
	private int numeracao;
	
	/**
	 * Construtor do controlador de cenários. 
	 * Inicializa o ArrayList de cenários e atribui o valor 1 para a numeração dos cenários.
	 */
	public ControleCenarios() {
		this.cenarios = new ArrayList <Cenario>(); 
		this.numeracao = 1;
	}
	
	/**
	 * Adiciona um cenário ao ArrayList de cenários, retorna a numeração de cenários e a incrementa em 1. 
	 * @param descricao descricao do cenário
	 * @return numeração atribuida ao cenário cadastrado
	 */
	public int cadastrarCenario(String descricao) {
		if (descricao == null) {
			throw new NullPointerException();
		} 
		if (descricao.trim().equals("")){
			throw new IllegalArgumentException();
		}
		Cenario cenario = new Cenario(descricao, numeracao);
		this.cenarios.add(cenario);
		return numeracao++;
	}

	/**
	 * @param cenario numeração do cenário
	 * @return representação textual do cenário com a numeração recebida
	 */
	public String exibirCenario(int cenario) {
		return cenarios.get(cenario - 1).toString();
	}

	/**
	 * Cria e retorna uma representação textual de todos os cenários cadastrados.
	 * @return uma representação textual de todos os cenários cadastrados (um por linha em ordem de casdastro)
	 */
	public String exibirCenarios() {
		String listaCenarios = "";
		for (Cenario cenario : cenarios) {
			listaCenarios += cenario.toString() + System.lineSeparator();
		}
		return listaCenarios;
	}
	
	/**
	 * Encerra um cenário.
	 * @param cenario número de cenário
	 * @param ocorreu ocorrência do cenário (true ou false)
	 * @param valorTaxado multiplicação das apostas perdedores pela taxa do sistema
	 * @param rateio lucro total que será distribuído entre os que acertaram a aposta
	 */
	public void fecharCenario(int cenario, boolean ocorreu, int valorTaxado, int rateio) {
		this.cenarios.get(cenario - 1).fechar(ocorreu, valorTaxado, rateio);
	}

	/**
	 * @param cenario número do cenário
	 * @return o caixa de um cenário
	 */
	public int getCaixaCenario(int cenario) {
		return this.cenarios.get(cenario - 1).getCaixa();
	}

	/**
	 * 
	 * @param cenario número do cenário
	 * @return retorna lucro total que será distribuído entre os que acertaram a aposta desse cenário
	 */
	public int getTotalRateio(int cenario) {
		return cenarios.get(cenario - 1).getTotalRateio();
	}

}
