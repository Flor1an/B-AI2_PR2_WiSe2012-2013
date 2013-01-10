package teil_A;

public interface WaehrungsGroesse {

	public WaehrungsGroesse add(WaehrungsGroesse toAdd);
	
	public WaehrungsGroesse sub(WaehrungsGroesse toSub);
	
	public WaehrungsGroesse mult(long toMult);
	
	public WaehrungsGroesse div(long toDiv);
	
	public long toBase();
	
	public WaehrungsGroesse fromBase(long baseVal);
	
	public WaehrungsGroesse convertTo(WaehrungsGroesse other);
	
}
