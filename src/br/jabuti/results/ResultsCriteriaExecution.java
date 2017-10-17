package br.jabuti.results;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import airtesting.wekautil.arff.CreateArtificialARFF;
import br.jabuti.criteria.AbstractCriterion;
import br.jabuti.criteria.Criterion;
import br.jabuti.project.TestCase;
import weka.core.Attribute;

public class ResultsCriteriaExecution {
	private Map<String, Map<String, Double>> resultsJabuti = new HashMap<String, Map<String, Double>>();
	private CreateArtificialARFF createArtificialARFF;
	private String[] criterios = { "AORB", "AORS", "AOIU", "AOIS", "AODU", "AODS", "ROR", "COR", "COD", "COI", "SOR",
			"LOR", "LOI", "LOD", "ASRS", "SDL", "VDL", "CDL", "ODL", "PUSES", "EDGES", "NOS", "USES"};

	Map<String, String> results = new HashMap<String, String>();

	public ResultsCriteriaExecution() {

	}

	public void createObjectsHash(TestCase tc) {
		results.put(tc.getLabel(), "0.0");
		for (int k = 0; k < Criterion.NUM_CRITERIA; k++) {

			if (tc.getTestCaseCoverage(k).getPercentage() > 0.0) {

				String per = new Float(tc.getTestCaseCoverage(k).getPercentage()).toString();

				results.put(AbstractCriterion.getName(k), per);
			}
		}
		this.map(results);

	}

	public void map(Map<String, String> results) {
		Map<String, Double> criterioResults = new HashMap<String, Double>();
		createArtificialARFF = new CreateArtificialARFF();
		int cont = 0;
		String caseTeste = null;
		for (String key : results.keySet()) {
			if (!key.contains("000")) {
				cont += 1;
				criterioResults.put(labelCriterion(key), Double.valueOf(results.get(key)));
			} else
				caseTeste = key;
			if (cont == 4) {
				resultsJabuti.put(caseTeste, criterioResults);
				cont = 0;
			}
		}
		/*for (String iKey : resultsJabuti.keySet()) {
			System.out.println("CHAVE_J: " + iKey + " VALOR_J: " + resultsJabuti.get(iKey));
		}*/
		populationCriterion(this.resultsJabuti);
		createArtificialARFF.creatorRelation("AI+RTesting");
	}
	
	public void populationCriterion(Map<String, Map<String, Double>> resultsJabuti) {
		Map<String, Double> mapInternal;
		for (Entry<String, Map<String, Double>> keyExternal : resultsJabuti.entrySet()) {
			mapInternal = new HashMap<String, Double>();
			HashMap<String, Double> mapInternalData = (HashMap<String, Double>) keyExternal.getValue();
			
			for (Entry<String, Double> keyInternal : mapInternalData.entrySet()) {
				//mapInternal.put(keyInternal.getKey(), keyInternal.getValue());
				CreateArtificialARFF.dataresultsJanutiMujava.get(keyExternal.getKey()).put(keyInternal.getKey(), keyInternal.getValue());
			}
			/*Remover inserção dos casos da Jabuti,
			CreateArtificialARFF.dataresultsJanutiMujava.put(keyExternal.getKey(), mapInternal);*/
		}
	}

	public String labelCriterion(String criterio) {
		String labelCriterion = null;
		switch (criterio) {
		case "All-Pot-Uses-ei":
			labelCriterion =  "PUSES";
			break;
		case "All-Edges-ei":
			labelCriterion = "EDGES";
			break;

		case "All-Nodes-ei":
			labelCriterion = "NOS";
			break;
		case "All-Uses-ei":
			labelCriterion = "USES";
			break;

		default:
			break;
		}
		return labelCriterion;

	}
	public void listaMutantes(){
		for (Entry<String, Map<String, Double>> keyExternalM : CreateArtificialARFF.dataresultsJanutiMujava.entrySet()) {
			System.out.println("CHAVE EXTERNA: "+ keyExternalM.getKey()+" VALOR EXTERNO: "+ keyExternalM.getValue());
		}
	}

}
