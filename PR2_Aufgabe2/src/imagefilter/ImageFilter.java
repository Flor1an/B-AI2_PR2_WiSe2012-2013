package imagefilter;

import java.util.*;

import processing.core.PImage;

public class ImageFilter extends AbstractImageFilter {

	public void print(Object obj){
		//System.out.println(obj);
	}
	
	public PImage doFilter(PImage in, AbstractFilterMatrix matrix, double factor){

		// debug
		print("ImageFilter.java");
		print( "Pixel:" + in.height * in.width );
		
		// init vars
		int iW = in.width,
			iH = in.height,
			fW = matrix.getWidth(),
			fH = matrix.getHeight(),
			foX = fW/2,
			foY = fH/2,
			start = (foX * iW) + foX,
			stop = (iW * iH) - (foY * iW) - foX;

		// accumulate factor
		double sum = 0;
		for(int y=0; y<matrix.getHeight(); y++){
			for(int x=0; x<matrix.getWidth(); x++){
				sum += matrix.getElem(x, y);
			}
		}
		sum = sum == 0 ? 1 : sum; 
		factor /= sum;
		
		// debug
		System.out.println("foX: " + foX + " foY: " + foY + " factor: " + factor);
		print("start: " + start + " stop: " + stop + "\n");
		
		// clone pixels array
		int[] newPixels = in.pixels.clone();
		
		// loop from start to stop (colum)
		while(start <= stop){
			// loop by row
			for(int x=foX; x<(iW-foX); x++){
				
				// init vars
				int y = start / iW,
					cell = in.get(x,y);

				// debug
				print("Berechnung fÙr: (" + x + "," + y + ")");
				print("Alt: r=" + (cell>>16 & 0xFF) + " g=" + (cell>>8 & 0xFF) + " b=" + (cell>>0 & 0xFF) + " // " + cell);
				//print( Integer.toBinaryString(cell) );

				// init vars
				int	mValue,
					sColor,
					sA = 0,
					sRed = 0,
					sGreen = 0,
					sBlue = 0;
			
				// accumulate neighbors
				for(int mY=(y-foY), iY=0; iY<fH; mY++, iY++){
					for(int mX=(x-foX), iX=0; iX<fW; mX++, iX++){				
						mValue = matrix.getElem(iX, iY);
						sColor = in.get(mX, mY);
						
						// -14919288 = 1111 1111 0001 1100 0101 1001 1000 1000 & (0xFF = 1111 1111)
						sA += mValue * (sColor>>24 & 0xFF);
						sRed += mValue * (sColor>>16 & 0xFF);
						sGreen += mValue * (sColor>>8 & 0xFF);
						sBlue += mValue * (sColor>>0 & 0xFF);
					}
				}

				// absolute Value 
				sA = Math.abs(sA);
				sRed = Math.abs(sRed);
				sGreen = Math.abs(sGreen);
				sBlue = Math.abs(sBlue);

				// multiply with factor
				sA *= factor;
				sRed *= factor;
				sGreen *= factor;
				sBlue *= factor;

				// rgb to int
				int newColor = 0;
				newColor += (sA & 255) << 24;
				newColor += (sRed & 255) << 16;
				newColor += (sGreen & 255) << 8;
				newColor += (sBlue & 255) << 0;
				
				// debug
				print("Summe fÙr (" + (x-foX) +  "," + (y-foY) + ") bis (" + (x+foX) + "," + (y+foY) + ")");
				print("Neu: r=" + (sRed & 255) + " g=" + (sGreen & 255) + " b=" + (sBlue & 255) + " // " + newColor + "\n");
				
				// set color in pixels
				newPixels[ y * iW + x ] = newColor;
			}
			// new row
			start += iW;
		}
		
		// set color
		for(int i=0; i<newPixels.length; i++){
			int x = i%iW ;
			int y = i / iW;
			in.set(x, y, newPixels[i]);
		}
		
		// return image
		return in;
	}
}
