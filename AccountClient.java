package com.training.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.training.dao.AccountDAO;
import com.training.dao.EmployeeDAO;
import com.training.entity.Account;
import com.training.entity.Employee;
import com.training.standards.iAccountDAO;
import com.training.standards.iEmployeeDAO;

public class AccountClient {
	public static void main(String[] args) {
		Account acc = new Account();
		iAccountDAO accDAO = new AccountDAO();
		Scanner sc;
		
		// Display each record in the table
		//accDAO.getAllAccounts().forEach(System.out :: println);
		List<Account> accList =  accDAO.getAllAccounts();
		for (Account i : accList) {
			System.out.println(i);
			System.out.println("Please enter the Average Balance:");
			sc = new Scanner(System.in);
			Double avgBalance = sc.nextDouble();

			// Update Account
			int id = i.getAccID();
			accDAO.updateAccount(id, avgBalance);
			
			// Get the Account to show the new avg balance
			Account a = new Account();
			a = accDAO.getAccount(id);
			System.out.println("Updated for Account ID: " + a.getAccID() + ": Account No " + a.getAccNo() + " with avg Balance of $" + a.getAccAvgBalance());
		}
		
		
		
		
		
		
		
		
		
		// ============ Insert Account statement to initialize the table ================
			//acc.setAccID(5);
			//acc.setAccNo(3);
			//acc.setAccBalance(555);
			//acc.setAccAvgBalance(0);
			
			//boolean insertFlag  = accDAO.insertAccount(acc);
			
			// <condition> ? "<true>:"<false>"
			//System.out.println(insertFlag ? "Record Inserted" : "Sorry, not inserted");
		// ====== End of Insert statement ================================================
	}
}
