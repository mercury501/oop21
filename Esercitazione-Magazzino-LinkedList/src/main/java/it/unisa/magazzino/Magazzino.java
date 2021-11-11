package it.unisa.magazzino;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;


public class Magazzino<T> {
	
	private LinkedList<List<? extends T>> prodotti;
	private ArrayList<String> categorie;

	public void addList(List<? extends T> lista, String nome) {
		prodotti.add(lista);
		categorie.add(nome);
	}
	
	public boolean removeList(String nome) {
		int ind = categorie.indexOf(nome);
		return prodotti.remove(ind) != null;
	}
	
	public List<? extends T> getList(String nome) {
		int ind = categorie.indexOf(nome);
		return prodotti.get(ind);
	}
	
	public int getProtottiPerCategoria(String categoria) throws NotFound{
		
		int ind = categorie.indexOf(categoria);
		List<? extends T> lista = prodotti.get(ind);
		
		if(lista == null) {
			throw new NotFound("Categoria " + categoria + "manca");
		} else {
			return lista.size();
		}
	}

	public Magazzino(LinkedList<List<? extends T>> prodotti, ArrayList<String> categorie) {
		super();
		this.prodotti = prodotti;
		this.categorie = categorie;
	}
	
	public Magazzino() {
		this.prodotti = new LinkedList <>();
		this.categorie = new ArrayList<>();
	}

	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append("{Magazzino:");
		
		for(String nome_classe_prodotto : this.categorie) {
			buff.append(" (classe= " + nome_classe_prodotto + ": ");
			for(Iterator<? extends T> it = prodotti.get(this.categorie.indexOf(nome_classe_prodotto)).iterator();
					it.hasNext(); ) {
				buff.append(it.next().toString());
			}
			buff.append(")");
		}
		buff.append("}");
		return buff.toString();
	}
}
