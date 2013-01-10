package teil_A;

public class Euro extends AbstractWaehrungsGroesse{

	private long amount;
	private double factor = 1.0;
	
	class EuroSymbol implements WaehrungsSymbole{

		@Override
		public String getFirst() {
			// TODO Auto-generated method stub
			return "€";
		}

		@Override
		public String getSecond() {
			// TODO Auto-generated method stub
			return "ct";
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "Euro";
		}
		
	}

	public Euro(){
		this(0, 0);
	}

	public Euro(long euro){
		this(euro, 0);
	}

	public Euro(long euro, long cent){
		this.amount = euro * 100 + cent;
	}

	public WaehrungsGroesse fromBase(long from){		
		return new Euro( 0, Math.round(from / this.factor) );
	}

	public long getInternalBase(){
		return this.amount;
	}

	public double getConversionFactor(){
		return this.factor;
	}

	public WaehrungsSymbole getSymbols(){
		return new EuroSymbol();
	}



}
