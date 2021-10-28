package oop21.Quadrilateri;

public class Rettangolo extends RettangoloBase implements Comparable<RettangoloBase> {
	
	public Rettangolo(double alt, double bas) {
		super(alt, bas);
	}

	@Override
	public int compareTo(RettangoloBase r) {
		
		return (int) (this.area() - r.area());
	}
}
