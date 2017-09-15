package mujava.results;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class CalculationResultsExecution {
	// public Operator operatorMutation;

	public Map<String, Double> atribuiResultados(Vector<Object> casoCriterioPorcentagem) {
		return null;
	}

	public Map<String, Double> atribuiResultados(Map<String, Double> casoCriterioPorcentagem) {
		return null;
	}

	public Map<String, Double> atribuiResultados(List<Object> casoCriterioPorcentagem) {
		return null;
	}

	// No Mujava vou receber um Map, método atribui os valores para o MAP com
	// resultado dos testes
	public Map<String, Double> atribuiResultados(String[] casoTeste, String[] criterios) {
		int i;

		Map<String, Double> chave_valor = new HashMap<String, Double>();

		System.out.println("#------------------------------Sei lá-----------------------------------#");
		chave_valor.put("101", 101.0);
		Double keyCaso = 1.0;
		for (Operator operatorMutation : Operator.values()) {

			for (i = 0; i < casoTeste.length; i++) {
				// Atribui nome do caso
				chave_valor.put(casoTeste[i].toString(), keyCaso);

				// operatorMutation.toString() = ENUM de critérios
				if (casoTeste[0].equals(operatorMutation.toString())) {
					// chave_valor.put(criterios, porcentagem);
				} else {
					chave_valor.put("101", 101.0);
				}
			}

		}
		return chave_valor;

	}

	public Map<String, Integer> killedMumberOperators(String[] killed_mutants, int killed_num) {
		int i;

		Map<String, Integer> chave_valor = new HashMap<String, Integer>();
		int soma_operador = 0;

		String[] textoSeparado = null;
		System.out.println(
				"#------------------------------Total Mortos por Operador-----------------------------------#");
		for (Operator operatorMutation : Operator.values()) {
			/*
			 * } for (j = 0; j < operadores.length; j++) {
			 */
			soma_operador = 0;
			for (i = 0; i < killed_num; i++) {
				textoSeparado = killed_mutants[i].split("_");
				if (textoSeparado[0].equals(operatorMutation.toString())) {
					soma_operador = soma_operador + 1;
				}
			}
			// if (soma_operador != 0) {
			chave_valor.put(operatorMutation.toString(), soma_operador);
			System.out.println("Operador: " + operatorMutation + " Total Morto: " + soma_operador);
			// }

		}
		return chave_valor;

	}

	public Map<String, Integer> liveMumberOperators(String[] live_mutants, int live_num) {
		int i;
		Map<String, Integer> chave_valor = new HashMap<String, Integer>();
		int soma_operador = 0;
		String[] textoSeparado = null;
		System.out.println(
				"#------------------------------Total de Mutantes Vivos por Operador-----------------------------------#");
		for (Operator operatorMutation : Operator.values()) {
			soma_operador = 0;
			for (i = 0; i < live_num; i++) {
				textoSeparado = live_mutants[i].split("_");
				if (textoSeparado[0].equals(operatorMutation.toString())) {
					soma_operador = soma_operador + 1;
				}
			}
			// if (soma_operador != 0) {
			chave_valor.put(operatorMutation.toString(), soma_operador);
			System.out.println("Operador: " + operatorMutation + " Total VIVO: " + soma_operador);
			// }
		}
		return chave_valor;

	}

	public Map<String, Double> killedPercentageByOperators(String[] killed_mutants, String[] live_mutants,
			int killed_num, int live_num) {
		Map<String, Double> operador_porcentagem = new HashMap<String, Double>();
		Map<String, Integer> numberKilled = this.killedMumberOperators(killed_mutants, killed_num);
		Map<String, Integer> numberLive = this.liveMumberOperators(live_mutants, live_num);
		Map<String, Integer> totalLiveKilled = this.totalMutantsOperators(numberLive, numberKilled);
		int valueKilled = 0;
		int valueLK;
		double valorPercentual = 0;

		System.out.println("#-------------------------------Percentual por Operador------------------------#");
		// busca valores totais
		for (String keyLK : totalLiveKilled.keySet()) {
			valueLK = totalLiveKilled.get(keyLK);
			valorPercentual = 0;

			for (String keyKilled : numberKilled.keySet()) {
				valueKilled = numberKilled.get(keyKilled);
				if (valueKilled != 0) {
					if (keyLK.equals(keyKilled)) {
						valorPercentual = (valueKilled * 100) / valueLK;
						operador_porcentagem.put(keyKilled, valorPercentual);
					}
				}
			}

			System.out.println("Operador: " + keyLK + " Percentual Mortos: " + valorPercentual + " %");
		}
		/*
		 * try { new GenerateArff().generateFile(operador_porcentagem); } catch
		 * (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		return operador_porcentagem;

	}

	public Map<String, Integer> totalMutantsOperators(Map<String, Integer> live, Map<String, Integer> killed) {
		Map<String, Integer> tmo = new HashMap<String, Integer>();
		int valueKilled;
		int valueLive;
		int totalLiveKilled = 0;
		System.out.println(
				"#------------------------------------Total Gerado por Operador--------------------------------#");
		for (String keyLive : live.keySet()) {
			valueLive = live.get(keyLive);
			for (String keyKilled : killed.keySet()) {
				valueKilled = killed.get(keyKilled);
				if (keyLive.equals(keyKilled)) {
					totalLiveKilled = valueKilled + valueLive;
					if (totalLiveKilled != 0)
						tmo.put(keyKilled, totalLiveKilled);
				}
			}
			System.out.println("Operador: " + keyLive + " Total: " + totalLiveKilled);
		}

		return tmo;
	}

}
