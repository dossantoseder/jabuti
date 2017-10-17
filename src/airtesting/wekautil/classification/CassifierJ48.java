package airtesting.wekautil.classification;

import java.io.FileReader;

import weka.classifiers.trees.J48;
import weka.core.*;

public class CassifierJ48 {

	public static void main(String[] args) throws Exception {
		// Carregando base(arquivo ARFF) de flores �ris .
		FileReader reader = new FileReader("C:/weka/iris.arff");
		Instances inst�ncias = new Instances(reader);
		inst�ncias.setClassIndex(4);

		// Cria��o do classificador baseado em �rvores de decis�o .
		J48 �rvore = new J48();
		�rvore.buildClassifier(inst�ncias);

		System.out.println(�rvore);

		//System.out.println(�rvore.toSource(" ClassificadorJ48 "));

		// classifica��o de cada dado original com esta rede .
		int corretas = 0;
		for (int i = 0; i < inst�ncias.numInstances(); i++) {
			Instance inst�ncia = inst�ncias.instance(i);
			// Classifica��o da inst�ncia .
			int classe = (int) (�rvore.classifyInstance(inst�ncia));
			if (classe == (int) inst�ncia.classValue())
				corretas++;
		}
		// Relat�rio simples :
		System.out.println("De " + inst�ncias.numInstances() + " inst�ncias , " + corretas + " ("
				+ (100. * (corretas / (1.0 * inst�ncias.numInstances()))) + "%) foram classificadas corretamente .");
	}

}
