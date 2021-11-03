package OOP21.Ristorante;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Date data = new Date();
    	
        GestioneRistorante gestione = new GestioneRistorante();
        gestione.AddCliente("Luca", "Pastore", "Via Palmiro Togliatti 36", "3492490930", 20);
        gestione.AddOrdine("Ciao", data, 1.0, 3.0, new Cliente("Tommaso", "De Solda", "Via Locatelli 55", "3458392093", 10),
        					2.0, "past","gag" , "fagiol", 0.0);
        
        System.out.println("CIAO TOMMY");
    }
}
