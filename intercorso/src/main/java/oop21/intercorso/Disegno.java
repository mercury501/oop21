package oop21.intercorso;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Disegno {
	private HashMap<String, poligono> listaPoligoni = new HashMap<>();
	
	public void inserisciPoligono(String s, poligono p) {
		listaPoligoni.put(s, p);
	}
	
	public void rimuoviPoligono(String s) {
		listaPoligoni.remove(s);
	}
	
	public double mediaPerimetri() throws Exception {
		double perimetroMedio = 0;
		Set<String> n = listaPoligoni.keySet();
		Iterator<String> it = n.iterator();
		while(it.hasNext()) {
			perimetroMedio += listaPoligoni.get(it.next()).calcolaPerimetro();
		}
		
		perimetroMedio = perimetroMedio / listaPoligoni.size();
		return perimetroMedio;
	}
}
