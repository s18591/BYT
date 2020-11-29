package b_Money;

import static org.junit.Assert.*;

import b_Money.AccountDoesNotExistException;
import b_Money.AccountExistsException;
import b_Money.Bank;
import b_Money.Currency;
import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("SweBank",SweBank.getName());
		assertEquals("Nordea",Nordea.getName());
		assertEquals("DanskeBank",DanskeBank.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK,SweBank.getCurrency());
		assertEquals(Nordea,Nordea.getCurrency());
		assertEquals(DanskeBank,DanskeBank.getCurrency());
	}

	@Test(expected=AccountExistsException.class)
	public void testOpenAccount() throws AccountExistsException{
		SweBank.openAccount("Ulrika");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika",new Money(2000,DKK));
		SweBank.deposit("Bob",new Money(3000,SEK));
		assertEquals(Integer.valueOf(2666),SweBank.getBalance("Ulrika"));
		assertEquals(Integer.valueOf(3000),SweBank.getBalance("Bob"));

	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		SweBank.withdraw("Ulrika",new Money(2000,DKK));
		SweBank.withdraw("Bob",new Money(3000,SEK));
		assertEquals(Integer.valueOf(-2666),SweBank.getBalance("Ulrika"));
		assertEquals(Integer.valueOf(-3000),SweBank.getBalance("Bob"));
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		assertEquals(Integer.valueOf(0),SweBank.getBalance("Bob"));
		SweBank.withdraw("Ulrika",new Money(2000,DKK));
		assertEquals(Integer.valueOf(-2666),SweBank.getBalance("Ulrika"));
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		SweBank.transfer("Bob",Nordea,"Bob",new Money(1000,SEK));
		assertEquals(Integer.valueOf(-1000),SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(1000),Nordea.getBalance("Bob"));
		SweBank.transfer("Ulrika",DanskeBank,"Gertrud",new Money(1000,SEK));
		assertEquals(Integer.valueOf(-1000),SweBank.getBalance("Ulrika"));
		assertEquals(Integer.valueOf(750),DanskeBank.getBalance("Gertrud"));

	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		SweBank.addTimedPayment("Bob","1",5,3,new Money(2000,SEK),SweBank,"Ulrika");

		for (int i = 0; i < 14; i++) {
			SweBank.tick();
		}
		assertEquals(Integer.valueOf(-4000),SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(4000),SweBank.getBalance("Ulrika"));
		SweBank.removeTimedPayment("Bob","1");
		for (int i = 0; i < 14; i++) {
			SweBank.tick();
		}
		assertEquals(Integer.valueOf(-4000),SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(4000),SweBank.getBalance("Ulrika"));

	}
}
