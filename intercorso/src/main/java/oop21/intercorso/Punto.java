package oop21.intercorso;
import java.lang.Math;

public class Punto {
	double x,y;
	
	public Punto(double a, double b) {
		this.x = a;
		this.y = b;
	}
	
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public void setX(double a) {
		this.x = a;
	}
	public void setY(double b) {
		this.y = b;
	}
	public double distanzaPunti(Punto p) {
		double distanza = ((this.x - p.getX()) * (this.x - p.getX())) + ((this.y - p.getY()) * (this.y - p.getY()));
		distanza = java.lang.Math.cbrt(distanza);
		return distanza;
		
	}
	
	@Override
	public String toString() {
		return "Punto x: " + this.x + ", y: " + this.y;
	}
}
