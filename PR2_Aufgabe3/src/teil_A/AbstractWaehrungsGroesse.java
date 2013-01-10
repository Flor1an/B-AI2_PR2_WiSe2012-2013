package teil_A;

public abstract class AbstractWaehrungsGroesse implements WaehrungsGroesse {

	protected abstract long getInternalBase();
	protected abstract double getConversionFactor();
	protected abstract WaehrungsSymbole getSymbols();

	public void p(Object o){
		System.out.println(o);
	}

	public WaehrungsGroesse add(WaehrungsGroesse add){
		return this.fromBase( this.toBase() + add.toBase() );
	}
	public WaehrungsGroesse sub(WaehrungsGroesse sub){
		return this.fromBase( this.toBase() - sub.toBase() );
	}
	public WaehrungsGroesse mult(long mult){
		return this.fromBase( this.toBase() * mult );
	}
	public WaehrungsGroesse div(long div){
		return this.fromBase( this.toBase() / div );
	}
	public long toBase(){
		return  (long) (this.getInternalBase() * this.getConversionFactor()) ;
	}
	public abstract WaehrungsGroesse fromBase(long baseVal);
	
	public WaehrungsGroesse convertTo(WaehrungsGroesse other){
		return other.fromBase( this.toBase() );
	}
	public String toString(){
		return Math.round(this.getInternalBase()) / 100 + this.getSymbols().getFirst() + " " + Math.round(this.getInternalBase()) % 100 + this.getSymbols().getSecond();
	}
}