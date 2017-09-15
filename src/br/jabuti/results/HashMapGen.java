package br.jabuti.results;

import java.util.HashMap;
import java.util.Map;

import br.jabuti.criteria.AbstractCriterion;
import br.jabuti.criteria.Criterion;
import br.jabuti.project.TestCase;

public class HashMapGen {

    Map<String, String> results = new HashMap<String, String> ();
    
	public HashMapGen() {
		
	}

	public void createObjectsHash(TestCase tc){
		
		results.put(tc.getLabel(), "0.0");
		
		for (int k = 0; k < Criterion.NUM_CRITERIA; k++ ) {
			
			if(tc.getTestCaseCoverage(k).getPercentage() > 0.0){
				
				String per = new Float( tc.getTestCaseCoverage(k).getPercentage() ).toString();
	
				results.put(AbstractCriterion.getName(k), per);
				
				}

		}
		
		//imprimir a map
		for (String key : results.keySet()) {
            
            String value = results.get(key);
            System.out.println(key + " = " + value);
		}
		
	}
		


}

