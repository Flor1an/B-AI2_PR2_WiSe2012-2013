package imagefilter;

import processing.core.PImage;

/**
 * 
 * @author birgit 
 *
 */
public class DummyImageFilter extends AbstractImageFilter {

	/**
	 * @return Methode tut nichts, gibt nur das Original Bild zurück
	 */
	@Override
	PImage doFilter(PImage in, AbstractFilterMatrix matrix, double factor) {
		return in;
	}

}
