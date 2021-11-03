package oop21.disegnaFigure;

public class Punto {
	 double x,y;
	 
    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }
 
    public double getx(){
        return this.x;
    }
 
    public double gety(){
        return this.y;
    }
    
    public int equals(Punto p) {
    	if (this.x == p.getx() && this.y == p.gety())
    		return 1;
    	return 0;
    }
    
    @Override
    public String toString() {
    	String buff = "[" + this.getx() + ", " + this.gety() + "]";
    	return buff;
    }
}
