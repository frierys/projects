package com.ge.exercise3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

    Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void addAccountTest() {
        Account account = new Account("001");
        bank.addAccount(account);
        assertEquals(1, bank.numAccounts());
    }

    @Test
    public void getAccountTest() {
        Account account = new Account("002", "Checking", 100.0f);
        bank.addAccount(account);
        assertEquals(account, bank.getAccount("002"));
    }

    @Test
    public void depositToAccountTest() {
        Account account = new Account("003", "Checking", 100.0f);
        bank.addAccount(account);
        bank.depositToAccount("003", 100.0f);
        assertEquals(200.0f, account.getBalance(), 0.01);
    }

    @Test
    public void withdrawFromAccountTest() {
        Account account = new Account("004", "Checking", 100.0f);
        bank.addAccount(account);
        bank.withdrawFromAccount("004", 100.0f);
        assertEquals(0.0f, account.getBalance(), 0.01);
    }
	
	@Test
	public void getCurrentHoldingsTest()
	{
		Account account = new Account("005");
		bank.depositToAccount(account.getAccountNumber(), 10000.0f);
		assertEquals(10400.0f, bank.getCurrentHoldings(), 0.01);
	}
	
	@Test
	public void closeAccountTest()
	{
		Account account = bank.getAccount("005");
		assertEquals("Account balance must be zero before it can be removed.", bank.closeAccount(account));
		
		bank.withdrawFromAccount(10000.0f);
		bank.closeAccount(account);
		assertEquals(4, bank.numAccounts());
	}
}