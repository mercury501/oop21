package oop21.intercorso;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class poligono {
	ArrayList<Punto> listaPunti = new ArrayList<>();
	int maxPunti;
	
	public poligono(int m) {
		this.maxPunti = m;
	}
	
	public int inserisciPunto(Punto punto) throws Exception {
		if (maxPunti == listaPunti.size())
			throw new Exception();
		if (listaPunti.contains(punto))
			throw new Exception();
		listaPunti.add(punto);
		return listaPunti.size() - 1;
	}
	
	
	
	public int maxPunti() {
		return this.maxPunti;
	}
	
	public void rimuoviPunto(int pos) throws Exception {
		if (listaPunti.size() - 1 < pos)
			throw new Exception();
		listaPunti.remove(pos);
	}
	
	public Punto getPunto(int index) {
		return listaPunti.get(index);
	}
	
	public double calcolaPerimetro() throws Exception {
		if (this.maxPunti > listaPunti.size())
			throw new Exception();
		double perimetro = 0;
		Iterator<Punto> it = listaPunti.iterator();
		Punto primo = it.next();
		Punto tmp1 = primo;
		while (it.hasNext()) {
		Punto tmp2 = it.next();
		perimetro += tmp1.distanzaPunti(tmp2);
		
		tmp1 = tmp2;
		
		}
		
		perimetro += tmp1.distanzaPunti(primo);
		return perimetro;
	}
	
	@Override
	public String toString() {
		String tmp = "Sono un triangolo di vertici: ";
		Iterator<Punto> it = listaPunti.iterator();
		while (it.hasNext())
			tmp = tmp + it.next().toString() + ", ";
		return tmp;
	}
}
