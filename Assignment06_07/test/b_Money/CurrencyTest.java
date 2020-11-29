package b_Money;

import static org.junit.Assert.*;

import b_Money.Currency;
import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals("SEK",SEK.getName());
		assertEquals("DKK",DKK.getName());
		assertEquals("EUR",EUR.getName());
	}
	
	@Test
	public void testGetRate() {
		assertEquals(Double.valueOf(0.15),SEK.getRate());
		assertEquals(Double.valueOf(0.20),DKK.getRate());
		assertEquals(Double.valueOf(1.5),EUR.getRate());
	}
	
	@Test
	public void testSetRate() {
		Double newRate = 0.275;
		SEK.setRate(newRate);
		assertEquals(newRate, SEK.getRate(),0.00001);
	}
	
	@Test
	public void testGlobalValue() {
		Integer univAmount = 10;
		assertEquals(Integer.valueOf(150),SEK.universalValue(univAmount));
		assertEquals(Integer.valueOf(200),DKK.universalValue(univAmount));
		assertEquals(Integer.valueOf(1500),EUR.universalValue(univAmount));
	}
	
	@Test
	public void testValueInThisCurrency() {
		Integer checkAmount = 100;
		assertEquals(Integer.valueOf(133),SEK.valueInThisCurrency(checkAmount,DKK));
		assertEquals(Integer.valueOf(750),DKK.valueInThisCurrency(checkAmount,EUR));
	}

}
