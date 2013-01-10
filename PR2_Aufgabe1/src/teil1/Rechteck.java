package teil1;

public class Rechteck extends Figur {

	private Punkt p;
	private double hoehe;
	private double breite;
	
	public Rechteck(Punkt p, double hoehe, double breite){
		this.p = p;
		this.hoehe = hoehe;
		this.breite = breite;
	}
	
	public Rechteck(Punkt p, double hoehe){
		this(p, hoehe, 1);
	}
	
	public Rechteck(Punkt p){
		this(p, 1, 1);
	}
	
	public boolean in(Punkt p){
		return this.p.getX() <= p.getX() && p.getX() <= this.p.getX() + this.breite && this.p.getY() <= p.getY() && p.getY() <= this.p.getY() + this.hoehe;
	}
	
	public String toString(){
		return "r(" + this.p + "," + this.hoehe + "," + this.breite + ")";
	}

	public Punkt getP() {
		return p;
	}

	public double getHoehe() {
		return hoehe;
	}

	public double getBreite() {
		return breite;
	}
	
}
