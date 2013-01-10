package teil2;

public class H_Zahlenumwandlung {
	
	int n,k,mod;
	String result;
	
	public H_Zahlenumwandlung(int n, int k){
		this.n = n;
		this.k = k;

		this.result = "Dezimal: " + n + "; Basis: " + k + " ";
		
		String steps = "";
		while(n > 0){
			this.mod = n%k;
			steps = ((k > 10 && this.mod > 9) ? (char)(55 + this.mod) : String.valueOf(this.mod)) + steps;
			n = (int)Math.floor( n / k ); // n/k;
		}
		this.result += "Ergebnis: " + steps;
	}

	public String toString(){
		return this.result;
	}
}
