package br.jabuti.results;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import airtesting.wekautil.arff.Atributos;
import airtesting.wekautil.arff.CreateArtificialARFF;
import airtesting.wekautil.clustering.ClusterEM;
import airtesting.wekautil.clustering.ClusterHierarchical;
import airtesting.wekautil.clustering.ClusterSimpleKMeans;
import br.jabuti.criteria.AbstractCriterion;
import br.jabuti.criteria.Criterion;
import br.jabuti.project.TestCase;
import weka.core.Attribute;

public class ResultsCriteriaExecution {
	private Map<String, Map<String, Double>> resultsJabuti = new HashMap<String, Map<String, Double>>();
	private CreateArtificialARFF createArtificialARFF;
	private Map<String, String> caseTest;
	private Map<String, Double> results = new HashMap<String, Double>();
	

	public ResultsCriteriaExecution() {

	}

	public void createObjectsHash(TestCase tc) {
		// results.put(tc.getAlias(), "0.0");
		createArtificialARFF = new CreateArtificialARFF();

		for (int k = 0; k < Criterion.NUM_CRITERIA; k++) {

			if (tc.getTestCaseCoverage(k).getPercentage() > 0.0) {

				String per = new Float(tc.getTestCaseCoverage(k).getPercentage()).toString();

				results.put(labelCriterion(AbstractCriterion.getName(k)), Double.valueOf(per));
				// System.out.println("Caso : " + tc.getAlias() +
				// AbstractCriterion.getName(k)+ " " + per);
			}

		}
		this.resultsJabuti.put(tc.getAlias(), results);
		populationCriterion(this.resultsJabuti);
		//Chama o método criar ARFF passando o nome da relação e alista de atributos zerados para remoção
		createArtificialARFF.creatorRelation("AI+RTesting");
		ClusterEM clusterEM = new ClusterEM();
		clusterEM.createClusterEM();
		ClusterHierarchical clusterHierarchical = new ClusterHierarchical();
		clusterHierarchical.createClusterHierarchical();
		ClusterSimpleKMeans clusterSimpleKMeans = new ClusterSimpleKMeans();
		try {
			clusterSimpleKMeans.createClusterSimpleKMeans();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void populationCriterion(Map<String, Map<String, Double>> resultsJabuti) {
		Map<String, Double> mapInternal;
		//this.atributos();
		for (Entry<String, Map<String, Double>> keyExternal : resultsJabuti.entrySet()) {
			mapInternal = new HashMap<String, Double>();
			HashMap<String, Double> mapInternalData = (HashMap<String, Double>) keyExternal.getValue();

			for (Entry<String, Double> keyInternal : mapInternalData.entrySet()) {
				// mapInternal.put(keyInternal.getKey(),
				// keyInternal.getValue());
				if (CreateArtificialARFF.dataresultsJanutiMujava.containsKey(keyExternal.getKey())) {
					CreateArtificialARFF.dataresultsJanutiMujava.get(keyExternal.getKey()).put(keyInternal.getKey(),
							keyInternal.getValue());
					
				}

			}
		}
	}

	public String labelCriterion(String criterio) {
		String labelCriterion = null;
		switch (criterio) {
		case "All-Pot-Uses-ei":
			labelCriterion = "PUSES";
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

}
