/**
 * 
 */
package OOP21.Ristorante;

/**
 * @author lucapastore
 *
 */
public class Cliente {

	 private String nome;
	 private String cognome;
	 private String indirizzo;
	 private String numTel;
	 private int tot_punti;
	 
	 
	public Cliente (String nome, String cognome, String indirizzo, String numTel, int tot_punti) {
		
		this.nome = nome;
		this.cognome = cognome; 
		this.indirizzo = indirizzo;
		this.numTel = numTel;
		this.tot_punti = tot_punti;
	}
	

	public String getName() {
		return nome;
	}
	
	public String getSurname() {
		return cognome;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}

	public String getNumTel() {
		return numTel;
	}
	
	public int getTotPunti()
	{
		return tot_punti;
	}
	
	public void setPunti(int tot_punti) {
		
		this.tot_punti = tot_punti;
	}

	public boolean equals (Cliente c)
	{
		if((this.nome == c.getName()) && (this.cognome == c.getSurname())&& (this.indirizzo == c.getIndirizzo())
																	&& (this.numTel == c.getNumTel())) {
			return true;
		}
		
		return false;	
	}
	
}
