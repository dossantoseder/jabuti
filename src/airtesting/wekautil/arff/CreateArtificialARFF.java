package airtesting.wekautil.arff;

import weka.core.Instance;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

import weka.core.*;

public class CreateArtificialARFF {

	private Instances relation;
	private Instance intanceData;
	private FastVector vCasesTest;
	private Attribute casesTest;
	private FastVector attributes;
	// Operadores
	private Attribute AOIS;
	private Attribute AODU;
	private Attribute AOIU;
	private Attribute AORB;
	private Attribute VDL;
	private Attribute SDL;
	private Attribute COI;
	private Attribute COR;
	private Attribute LOI;
	private Attribute ODL;
	private Attribute ROR;
	private Attribute AORS;
	private Attribute AODS;
	private Attribute COD;
	private Attribute SOR;
	private Attribute LOD;
	private Attribute CDL;
	private Attribute LOR;
	private Attribute ASRS;
	// Critérios
	private Attribute NOS;
	private Attribute EDGES;
	private Attribute USES;
	private Attribute PUSES;
	//public static Map<String, Map<String, Double>> resultsJabuti = new HashMap<String, Map<String, Double>>();
	//public static Map<String, Map<String, Double>> resultsMujava = new HashMap<String, Map<String, Double>>();
	public static Map<String, Map<String, Double>> dataresultsJanutiMujava = new HashMap<String, Map<String, Double>>();

	public void creatorRelation(String nomeRelação) {

		// Define dados da relação
		attributes = new FastVector();

		// instancia lista de casos de teste
		this.vCasesTest = new FastVector();
		for (String keyTest : dataresultsJanutiMujava.keySet()) {
			this.vCasesTest.addElement(keyTest);
		}

		// Criando lista de casos de teste
		this.casesTest = new Attribute("Casos de teste", vCasesTest);

		// Método que instancia atributos
		this.instanceAttributes();

		this.attributes.addElement(this.casesTest);

		// Método que adiciona elementos nos atributos
		this.addElementAttributes();

		// Define relação
		this.relation = new Instances(nomeRelação, attributes, 0);
		Map<String, String> operadoreExistentes = new HashMap<String, String>();
		for (Entry<String, Map<String, Double>> kv : dataresultsJanutiMujava.entrySet()) {
			this.intanceData = new Instance(this.relation.numAttributes());
			this.intanceData.setValue(this.casesTest, kv.getKey());

			HashMap<String, Double> secondmap = (HashMap<String, Double>) kv.getValue();

			for (Entry<String, Double> kvv : secondmap.entrySet()) {
				// Setta os valores percentuais dos operadores por teste
				this.setValueIntanceData(kvv.getKey(), kvv.getValue());
			}

			this.relation.add(this.intanceData);
		}
		this.writerARFF(this.relation);
	}

	public void instanceAttributes() {
		// Operadores e Percentual
		this.AOIS = new Attribute("AOIS");
		this.AODU = new Attribute("AODU");
		this.AOIU = new Attribute("AOIU");
		this.AORB = new Attribute("AORB");
		this.VDL = new Attribute("VDL");
		this.SDL = new Attribute("SDL");
		this.COI = new Attribute("COI");
		this.COR = new Attribute("COR");
		this.LOI = new Attribute("LOI");
		this.ROR = new Attribute("ROR");
		this.AORS = new Attribute("AORS");
		this.AODS = new Attribute("AODS");
		this.COD = new Attribute("COD");
		this.SOR = new Attribute("SOR");
		this.LOD = new Attribute("LOD");
		this.CDL = new Attribute("CDL");
		this.LOR = new Attribute("LOR");
		this.ASRS = new Attribute("ASRS");
		this.ODL = new Attribute("ODL");
		// Critérios
		this.NOS = new Attribute("NOS");
		this.EDGES = new Attribute("EDGES");
		this.USES = new Attribute("USES");
		this.PUSES = new Attribute("PUSES");
	}

	public void addElementAttributes() {
		this.attributes.addElement(this.AOIS);
		this.attributes.addElement(this.AODU);
		this.attributes.addElement(this.AOIU);
		this.attributes.addElement(this.AORB);
		this.attributes.addElement(this.VDL);
		this.attributes.addElement(this.SDL);
		this.attributes.addElement(this.COI);
		this.attributes.addElement(this.COR);
		this.attributes.addElement(this.LOI);
		this.attributes.addElement(this.ROR);
		this.attributes.addElement(this.AORS);
		this.attributes.addElement(this.AODS);
		this.attributes.addElement(this.COD);
		this.attributes.addElement(this.SOR);
		this.attributes.addElement(this.LOD);
		this.attributes.addElement(this.CDL);
		this.attributes.addElement(this.LOR);
		this.attributes.addElement(this.ASRS);
		this.attributes.addElement(this.ODL);
		//Critério
		this.attributes.addElement(this.NOS);
		this.attributes.addElement(this.EDGES);
		this.attributes.addElement(this.USES);
		this.attributes.addElement(this.PUSES);

	}

	public void writerARFF(Instances relation) {
		BufferedWriter writer;
		try {
			// verificar se o diretótio e o arquivo existem
			writer = new BufferedWriter(new FileWriter("C:/weka/airtesting.arff"));
			writer.write(relation.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setValueIntanceData(String operador, Double percentual) {
		switch (operador) {

		case "AODU":
			this.intanceData.setValue(this.AODU, percentual);
			break;
		case "AOIS":
			this.intanceData.setValue(this.AOIS, percentual);
			break;
		case "AOIU":
			this.intanceData.setValue(this.AOIU, percentual);
			break;
		case "AORB":
			this.intanceData.setValue(this.AORB, percentual);
			break;
		case "VDL":
			this.intanceData.setValue(this.VDL, percentual);
			break;
		case "SDL":
			this.intanceData.setValue(this.SDL, percentual);
			break;
		case "COI":
			this.intanceData.setValue(this.COI, percentual);
			break;
		case "LOI":
			this.intanceData.setValue(this.LOI, percentual);
			break;
		case "ODL":
			this.intanceData.setValue(this.ODL, percentual);
			break;
		case "ROR":
			this.intanceData.setValue(this.ROR, percentual);
			break;
		case "COD":
			this.intanceData.setValue(this.COD, percentual);
			break;
		case "AORS":
			this.intanceData.setValue(this.AORS, percentual);
			break;
		case "AODS":
			this.intanceData.setValue(this.AODS, percentual);
			break;
		case "SOR":
			this.intanceData.setValue(this.SOR, percentual);
			break;
		case "LOD":
			this.intanceData.setValue(this.LOD, percentual);
			break;
		case "CDL":
			this.intanceData.setValue(this.CDL, percentual);
			break;
		case "LOR":
			this.intanceData.setValue(this.LOR, percentual);
			break;
		case "ASRS":
			this.intanceData.setValue(this.ASRS, percentual);
			break;
		case "COR":
			this.intanceData.setValue(this.COR, percentual);
			break;
		case "EDGES":
			this.intanceData.setValue(this.EDGES, percentual);
			break;
		case "USES":
			this.intanceData.setValue(this.USES, percentual);
			break;
		case "PUSES":
			this.intanceData.setValue(this.PUSES, percentual);
			break;
		case "NOS":
			this.intanceData.setValue(this.NOS, percentual);
			break;
		default:
			System.out.println("Esta opção não é valida!");
		}
	}

}
