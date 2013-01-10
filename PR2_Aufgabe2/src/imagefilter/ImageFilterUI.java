package imagefilter;


import processing.core.PApplet;
import processing.core.PImage;

public class ImageFilterUI extends PApplet {
	private static final long serialVersionUID = 1L;
	PImage original;
	
	public void setup() {
		
		original = loadImage("blumenwiese.jpg"); // Bild laden - muss im
													// Verzeichnis data liegen
		size(original.width * 2 + 10, original.height); // Groesse des Fensters

		image(original, 0, 0); // Originalbild anzeigen

		// Filter einlesen und Filterobjekt erzeugen		
		String[] inArgs = this.args;	
		Filter f = Filter.valueOf(inArgs[0]);
		
		// TODO Filtermatrix und ImageFilter erzeugen
		
		AbstractFilterMatrix fm = new FilterMatrix(f);  // TODO
		AbstractImageFilter aif = new ImageFilter(); // TODO hier  mit
		// einer konkreten und sinvollen ImageFilterKlasse initialisieren

		// Filter anwenden und Ergebnis anzeigen mit Offset für die x Achse
		// Ergebnisbild liegt neben dem Original

		image(aif.doFilter(original, fm, 1), original.width + 10, 0);
	}

}
