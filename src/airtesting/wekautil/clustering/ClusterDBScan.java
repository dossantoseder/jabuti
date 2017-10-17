package airtesting.wekautil.clustering;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import weka.core.*;
import weka.*;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.DBSCAN;

public class ClusterDBScan {

	public static void main(String[] args) throws Exception {

		DBSCAN DBSCAN = new DBSCAN();
		
		FileReader reader = new FileReader("C:/weka/airtesting.arff");
		Instances iData = new Instances(reader);
		DBSCAN.setMinPoints(6);
		DBSCAN.setEpsilon(0.05);
		DBSCAN.buildClusterer(iData);
		
		ClusterEvaluation eval = new ClusterEvaluation();
		eval.setClusterer(DBSCAN);
		eval.evaluateClusterer(iData);
		
		writerARFF(eval);
		System.out.println(eval.clusterResultsToString());

	}
	
	public static void writerARFF(ClusterEvaluation eval) {
		BufferedWriter writer;
		try {
			// verificar se o diretótio e o arquivo existem
			FileWriter fw = new FileWriter("C:/weka/airtesting_DBSCAN.arff");
			fw.write(eval.clusterResultsToString());
			fw.flush();
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
