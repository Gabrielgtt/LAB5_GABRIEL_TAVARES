
public class CenarioComBonus extends Cenario {
		
		private int bonus;
			
		/**
		 * Constrói um cenário adicionando o bônus ao rateio total
		 * @param descricao descrição do cenário
		 * @param numeracao número do cenário
		 * @param bonus valor bônus a ser destribuido para o vencedores das apostas desse cenário 
		 */
		public CenarioComBonus(String descricao, int numeracao, int bonus) {
			super(descricao, numeracao);
			this.bonus = bonus;
			this.totalRateio = bonus;
		}
		
		/** 
		 * @return rateio total do cenário
		 */
		public int getTotalRateio(){
			return this.totalRateio - bonus;
		}
		
		/**
		 * Representação em string do cenário com o bônus
		 */
		@Override
		public String toString() {
			return String.format("%s - %d", super.toString(), this.bonus);
		}
}

