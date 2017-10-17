package airtesting.rtesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Teste {
	public static void main(String[] args) {
		ArrayList<String> numeros = new ArrayList<String>();
		numeros.add("Flamengo"); // 1
		numeros.add("Vasco"); // 1
		numeros.add("Flamengo"); // 1
		numeros.add("Bahia"); // 1
		numeros.add("bahia"); // 2
		numeros.add("Flamengo"); // 2
		numeros.add("Flamengo"); // 2
		numeros.add("São Paulo"); // 3
		numeros.add("Flamengo"); // 2
		numeros.add("Flamengo"); // 4
		numeros.add("Flamengo"); // 3
		numeros.add("Palmeiras"); // 4
		numeros.add("Flamengo"); // 3
		numeros.add("Flamengo"); // 5
		numeros.add("São Paulo"); // 5
		numeros.add("São Paulo"); // 3
		Set<String> numerosSemRepeticoes = new HashSet<String>(numeros);
		Iterator<String> iteradorDeNumerosSemRepeticoes = numerosSemRepeticoes
				.iterator();
		while (iteradorDeNumerosSemRepeticoes.hasNext()) {
			System.out.println(Collections.frequency(numeros,
					iteradorDeNumerosSemRepeticoes.next()));
		} // while
	} // main
}
