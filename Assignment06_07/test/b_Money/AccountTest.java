package b_Money;

import b_Money.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;

	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(0, SEK));
	}

	@Test
	public void testAddRemoveTimedPayment() throws AccountDoesNotExistException {
       testAccount.addTimedPayment("Hans",5,0, new Money(15000, SEK),SweBank,"Hans");
		assertTrue("exist",testAccount.timedPaymentExists("Hans"));
		testAccount.removeTimedPayment("Hans");
		assertFalse("not exist", testAccount.timedPaymentExists("Hans"));
	}

	@Test
	public void testAddWithdraw() throws AccountDoesNotExistException {
		testAccount.withdraw(new Money(1000, SEK));
		SweBank.withdraw("Alice",new Money(1000,SEK));
		assertEquals(Integer.valueOf(9999000),testAccount.getBalance().getAmount());
		assertEquals(Integer.valueOf(-1000),SweBank.getBalance("Alice"));

		testAccount.deposit(new Money(1000, SEK));
		SweBank.deposit("Alice",new Money(1000,SEK));

		assertEquals(Integer.valueOf(10000000),testAccount.getBalance().getAmount());
		assertEquals(Integer.valueOf(0),SweBank.getBalance("Alice"));
	}

	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		assertEquals(Integer.valueOf(10000000),testAccount.getBalance().getAmount());
		assertEquals(Integer.valueOf(0),SweBank.getBalance("Alice"));

	}
}
