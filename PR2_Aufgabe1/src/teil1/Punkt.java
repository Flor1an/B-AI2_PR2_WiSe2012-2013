package teil1;

public class Punkt {

	private double x;
	private double y;
	
	public Punkt(double x, double y){
		this.x = x;
		this.y = y;
	}

	public double abstand(Punkt p){
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));		
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public String toString(){
		return "(" + this.x + "," + this.y + ")";
	}
	
}