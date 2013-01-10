package teil2;

public class B_Operationen {
	public static void main(String[] args){
		
		double d = 3.14159;
		/*
		Funktioniert (Konkatinierung von String und Zahl)
		*/
		System.out.println("d:" + d);
		/*
		keine Mathematische Operation, nur eine String Konkatenation
		*/
		System.out.println("d+1:" + d + 1);
				
		/*
		Integer / Integer = Integer
		d wurde zu integer konvertiert also Nachkommerzahlen abgeschnitten (8/3=2)
		*/
		System.out.println("8/(int)d:" + 8 / (int) d);

		/*
		Integer 
		*/
		System.out.println(8 / d);
		
		/*
		Integer / Double = Double
		Ergebnis ist richtig!
		*/
		System.out.println("8/d:" + 8 / d);
		
		/*
		(Integer / Double) also das Ergebnis wird zu Integer gecastet
		*/
		System.out.println("(int)(8/d):" + (int) (8 / d));
		
		/*
		durch 0 immer infnity
		*/
		System.out.println("8.0/0.0:" + 8.0 / 0.0);
		
		/*
		0 nicht teilbar (nur durch 0) = NaN
		*/
		System.out.println("0.0/0.0:" + 0.0 / 0.0);
		
		/*
		Die Zahl ist so groß, dass sie als unendlich angenommen wird
		*/
		d = 1e308;
		System.out.println(d + "*10==" + d * 10);
		
		/*
		Beim 3 bzw. 4 durchlauf wird wieder der Wertebereich überschritten
		1e-323 = OK
		1e-324 = FEHLER
		*/
		d = 1e-305 * Math.PI;
		System.out.print("d:" + d + "\n");
		for (int i = 0; i < 4; i++){
			System.out.println(i+") " + (d /= 100000));			
		}

		//System.out.println((1/49)*49);
		
		System.out.println();
		for (int i = 0; i < 100; i++) {
			double z = 1.0 / i;
			if (z * i != 1.0)
				System.out.print(" " + i);
		}
		
		/*
		2.0000000000000004 != 2
		*/
		System.out.println( Math.sqrt(2) * Math.sqrt(2) == 2);
		
	}
}
