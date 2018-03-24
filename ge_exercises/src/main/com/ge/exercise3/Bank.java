package com.ge.exercise3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private static final Logger logger = LogManager.getLogger(Bank.class);
    private static final float OVERDRAFT_LIMIT = -100;
    
    private Map<String, Account> accountMap;

    public Bank() {
        accountMap = new HashMap<>();
    }

    public Account getAccount(String accountNumber) {
        return accountMap.get(accountNumber);
    }

    public void addAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    public void depositToAccount(String accountNumber, float amount) {
        getAccount(accountNumber).deposit(amount);
    }

    public void withdrawFromAccount(String accountNumber, float amount) {
    	Account account = getAccount(accountNumber);
    	
    	if (account.getAccountType().toLowerCase().equals("savings"))
    	{
    	    if (account.getBalance() >= 0)
    	        account.withdraw(amount);
    	}
    	else
    	{
    		float aux = account.getBalance() - amount;
    		
    		if (aux >= OVERDRAFT_LIMIT)
    	        account.withdraw(amount);
    	}
    }

    public int numAccounts() {
        return accountMap.size();
    }
    
    public float getCurrentHoldings()
    {
    	float sumOfHoldings = 0;

    	for( Map.Entry<String, Account> entries : accountMap.entrySet())
    	{
    		Account account = entries.getValue();
    		sumOfHoldings += account.getBalance();
    	}
    	
    	return sumOfHoldings;
    }
}
