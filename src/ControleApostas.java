/**
 * Classe que controla o armazenamento e retorno de informações sobre as apostas.
 * @author Gabriel Alves Tavares
 */
import java.util.ArrayList;
public class ControleApostas {

	private ArrayList <Aposta> apostas;
	
	/**
	 * Construtor de apostas que inicializa o ArrayList de apostas.
	 */
	public ControleApostas() {
		this.apostas = new ArrayList <Aposta>();
	}
	
	/**
	 * Constrói e adiciona uma apostas ao ArrayList de apostas.
	 * @param cenario número de cenário
	 * @param apostador nome do apostador
	 * @param valor valor da aposta (em centavos)
	 * @param previsao "VAI ACONTECER" ou "N VAI ACONTECER"
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		Aposta aposta = new Aposta(cenario, apostador, valor, previsao);
		apostas.add(aposta);
	}

	/**
	 * Soma o valor de todas as apostas em um cenário.
	 * @param cenario número de cenário
	 * @return soma de todas as apostas do cenário especificado
	 */
	public int valorTotalDeApostas(int cenario) {
		int valorTotal = 0;
		for (Aposta aposta : apostas) {
			if (aposta.getCenario() == cenario) {
				valorTotal += aposta.getValor();				
			}
		}
		return valorTotal;
	}

	/**
	 * Conta e retorna o número de apostas que um cenário recebeu.
	 * @param cenario número do cenário
	 * @return número de apostas que o cenário especificado recebeu
	 */
	public int totalDeApostas(int cenario) {
		int totalApostas = 0;
		for (Aposta aposta : apostas) {
			if (aposta.getCenario() == cenario) {
				totalApostas++;
			}
		}
		return totalApostas;
	}

	/**
	 * Cria e retona uma lista com todas as representações textuais de todas as apostas de um cenário.
	 * @param cenario número do cenário
	 * @return todos os toString das apostas de um cenários (um por linha)
	 */
	public String exibeApostas(int cenario) {
		String listaApostas = "";
		for (Aposta aposta : apostas) {
			if (aposta.getCenario() == cenario) {
				listaApostas += aposta.toString();				
			}
		}
		return listaApostas;
	}

	/**
	 * Retorna a soma do valor de todas as apostas erradas.
	 * @param cenario número do cenário
	 * @param ocorreu ocorrência do cenário (true ou false)
	 * @return soma do valor de todas apostas de previsão errada
	 */
	public int valorApostasErradas(int cenario, boolean ocorreu) {
		String ocorrimento;
		if (ocorreu) {
			ocorrimento = "VAI ACONTECER";
		} else {
			ocorrimento = "N VAI ACONTECER";
		}
			
		int valorErradas = 0;
		for (Aposta aposta : apostas) {
			if (aposta.getCenario() == cenario && !aposta.getPrevisao().equals(ocorrimento)) {
				valorErradas += aposta.getValor();
			}
		}
		return valorErradas;
	}

}
