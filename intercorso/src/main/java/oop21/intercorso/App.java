package oop21.intercorso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static int controllaRegolarita(ArrayList<poligono> ls) throws Exception {
    	Iterator<poligono> it = ls.iterator();
    	int num_pol_regol = 0;
    	
    	while (it.hasNext()) {
    		poligono pol = it.next();
        	Punto p1 = pol.getPunto(0);
        	Punto p2 = pol.getPunto(1);
        	double lato = p1.distanzaPunti(p2);
        	
        	double mediaLati = pol.calcolaPerimetro() / pol.maxPunti;
        	if (mediaLati == lato)
        		num_pol_regol += 1;
    	}
    	return num_pol_regol;
    }
    
    public static poligono inputPoligono() throws Exception {
    	ArrayList<Punto> lsP = new ArrayList<>();
    	boolean gotOne = false;
    	double x = 0;
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StreamTokenizer st = new StreamTokenizer(br);
    	
    	st.eolIsSignificant(true);
    	st.whitespaceChars(',', ',');
    	
    	System.out.println("Inserire i punti appartenenti al poligono, separati da , '1,3 5,6 ... ");
    	while(st.nextToken() != StreamTokenizer.TT_EOL) {
    		switch(st.ttype) {
    			case StreamTokenizer.TT_NUMBER:
    				if(gotOne) {
    					lsP.add(new Punto(x, st.nval));
    					gotOne = !gotOne;
    				}
    				else {
    					x = st.nval;
    					gotOne = !gotOne;
    				}
    				break;
    			default:
    				System.out.println("Inserisci punti validi.");
    				break;
    		}
    	}
    	
    	switch(lsP.size()) {
    		case 3:
    			Triangolo tri = new Triangolo();
    			for (int i = 0; i < 3; i++)
    				tri.inserisciPunto(lsP.get(i));
    			return tri;
    		case 8:
    			Ottagono ott = new Ottagono();
    			for (int i = 0; i < 8; i++)
    				ott.inserisciPunto(lsP.get(i));
    			return ott;
    		case 5:
    			Pentagono pen = new Pentagono();
    			for (int i = 0; i < 5; i++)
    				pen.inserisciPunto(lsP.get(i));
    			return pen;
    		default:
    			System.out.println("Numnero punti non valido");
    			return null;
	
    	}

    }
	
	
	public static void main( String[] args ) throws Exception
    {
        //ESERCIZIO 1
        Disegno dis = new Disegno();
    	
    	Triangolo tri = new Triangolo();
    	tri.inserisciPunto(new Punto(1,5));
        tri.inserisciPunto(new Punto(4,6));
        tri.inserisciPunto(new Punto(6,8));
        System.out.println(tri.toString());
        
        Pentagono pen = new Pentagono();
        pen.inserisciPunto(new Punto(0,5));
        pen.inserisciPunto(new Punto(1,6));
        pen.inserisciPunto(new Punto(6,8));
        pen.inserisciPunto(new Punto(7,5));
        pen.inserisciPunto(new Punto(9,2));
        System.out.println(pen.toString());
        
    	dis.inserisciPoligono("test", tri);
    	dis.inserisciPoligono("test2", pen);
    	System.out.println("La media dei perimetri è: " + dis.mediaPerimetri());
		
		
		//ESERCIZIO 2
		ArrayList<poligono> lsPol = new ArrayList<>();
    	
        Quadrato q = new Quadrato();
        q.inserisciPunto(new Punto(0,0));
        q.inserisciPunto(new Punto(0,1));
        q.inserisciPunto(new Punto(1,1));
        q.inserisciPunto(new Punto(1,0));

        lsPol.add(q);
        lsPol.add(pen);
        lsPol.add(tri);
        
        
        System.out.println("Numero di poligoni regolari: " + controllaRegolarita(lsPol));

        poligono pol = inputPoligono();
        System.out.println(pol.toString());
        
        //ESERCIZIO 3
        
  
        
    }
}
