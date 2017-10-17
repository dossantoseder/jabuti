package airtesting.wekautil.classification;

import java.io.FileReader;

import weka.classifiers.trees.J48;
import weka.core.*;

public class CassifierJ48 {

	public static void main(String[] args) throws Exception {
		// Carregando base(arquivo ARFF) de flores íris .
		FileReader reader = new FileReader("C:/weka/iris.arff");
		Instances instâncias = new Instances(reader);
		instâncias.setClassIndex(4);

		// Criação do classificador baseado em árvores de decisão .
		J48 árvore = new J48();
		árvore.buildClassifier(instâncias);

		System.out.println(árvore);

		//System.out.println(árvore.toSource(" ClassificadorJ48 "));

		// classificação de cada dado original com esta rede .
		int corretas = 0;
		for (int i = 0; i < instâncias.numInstances(); i++) {
			Instance instância = instâncias.instance(i);
			// Classificação da instância .
			int classe = (int) (árvore.classifyInstance(instância));
			if (classe == (int) instância.classValue())
				corretas++;
		}
		// Relatório simples :
		System.out.println("De " + instâncias.numInstances() + " instâncias , " + corretas + " ("
				+ (100. * (corretas / (1.0 * instâncias.numInstances()))) + "%) foram classificadas corretamente .");
	}

}
