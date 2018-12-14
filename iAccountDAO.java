package com.training.standards;

import java.util.List;

import com.training.entity.Account;


public interface iAccountDAO {

	public boolean insertAccount(Account acc);
	public boolean deleteAccount(int accID);
	public boolean updateAccount(int accID, double avgBalance);
	
	public Account getAccount(int accID);
	public List<Account> getAllAccounts();
	
}
