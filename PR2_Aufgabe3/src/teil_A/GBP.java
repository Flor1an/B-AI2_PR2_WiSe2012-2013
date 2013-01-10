package teil_A;

public class GBP extends AbstractWaehrungsGroesse{

	private long amount;
	private double factor = 0.8;
	
	class GBPSymbol implements WaehrungsSymbole{

		@Override
		public String getFirst() {
			// TODO Auto-generated method stub
			return "£";
		}

		@Override
		public String getSecond() {
			// TODO Auto-generated method stub
			return "p";
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "GBP";
		}
		
	}

	public GBP(){
		this(0, 0);
	}

	public GBP(long euro){
		this(euro, 0);
	}

	public GBP(long euro, long cent){
		this.amount = euro * 100 + cent;
	}

	public WaehrungsGroesse fromBase(long from){
		return new GBP( 0, Math.round(from / this.factor) );
	}

	public long getInternalBase(){
		return this.amount;
	}

	public double getConversionFactor(){
		return this.factor;
	}

	public WaehrungsSymbole getSymbols(){
		return new GBPSymbol();
	}



}
