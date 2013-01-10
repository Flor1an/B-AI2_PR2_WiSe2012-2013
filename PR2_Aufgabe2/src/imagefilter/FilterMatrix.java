package imagefilter;

import java.util.Arrays;

public class FilterMatrix extends AbstractFilterMatrix {

	private Filter f;
	
	public FilterMatrix(Filter f){
		this.f = f;
	}
	
	public int getHeight(){
		return this.f.getContent().length;
	}
	
	public int getWidth(){
		return this.f.getContent()[0].length;
	}
	
	public int getElem(int x, int y){
		
		//System.out.println("Neues Array");
		//System.out.println( Arrays.deepToString( this.f.getContent() ) );
		
		return this.f.getContent()[y][x];
	}
}
