package it.unisa.magazzino;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import poo21.LinkedList.Implementations.LinkedList;

public class Magazzino<T> {
	private HashMap<String, LinkedList<? extends T>> prodotti;
	
	public void addList(LinkedList<? extends T> lista, String nome) {
		prodotti.put(nome, lista);
	
	}
	
	public boolean removeList(String nome) {
		return prodotti.remove(nome) != null;
	}
	
	public List<? extends T> getList(String nome) {
		return prodotti.get(nome);
	}
	
	public int getProtottiPerCategoria(String categoria) throws NotFound{
		LinkedList<? extends T> lista = prodotti.get(categoria);
		if(lista == null) {
			throw new NotFound("Categoria " + categoria + "manca");
		} else {
			return lista.size();
		}
	}

	public Magazzino(HashMap<String, LinkedList<? extends T>> prodotti) {
		super();
		this.prodotti = prodotti;
	}
	
	public Magazzino() {
		this.prodotti = new HashMap <>();
	}

	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append("{Magazzino:");
		for(String nome_classe_prodotto : prodotti.keySet()) {
			buff.append(" (classe= " + nome_classe_prodotto + ": ");
			for(Iterator<? extends T> it = prodotti.get(nome_classe_prodotto).iterator();
					it.hasNext(); ) {
				buff.append(it.next().toString());
			}
			buff.append(")");
		}
		buff.append("}");
		return buff.toString();
	}
}
