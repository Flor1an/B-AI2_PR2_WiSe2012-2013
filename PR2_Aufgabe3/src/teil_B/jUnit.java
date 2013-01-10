package teil_B;

import static org.junit.Assert.*;

import org.junit.Test;

import teil_A.Euro;
import teil_A.GBP;
import teil_A.USD;
import teil_A.WaehrungsGroesse;


public class jUnit {
	
	
	public void p(Object o){
		System.out.println(o);
	}
	
	@Test
	public void testInitTrue(){		
		WaehrungsGroesse wg1 = new Euro();
		assertTrue(0 == wg1.toBase());
		
		WaehrungsGroesse wg2 = new Euro(1);
		assertTrue(100 == wg2.toBase());
		
		WaehrungsGroesse wg3 = new Euro(1,0);
		assertTrue(100 == wg3.toBase());
	}
	
	@Test
	public void testInitFalse(){
		WaehrungsGroesse wg1 = new Euro(1);
		assertFalse(0 == wg1.toBase());
		
		WaehrungsGroesse wg2 = new Euro(1);
		assertFalse(0 == wg2.toBase());
		
		WaehrungsGroesse wg3 = new Euro(1,0);
		assertFalse(0 == wg3.toBase());		
	}

	@Test
	public void testArithmeticTrue(){	
		WaehrungsGroesse wg1 = new Euro(1);
		
		assertTrue( wg1.add( new Euro(1) ).toBase() == 200);
		assertTrue( wg1.sub( new Euro(1) ).toBase() == 0);
		assertTrue( wg1.mult( 1 ).toBase() == 100);
		assertTrue( wg1.div( 2 ).toBase() == 50);
	}

	@Test
	public void testArithmeticFalse(){	
		WaehrungsGroesse wg1 = new Euro(1);
		
		assertFalse( wg1.add( new Euro(2) ).toBase() == 400);
		assertFalse( wg1.sub( new Euro(1) ).toBase() == 1);
		assertFalse( wg1.mult( 1 ).toBase() == 10);
		assertFalse( wg1.div( 2 ).toBase() == 5);
	}

	@Test
	public void testConvertTrue(){	
		WaehrungsGroesse euro = new Euro(1);
		WaehrungsGroesse dollar = new USD(0);
		long converted = euro.convertTo(dollar).toBase();
		assertTrue( converted > 70 && converted < 80 );
	}

	@Test
	public void testConvertFalse(){	
		WaehrungsGroesse euro = new Euro(1);
		WaehrungsGroesse dollar = new USD(0);
		long converted = euro.convertTo(dollar).toBase();
		assertFalse( converted < 70 || converted > 80 );
	}

	@Test
	public void testInternalBaseTrue(){	
		Euro euro = new Euro(1);
		assertTrue( euro.getInternalBase() == 100);
		USD dollar = new USD(1);
		assertTrue( dollar.getInternalBase() == 100);
		GBP pound = new GBP(1);
		assertTrue( pound.getInternalBase() == 100);
	}

	@Test
	public void testSymbols(){	
		Euro euro = new Euro(1);
		assertTrue( euro.getSymbols().getFirst() == "€" );
		assertTrue( euro.getSymbols().getSecond() == "ct" );
		USD dollar = new USD(1);
		assertTrue( dollar.getSymbols().getFirst() == "$" );
		assertTrue( dollar.getSymbols().getSecond() == "¢" );
		GBP pound = new GBP(1);
		assertTrue( pound.getSymbols().getFirst() == "£" );
		assertTrue( pound.getSymbols().getSecond() == "p" );
	}

}
