package it.unisa.magazzino;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Prodotto {
	private String nome;
	private String produttore;
	private String distributore;
	private double costo_per_confezione;
	private int quantita;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProduttore() {
		return produttore;
	}
	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}
	public String getDistributore() {
		return distributore;
	}
	public void setDistributore(String distributore) {
		this.distributore = distributore;
	}
	public double getCosto_per_confezione() {
		return costo_per_confezione;
	}
	public void setCosto_per_confezione(double costo_per_confezione) {
		this.costo_per_confezione = costo_per_confezione;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public Prodotto(String nome, String produttore, String distributore, double costo_per_confezione, int quantita) {
		super();
		this.nome = nome;
		this.produttore = produttore;
		this.distributore = distributore;
		this.costo_per_confezione = costo_per_confezione;
		this.quantita = quantita;
	}
	public Prodotto(Prodotto prodotto) {
		super();
		this.nome = prodotto.nome;
		this.produttore = prodotto.produttore;
		this.distributore = prodotto.distributore;
		this.costo_per_confezione = prodotto.costo_per_confezione;
		this.quantita = prodotto.quantita;
	}
	
	@Override
	public String toString() {
		return "Prodotto [nome=" + nome + ", produttore=" + produttore + ", distributore=" + distributore
				+ ", costo_per_confezione=" + costo_per_confezione + ", quantita=" + quantita + "]";
	}
	
	public static Prodotto createIntance(InputStream in) {
		String[] param = new String[3];
		int quantita = 0;
		double costo = 0.0;
		System.out.println("-- Product creation, specify name,producer,distributor,cost,quantity");
		
		StreamTokenizer tok = new StreamTokenizer(new InputStreamReader(in));
		int i = 0;
		try {
			int currentToken = tok.nextToken();
			while((currentToken != StreamTokenizer.TT_EOL) || (currentToken != StreamTokenizer.TT_EOF)) {
				if(tok.ttype == StreamTokenizer.TT_WORD) {
					if(i < 3)
						param[i++] = tok.sval;
				} else if(tok.ttype == StreamTokenizer.TT_NUMBER) {
					double value = tok.nval;
					if(value != Math.floor(value))
						costo = value;
					else {
						quantita = (int) value;
						break;
					}
				}
				currentToken = tok.nextToken();
			}
		} catch(IOException ex) {
			System.err.println(ex.getMessage());
		}
						
		return new Prodotto(param[0], param[1], param[2], costo, quantita);
	}
}
