package teil1;

public class Kreis extends Figur{
	
	private Punkt mitte;
	private double radius;
	
	public Kreis(Punkt mitte, double radius){
		this.mitte = mitte;
		this.radius = radius;
	}
	
	public Kreis(Punkt mitte){
		this(mitte, 1);
	}
	
	
	public String toString(){
		return "k(" + this.mitte.toString() + "," + this.radius + ")";
	}

	public Punkt getMitte() {
		return mitte;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public boolean in(Punkt p) {
		return this.mitte.abstand(p) < this.radius;
	}
	
	

}
