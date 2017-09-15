package mujava.results;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ScoreResultsExecution {
	private Map<String, String> finalTestKilleResults;
	private Map<String, String> percentageResults;
	private Map<String, String> finalTestliveResults;
	Map<String, String> testCasesGenerated;
	private Map<String, Integer> somaTestliveResults = new HashMap<String, Integer>();
	//Mutantes mortos por operador
	private Map<String, Integer> totalKilleResults = new HashMap<String, Integer>();
	private Map<String, String> operadorMap;
	List<String> listOperadores = new ArrayList<String>();
	int VDL_CONT = 1;
	int SDL_CONT = 1;
	int AODU_CONT = 1;
	int AOIS_CONT = 1;
	int AOIU_CONT = 1;
	int AORB_CONT = 1;
	int COI_CONT = 1;
	int COR_CONT = 1;
	int LOI_CONT = 1;
	int ODL_CONT = 1;
	int ROR_CONT = 1;
	int AORS_CONT = 1;
	int AODS_CONT = 1;
	int COD_CONT = 1;
	int SOR_CONT = 1;
	int LOD_CONT = 1;
	int CDL_CONT = 1;
	int LOR_CONT = 1;
	int ASRS_CONT = 1;

	public ScoreResultsExecution(Map<String, String> finalTestKille, Map<String, String> finalTestlive,
			Map<String, String> testCasesGenerated) {
		this.finalTestKilleResults = finalTestKille;
		this.finalTestliveResults = finalTestlive;
		this.testCasesGenerated = testCasesGenerated;
		initializeMapping();
		this.exibirresultado();
		// this.imprimeSoma();
		this.mutationScorr();
		listOperator();
		// init();
	}

	public void init() {

		// Map<String, Integer> killed = killedByOperators();
		// totalMutantsOperators(killed);
	}

	public Map<String, Double> killedPercentageByOperators() {

		return null;
	}

	// Conta mutantes mortos
	public Map<String, Integer> killedByOperators() {
		Integer cont = 0;
		int soma_operador = 0;

		for (String keyLK : finalTestKilleResults.keySet()) {// {a1234224b1345c2345d}

			// for (String keyCasoTeste : testCasesGenerated.keySet()) {
			// É caso de de teste?
			if (finalTestKilleResults.get(keyLK).equals(testCasesGenerated.get(keyLK))) {
				totalKilleResults.put(keyLK, 0);
				soma_operador = 0;
			} else {

				// for (Operator operatorMutation : Operator.values()) {

				String[] textoSeparadoOperador = finalTestKilleResults.get(keyLK).split("_");
				// if
				// (textoSeparadoOperador[0].equals(operatorMutation.toString()))
				// {
				// É operador?
				if (textoSeparadoOperador[0].equals(operadorMap.get(textoSeparadoOperador[0]))) {

					for (String keyMutantKille : totalKilleResults.keySet()) {
						if (totalKilleResults.get(keyMutantKille).equals(textoSeparadoOperador[0])) {
							int auxSoma = totalKilleResults.get(keyMutantKille) + 1;
							totalKilleResults.remove(keyMutantKille);
							totalKilleResults.put(keyMutantKille, auxSoma);
						} else {
							soma_operador = soma_operador + 1;
							totalKilleResults.put(keyLK, soma_operador);
						}
					}
					// totalKilleResults.put(keyLK, soma_operador);
				}
				// }

			}

			// }
		}

		return somaTestliveResults;
	}

	public Map<String, Double> liveByOperators() {

		return null;
	}

	public void totalMutantsOperators(Map<String, Integer> mutantes) {
		for (String keyLive : mutantes.keySet()) {
			System.out.println("Operador: " + keyLive + "Quantidade: " + mutantes.get(keyLive));
		}

	}

	public void exibir() {
		int soma_operador = 0;
		String[] textoSeparadoOperador;
		String operador = null;
		for (String keyLK : finalTestKilleResults.keySet()) {

			System.out.println("Chave: " + keyLK + " - " + "Valor: " + finalTestKilleResults.get(keyLK));
			if (keyLK.equals(testCasesGenerated.get(keyLK))) {
				totalKilleResults.put(keyLK, 0);
			} else {
				textoSeparadoOperador = finalTestKilleResults.get(keyLK).split("_");
				for (Operator operatorMutation : Operator.values()) {
					if (textoSeparadoOperador[0].equals(operatorMutation.toString())) {
						soma_operador = soma_operador + 1;
						totalKilleResults.put(operatorMutation.toString(), soma_operador);
					}

				}

			}

		}
		exibirresultado();
	}

	public void exibirresultado() {
		int soma_operador = 0;
		String[] textoSeparadoOperador;
		int somaOperador = 0;
		int valorCase = -1;
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


		for (String keyLK : finalTestKilleResults.keySet()) {
			System.out.println("++++++++++++++++++++++++++++++++++++++-Aqui-+++++++++++++++++++++++++++++++++++++");
			System.out.println("Chave: " + keyLK + " - " + "Valor: " + finalTestKilleResults.get(keyLK));
			if (keyLK.equals(testCasesGenerated.get(keyLK))) {
				System.out.println("++++++++++++++++++++++++++++++++++++++-IF-+++++++++++++++++++++++++++++++++++++");
				totalKilleResults.put(keyLK, valorCase);

				System.out.println("Valor String: " + finalTestKilleResults.get(keyLK));

				// Separa String por virgula
				StringTokenizer tokenVirgula = new StringTokenizer(finalTestKilleResults.get(keyLK), ",");

				while (tokenVirgula.hasMoreTokens()) {
					String tkOperador = tokenVirgula.nextToken();
					String tkOperadorMutacao = tkOperador.replaceAll("[^A-Z]", "");
					this.listOperadores.add(tkOperadorMutacao);
					if(tkOperadorMutacao.equals("")){
						totalKilleResults.put(tkOperadorMutacao+"_"+valorCase, valorCase);	
					}
					System.out.println("Token Operador: " + tkOperador);
				}

				
			}
			valorCase += -1;

		}
		
		
	}

	private void initializeMapping() {
		operadorMap = new HashMap<String, String>();
		for (Operator operatorMutation : Operator.values()) {
			operadorMap.put(operatorMutation.toString(), operatorMutation.toString());
		}
	}

	public void imprimeSoma() {
		System.out.println("*************************************************************************");
		for (String keyLK : totalKilleResults.keySet()) {
			System.out.println("Chave: " + keyLK + " - " + "Valor: " + totalKilleResults.get(keyLK));
		}
	}

	public void mutationScorr() {
		for (Entry<String, Integer> entry : totalKilleResults.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue().SIZE);
		}
	}
	
	public void listOperator() {
		for(String operador : this.listOperadores) {
			System.out.println( "Operador: " + operador);
			}
	}


}
