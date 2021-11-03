package OOP21.Ristorante;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;


public class GestioneRistorante {

	LinkedList<Ordine> ordine;
	LinkedList<Cliente> cliente;
	
	
	public GestioneRistorante() {
		
		ordine = new LinkedList<>();
		cliente = new LinkedList<>();
	}
	
	public void AddCliente(String nome, String cognome, String indirizzo, String numTel, int tot_punti)
	{
		cliente.add(new Cliente(nome, cognome, indirizzo, numTel, tot_punti));
	}
	
	
	public void AddOrdine(String descrizione, Date data, double quantita_primo, double quantita_secondo, Cliente c,
			double quantita_terzo, String antipasto, String primo, String secondo, double punteggio) {
		
		ordine.add(new Ordine(descrizione,data, quantita_primo,quantita_secondo,c, quantita_terzo,
							antipasto, primo,secondo,punteggio));
	}
	
	
	public LinkedList<Ordine> searchClient (LinkedList<Ordine> out, Cliente c)
	{
		LinkedList <Ordine> output = new LinkedList<>();
		Iterator<Ordine> iter = out.iterator();
		Ordine tmp;
		while(iter.hasNext()) {
			tmp = iter.next();
			
		if(tmp.getCliente().equals(c)) {
			output.add(tmp);
			}
		}
		
		return output;
	}
	
	
	
	public LinkedList <Ordine> searchforDate (LinkedList <Ordine> out, Date data)
	{
		LinkedList <Ordine> output = new LinkedList<>();
		Iterator<Ordine> iter = out.iterator();
		Ordine tmp;
		while(iter.hasNext()) {
			tmp = iter.next();
		
		if(tmp.getDate().equals(data)) {
			output.add(tmp);
		}
	}
		return output;
	}
	
	
	public double CalcolaTotale (Cliente c, Date data) {
		
		LinkedList<Ordine> output = new LinkedList<>();
		output = searchClient(this.ordine,c);
		
		output = searchforDate(output,data);
		
		return output.element().CalcolaTotOrdine();
		
	}
	
	public int TotaleOrdiniperCliente(Cliente c) {
		
		LinkedList<Ordine> output = new LinkedList<>();
		output = searchClient(this.ordine, c);
		
		return output.size();
	}
	
	
	public void CalcoloPunteggio() {
		
		
		LinkedList<Ordine> ordini_cliente = new LinkedList<>();
		Iterator<Cliente> iter = this.cliente.iterator();
		
		Cliente tmp;
		Ordine tmp2;
		int punti_tmp;
		
		while(iter.hasNext()) {
			punti_tmp = 0;
			tmp = iter.next();
			
		ordini_cliente = searchClient(this.ordine, tmp);
		Iterator<Ordine> iteraOrdini = ordini_cliente.iterator();
		
		while(iteraOrdini.hasNext()) {
			tmp2 = iteraOrdini.next();
			
			punti_tmp += tmp2.PuntiOrdine();
		}
		}
		
		
	}
	
	 
	
	
	
	
}
