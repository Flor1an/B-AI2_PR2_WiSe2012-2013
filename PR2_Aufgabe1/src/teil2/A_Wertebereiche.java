package teil2;

public class A_Wertebereiche {
	public static void main(String[] args){

		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;		
		
		System.out.println("MAX_VALUE: " + max);
		System.out.println("MIN_VALUE: " + min);

		System.out.println();
		
		System.out.println("Binaerdarstellung Integer MAX_VALUE: " + Integer.toBinaryString(max));
		System.out.println("Binaerdarstellung Integer MIN_VALUE: " + Integer.toBinaryString(min));
		System.out.println();
		
		/*
		Integer hat einen festen Wertebereich. Wird dieser
		überschritten (Zahlenkreis), dann ist der 
		MAX_VALUE + 1 == dem MIN_VALUE
		FEHLER IN DER BERECHNUNG
		*/
		System.out.println("MAX_VALUE + 1: " + (max + 1));
		System.out.println("MIN_VALUE - 1: " + (min - 1));
		System.out.println();
		
		/*
		Positive dezimale Zahl zwei minus dem MAX_VALUE
		ergibt ein richtiges Ergebnis
		KEIN FEHLER IN DER BERECHNUNG 
		*/
		System.out.println("2 - MAX_VALUE " + (2 - max));
		System.out.println();
		
		/*
		Ergibt den MIN_VALUE. Das ergebnis der Berechnug ist richtig
		*/
		System.out.println("-1 - MAX_VALUE: " + (-1 - max));
		System.out.println();
		
		/*
		Ergibt den MAX_VALUE. Hierbei wird der Zahlenkreis überschritten.
		FEHLER IN DER BERECHNUNG
		*/
		System.out.println("-2 - MAX_VALUE: " + (-2 - max));
		System.out.println("-1 - MIN: " + (-1 - min));
		System.out.println();
		
		/*
		Doppelte überschreitung des Zahlenkreises.
		FEHLER IN DER BERECHNUNG
		*/
		System.out.println("2 * MAX_VALUE: " + (2 * max));
		System.out.println("2 * MIN_VALUE: " + (2 * min));
		System.out.println();
		
		/*
		Doppelte überschreitung des Zahlenkreises.
		FEHLER IN DER BERECHNUNG
		*/
		System.out.println("4 * MAX_VALUE: " + (4 * max));
		System.out.println("4 * MIN_VALUE: " + (4 * min));
		System.out.println();
	}
}
