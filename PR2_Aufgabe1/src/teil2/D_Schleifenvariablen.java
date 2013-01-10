package teil2;


public class D_Schleifenvariablen {
	
	
	public static void main(String[] args) {
		int i, j;
		for (i = 0, j = 0; i < 10; i++) j += i; // i wird von 0 bis 9 hochgezählt    j wird aufadiert bis 36
		for (i = 0, j = 1; i < 10; i++) j += j; // j wird mit sich selbst addiert bis 1024 (10 schritte i=9)
		for (j = 0; j < 10; j++)j += j;			// j wird mit sich selbst addiert bis 14 da abbruchbedingung j < 10
		for (i = 0, j = 0; i < 10; i++) {
			j += j++;							// es passiert nichts, da j=0 und dies wird erhöht (muss jedoch j=1 sein damits funktioniert)
		}

	}
}
