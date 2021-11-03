package oop21.disegnaFigure;

import java.util.*;

public class Triangolo implements IFigura {
    Punto[] p = new Punto[3];
    
    public Triangolo(Punto p1, Punto p2, Punto p3) {
    	this.p[0] = p1;
    	this.p[1] = p2;
    	this.p[2] = p3;
    	
    }
    public int inserisciPunto(Punto punto) throws Exception{
        int i = 0;
        for( i = 0; i < 3; i++)
        	if (this.p[i].equals(punto) == 1) 
        		throw new Exception("Punto già presente!"); 
        		
        	
        i = 0;
        try {
            if (this.p[i] == null) 
            	this.p[i] = punto;
            else
                i++;
 
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        
    //restituisce l'indice del punto aggiunto
    return i;
    }
 
    public void rimuoviPunto(int pos) throws Exception{
        try {
            this.p[pos] = null;
 
        } catch (Exception e){
            e.printStackTrace();
        }
    }
 
 
    public Punto baricentro(){
        if (this.p[0] == null || this.p[1] == null || this.p[2] == null)
            return new Punto(0,0);
 
        double x = (this.p[0].getx() + this.p[1].getx() + this.p[2].getx()) / 3;
        double y = (this.p[0].gety() + this.p[1].gety() + this.p[2].gety()) / 3;
        return new Punto(x,y);
    }
    
    @Override
    public String toString() {
    	String buff = "Sono un triangolo formato dai punti: " + p[0].toString() + ", " + p[1].toString() + ", " + p[2].toString();
    	return buff;
    }
}


