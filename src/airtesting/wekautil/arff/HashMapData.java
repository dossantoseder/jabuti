package airtesting.wekautil.arff;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapData {
	
	private HashMap<String, Integer> class_counts;
    private HashMap<String, HashMap<String, Integer>> class_feature_counts;
    private HashMap<String, Integer> results;
    private HashMap<String, Integer> resultsAUX = new HashMap<String, Integer>();
	
	HashMapData(HashMap<String, Integer> results){
		class_counts = new HashMap<String, Integer>();
		class_feature_counts = new HashMap<String, HashMap<String, Integer>>();
		this.results = results;
	}

	
	public HashMap<String, Integer> getResults() {
		return results;
	}


	public void setResults(HashMap<String, Integer> results) {
		this.results = results;
	}


	public void populaHashMap(){
		for (String keyLK : results.keySet()) {
			if(results.get(keyLK) == 0.0){
				
				
			}else if(results.get(keyLK) > 0){
				
			}else{
				
			}
			//class_feature_counts.put(arg0, arg1)
			
			//class_feature_counts.put("myKey", val);
			
			
			System.out.println("Chave: " + keyLK + " - " + "Valor: " + results.get(keyLK));
		    //class_feature_counts.put("myKey", val);
			
		}
	}
	
	public void reescreveMap(){
		
	}
	

}
