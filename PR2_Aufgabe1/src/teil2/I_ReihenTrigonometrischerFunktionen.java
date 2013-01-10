package teil2;

public class I_ReihenTrigonometrischerFunktionen {
	public static void main(String[] args){
		
		int x = 3;
		
		int i = 1;
		double sin = x;
		double cos = 1;
		double current = 0;
		double previous = current + 1;
		boolean plus = false;
		
	
		
		while(current != previous && i <= 100){
			
		
			System.out.println("i=" + i + " cur=" + current + "\t\t sin=" + sin + "  \t\t cos="+cos);
			
			if(plus){
				plus = false;
				sin += (Math.pow(x, (2*i+1))) / faculty(2*i+1);
				cos += (Math.pow(x, (2*i))) / faculty(2*i);
			}else{
				plus = true;
				sin -= (Math.pow(x, (2*i+1))) / faculty(2*i+1);
				cos -= (Math.pow(x, (2*i))) / faculty(2*i);
			}
			
			previous = current;
			current = sin / cos;
			
	
			
			i++;
		}
		
	}
	
	public static long faculty (int n){
	  return n == 0 ? 1 : n * faculty (n-1);
	}
	
	
	
	
}
