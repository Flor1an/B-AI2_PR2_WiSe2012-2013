package teil2;

public class G_Potenzen {
	public static void main(String[] args){


		int n = 37;
		long pow = 1;
		int z=0;
				
	
		while(pow <= Long.MAX_VALUE /n){
			
			System.out.println(n + "^" + z + "=\t" + pow);
			pow = pow * n;
			z++;
			
		}
		System.out.println(n + "^" + z + "=\t" + pow);
		System.out.println("Überlauf bei " + n + "^" + (z+1) + " (= " + (pow*n) + ")");
		
		
	}
}
