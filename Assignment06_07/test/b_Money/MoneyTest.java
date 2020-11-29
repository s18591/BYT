package b_Money;

import static org.junit.Assert.*;

import b_Money.Currency;
import b_Money.Money;
import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
		assertEquals(Integer.valueOf(1000),EUR10.getAmount());
		assertEquals(Integer.valueOf(0),SEK0.getAmount());
		assertEquals(Integer.valueOf(20000),SEK200.getAmount());
	}

	@Test
	public void testGetCurrency() {
assertEquals(SEK,SEK0.getCurrency());
assertEquals(EUR,EUR0.getCurrency());

	}

	@Test
	public void testToString() {
		assertEquals("200.0 SEK",SEK200.toString());
		assertEquals("10.0 EUR",EUR10.toString());
	}

	@Test
	public void testGlobalValue() {
		assertEquals(Integer.valueOf(150000),EUR10.universalValue());
		assertEquals(Integer.valueOf(0),SEK0.universalValue());
	}

	@Test
	public void testEqualsMoney() {
		assertFalse(SEK0.universalValue().equals(EUR10.universalValue()));
		assertTrue(SEK0.universalValue().equals(SEK0.universalValue()));
	}

	@Test
	public void testAdd(){
	Money res1 = SEK0.add(SEK200);
	Money res2 = SEK200.add(EUR10);
		assertEquals(Integer.valueOf(20000),res1.getAmount());
		assertEquals(Integer.valueOf(30000),res2.getAmount());
	}

	@Test
	public void testSub() {
		Money res1 = SEK0.sub(SEK200);
		Money res2 = SEK200.sub(EUR10);
		assertEquals(Integer.valueOf(-20000),res1.getAmount());
		assertEquals(Integer.valueOf(10000),res2.getAmount());
	}

	@Test
	public void testIsZero() {
		assertTrue(SEK0.isZero());
		assertTrue(EUR0.isZero());
	}

	@Test
	public void testNegate(){
		assertEquals(Integer.valueOf(-1000),EUR10.negate().getAmount());
		assertEquals(Integer.valueOf(-20000),SEK200.negate().getAmount());
		assertEquals(Integer.valueOf(-2000),EUR20.negate().getAmount());
	}

	@Test
	public void testCompareTo() {
		assertEquals("equal", 0, SEK100.compareTo(EUR10));
		assertEquals("equal", 0, SEK200.compareTo(EUR20));
		assertTrue("greater", 0 < SEK200.compareTo(EUR10));
		assertTrue("less", 0 > SEK100.compareTo(SEK200));
	}
}
