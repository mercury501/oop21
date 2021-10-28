package oop21.Quadrilateri;

public class Quadrato extends RettangoloBase implements Comparable<RettangoloBase> {
	
	private Quadrato(double bas, double alt) {
		super(alt, bas);
	}
	
	public Quadrato(double lt) {
		super(lt, lt);
	}
	
	@Override
	public void setBase(double bas) {
		super.setBase(bas);
		super.setAltezza(bas);
	}
	
	@Override
	public void setAltezza(double alt) {
		super.setBase(alt);
		super.setAltezza(alt);
	}
	
	@Override
	public String toString() {
		return "Sono un quadrato di area:  " + this.area();
	}

	@Override
	public int compareTo(RettangoloBase r) {
		
		return (int) (this.area() - r.area());
	}
	
}
