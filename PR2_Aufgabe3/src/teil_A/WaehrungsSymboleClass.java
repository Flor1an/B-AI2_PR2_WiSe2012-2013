package teil_A;

import java.util.HashMap;
import java.util.Map;

public class WaehrungsSymboleClass implements WaehrungsSymbole {

	private String[] mySymbols;
	private Map<String, String[]> myMap = new HashMap<String, String[]>();

	public WaehrungsSymboleClass(Object theClass){
		myMap.put("Euro", new String[]{"€","ct","Euro"});
		myMap.put("GBP", new String[]{"£","p","GBP"});
		myMap.put("USD", new String[]{"$","¢","USD"});
		this.mySymbols = myMap.get( theClass.getClass().getName().split("\\.")[1] );
	}

	public String getFirst(){
		return this.mySymbols[0];
	}
	
	public String getSecond(){
		return this.mySymbols[1];
	}
	
	public String getName(){
		return this.mySymbols[2];
		
	}
}
