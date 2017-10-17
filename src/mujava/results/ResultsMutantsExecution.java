package mujava.results;

import java.util.Map;
import java.util.HashMap;
import java.util.Vector;
import java.util.Map.Entry;

import airtesting.wekautil.arff.CreateArtificialARFF;

public class ResultsMutantsExecution {
	private Map<String, String> finalTestResults;
	private Map<String, String> testCasesGenerated;
	private Map<String, String> operadorMap;
	private static Map<String, Integer> operadorKilled = new HashMap<String, Integer>();
	private Vector<String> killedMutants;
	private CreateArtificialARFF createArtificialARFF;
	private Map<String, Map<String, Double>> testOperation = new HashMap<String, Map<String, Double>>();
	private String[] operadores = { "AORB", "AORS", "AOIU", "AOIS", "AODU", "AODS", "ROR", "COR", "COD", "COI", "SOR",
			"LOR", "LOI", "LOD", "ASRS", "SDL", "VDL", "CDL", "ODL", "PUSES", "EDGES", "NOS", "USES"};
	

	public ResultsMutantsExecution(Map<String, String> finalTest, Map<String, String> testCasesGenerated,
			Vector killed_mutants) {
		this.killedMutants = killed_mutants;
		this.finalTestResults = finalTest;
		this.testCasesGenerated = testCasesGenerated;
		this.quebraString(this.finalTestResults);

	}

	public static void populaTotalPorOperador(Map<String, Integer> totalOperadorKilled) {
		operadorKilled = totalOperadorKilled;
	}

	// Pega lista de mutates por caso de teste
	public void quebraString(Map<String, String> finalTest) {
		//createArtificialARFF = new CreateArtificialARFF();
		Map<String, Integer> oreradorQuantidade = null;

		for (String keyLK : finalTest.keySet()) {
			Map<String, Integer> operationsEQuantidade = new HashMap<String, Integer>();
			if (finalTest.containsKey(keyLK)) {
				oreradorQuantidade = this.quebraStringValor(finalTest.get(keyLK));
				//this.testOperation.put(keyLK, this.caseOperatioValue(oreradorQuantidade));
				this.testOperation.put(keyLK, this.caseOperatioValue(oreradorQuantidade));
			}
		}
		populationCriterion(this.testOperation);
	}
	
	public void populationCriterion(Map<String, Map<String, Double>> resultsMujava) {
		Map<String, Double> mapInternal;
		int contCase = 1;
		String nameCase= "000" ;
		
		for (Entry<String, Map<String, Double>> keyExternal : resultsMujava.entrySet()) {
			mapInternal = new HashMap<String, Double>();
			HashMap<String, Double> mapInternalData = (HashMap<String, Double>) keyExternal.getValue();
			
			for (Entry<String, Double> keyInternal : mapInternalData.entrySet()) {
				mapInternal.put(keyInternal.getKey(), keyInternal.getValue());
			}
			/*System.out.println("Casos"+keyExternal.getKey());
			System.out.println(nameCase+contCase);*/
			
			CreateArtificialARFF.dataresultsJanutiMujava.put(nameCase+contCase, mapInternal);
			contCase = contCase + 1;
			
		}
	}

	// Quebra string com os valores dos operadores de mutação de um caso por
	// virgula
	public Map<String, Integer> quebraStringValor(String contaOperadores) {
		Map<String, String> operadores = new HashMap<String, String>();

		String tokenVirgula[] = contaOperadores.split(",");
		for (String op : tokenVirgula) {
			operadores.put(op, op);
		}

		return contaOperadores(operadores);
	}

	// Conta operadores por caso de teste
	public Map<String, Integer> contaOperadores(Map<String, String> operation) {
		Map<String, Integer> contagem = new HashMap<String, Integer>();

		for (String valor : operation.keySet()) {
			String tkOperadorMutacao = valor.replaceAll("[^A-Z]", "");
			if (!contagem.containsKey(tkOperadorMutacao)) {
				contagem.put(tkOperadorMutacao, 0);
			}
			contagem.put(tkOperadorMutacao, contagem.get(tkOperadorMutacao) + 1);
		}
		return contagem;
	}

	public Map<String, Double> caseOperatioValue(Map<String, Integer> mutanteQuantidade) {
		Map<String, Double> valorOperatioValue = new HashMap<String, Double>();
		for (String key : operadorKilled.keySet()) {
			if (mutanteQuantidade.containsKey(key)) {
				double media = (100 * mutanteQuantidade.get(key)) / operadorKilled.get(key);
				valorOperatioValue.put(key, media);
			}
		}
		/*
		 * for (String keyI : valorOperatioValue.keySet()) { System.out.println(
		 * "KEY: " + keyI + " Percentual: " + valorOperatioValue.get(keyI)); }
		 */

		return completaOperatioValue(valorOperatioValue);
	}

	public Map<String, Double> completaOperatioValue(Map<String, Double> valorOperatioValue) {

		for (String key : operadores) {
			if (!valorOperatioValue.containsKey(key)) {
				valorOperatioValue.put(key, 0.0);
			}
		}

		return valorOperatioValue;
	}
	
}
