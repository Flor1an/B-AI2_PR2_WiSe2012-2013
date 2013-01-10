/**
 * 
 */
package imagefilter;

import processing.core.PImage;

/**
 * @author birgit
 *  Schnittstelle fuer alle ImageFilter
 *
 */
public abstract class AbstractImageFilter {
	
	/**
	 * 
	 * @param in  das Originalbild als PImage
	 * @param matrix eine Filtermatrix
	 * @param factor Faktor mit dem die aufsummierten Farbbestandteile gewichtet werden
	 * @return das gefilterte Bild als PImage
	 */
	abstract PImage doFilter(PImage in, AbstractFilterMatrix matrix, double factor);
}
