package it.unisa.magazzino;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.commons.io.input.CloseShieldInputStream;

public class ProdottoDeperibile extends Prodotto {
	public ProdottoDeperibile(String nome, String produttore, String distributore, double costo_per_confezione,
			int quantita, String provenienza) {
		super(nome, produttore, distributore, costo_per_confezione, quantita);
		this.provenienza = provenienza;
	}
	
	public ProdottoDeperibile(Prodotto prodotto, String provenienza) {
		super(prodotto);
		this.provenienza = provenienza;
	}

	private String provenienza;
	
	public String getProvenienza() {
		return provenienza;
	}

	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}

	@Override
	public String toString() {
		return "ProdottoDeperibile [nome=" + getNome() + ", produttore="
				+ getProduttore() + ", distributore=" + getDistributore() + ", costo_per_confezione="
				+ getCosto_per_confezione() + ", quantita=" + getQuantita() + ", provenienza=" + provenienza + "]";
	}
	
	public static ProdottoDeperibile createIntance(InputStream in) {
		System.out.println("-- Perishable Product creation");
		Prodotto prodotto = Prodotto.createIntance(in);
		Scanner scan = new Scanner(CloseShieldInputStream.wrap(in));
		System.out.println(" Indicate provenance: ");
		String provenienza = scan.nextLine();
		scan.close();
						
		return new ProdottoDeperibile(prodotto, provenienza);
	}
}
