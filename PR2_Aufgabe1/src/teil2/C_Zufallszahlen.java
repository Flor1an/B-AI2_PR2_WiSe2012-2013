package teil2;

import java.util.Arrays;

public class C_Zufallszahlen{
	
	private double[] ary = new double[5];
	
	public C_Zufallszahlen(){
		for(int i = 0; i<ary.length; i++){
			ary[i] = Math.random() * 1;
		}
		Arrays.sort(this.ary);
	}
	
	public double max(){
		return this.ary[ this.ary.length - 1 ];
	}
	
	public double min(){
		return this.ary[ 0 ];		
	}
	
	public double average(){
		double ave = 0;
		for(int i = 0; i<this.ary.length; i++){
			ave += this.ary[i];
		}
		return ave / this.ary.length;
	}
	
	public String toString(){
		return Arrays.toString(ary) + "\nmin: " + this.min() + "\nmax: " + this.max() + "\naverage: " + this.average();
	}
	
	
}
