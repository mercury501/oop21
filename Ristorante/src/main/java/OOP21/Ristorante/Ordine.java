package OOP21.Ristorante;

import java.util.Date;

public class Ordine  {

	
	private String descrizione;
	private Date data;
	private double quantita_primo;
	private double quantita_secondo;
	private double quantita_terzo;
	
	private String antipasto;
	private String primo;
	private String secondo;
	
	private Cliente c;
	private double punteggio = 0;
	
	public Ordine(String descrizione, Date data, double quantita_primo, double quantita_secondo, Cliente c,
					double quantita_terzo, String antipasto, String primo, String secondo, double punteggio) {
		
		this.descrizione = descrizione;
		this.data = data;
		this.quantita_primo = quantita_primo;
		this.quantita_secondo = quantita_secondo;
		this.quantita_terzo = quantita_terzo;
		this.antipasto = antipasto;
		this.primo = primo;
		this.secondo = secondo;
		this.c = c;
		this.punteggio = punteggio;
		
	}
	
	
	
	public Cliente getCliente ()
	{
		return this.c;
	}
	
	public void setCliente(Cliente c)
	{
		this.c = c;
	}
	
	public Date getDate() {
		return this.data;
	}
	
	public void setDate(Date data) {
		
		this.data = data;
	}
	
	
	public double CalcolaTotOrdine() {
		
		return (5*this.quantita_primo)+ (10*this.quantita_secondo)+ (13*this.quantita_terzo);
	}
	
	public int PuntiOrdine()
	{
		if(this.CalcolaTotOrdine() >= 50 && this.CalcolaTotOrdine() < 100)
		{
			return 10;
		}
		
		if(this.CalcolaTotOrdine() >= 100)
		{
			return 30;
		}
		
		return 0;
			
	}


}
