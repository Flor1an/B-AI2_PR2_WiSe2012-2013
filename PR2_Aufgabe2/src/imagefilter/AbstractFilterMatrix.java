package imagefilter;

/**
 * 
 * @author birgit Schnittstelle fuer Filtermatrizen
 */
abstract class AbstractFilterMatrix {

	/**
	 * 
	 * @return Hoehe der Matrix, die Anzahl der Zeilen der Marix
	 */
	public abstract int getHeight();

	/**
	 * 
	 * @return Breite der Matrix, die Anzahl der Spalten der Matrix
	 */
	public abstract int getWidth();

	/**
	 * 
	 * @param y
	 *            die Zeile des Elementes
	 * @param x
	 *            die Spalte des Elementes
	 * @return ein Element der Matrix
	 */
	public abstract int getElem(int y, int x);
}