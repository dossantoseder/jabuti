package airtesting.wekautil.clustering;

import java.io.FileReader;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.EM;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.AddCluster;
import weka.filters.unsupervised.attribute.Remove;

public class GroupingEM {
	public static void main(String[] args) {
		try {

			FileReader reader = new FileReader("C:/weka/airtesting.arff");
			Instances iData = new Instances(reader);

			/*String[] flores = { "Iris-virginicae", "Iris-virginica", "Iris-versicolor", "Iris-setosa", "Iris-setosa",
					"Iris-setosa", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-setosa",
					"Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-virginica" };
			
			// load data
			Instances iData = DataSource.read(flores[0]);*/
			iData.setClassIndex(iData.numAttributes() - 1);

			// generate data for clusterer (w/o class)
			Remove filter = new Remove();
			filter.setAttributeIndices("" + (iData.classIndex() + 1));
			filter.setInputFormat(iData);
			Instances dataClusterer = Filter.useFilter(iData, filter);

			// train clusterer
			EM clusterer = new EM();
			// set further options for EM, if necessary...
			clusterer.buildClusterer(dataClusterer);

			// evaluate clusterer
			ClusterEvaluation eval = new ClusterEvaluation();
			eval.setClusterer(clusterer);
			eval.evaluateClusterer(iData);
			weka.filters.unsupervised.attribute.AddCluster t = new AddCluster();
			
			Attribute attribute = new Attribute(null);
			t.getIgnoredAttributeIndices();
			t.setIgnoredAttributeIndices(null);
			// print results
			System.out.println(eval.clusterResultsToString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
