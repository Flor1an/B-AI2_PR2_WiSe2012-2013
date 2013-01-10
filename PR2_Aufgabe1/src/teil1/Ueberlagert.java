package teil1;

public class Ueberlagert {
	
	private Figur oben;
	private Figur unten;
	
	public Ueberlagert(Figur oben, Figur unten){
		this.oben = oben;
		this.unten = unten;
	}
	
	public boolean in(Punkt p){
		return this.oben.in(p) || this.unten.in(p);
	}
	
	public String toString(){
		return "ue(o=>" + this.oben + " u=>" + this.unten + ")";
	}

}
