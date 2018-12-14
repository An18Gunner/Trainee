package com.training.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.connection.GetConnection;
import com.training.entity.Account;
import com.training.entity.Employee;
import com.training.standards.iAccountDAO;

public class AccountDAO implements iAccountDAO{

	@Override
	public boolean insertAccount(Account acc) {
		
		String sql = "insert into Account values(?,?,?,?)";
		GetConnection gc = null;
		try {
			
			gc = new GetConnection();
			gc.ps = GetConnection.getMySqlConnection().prepareStatement(sql);
			gc.ps.setInt(1,acc.getAccID());
			gc.ps.setInt(2, acc.getAccNo());
			gc.ps.setDouble(3, acc.getAccBalance());
			gc.ps.setDouble(4, acc.getAccAvgBalance());
			
			return (gc.ps.executeUpdate() > 0);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				gc.ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
 		return false;
	}

	@Override
	public boolean deleteAccount(int accID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAccount(int accID, double avgBalance) {

		String sql = "update Account set Avg_Balance = ? where ID = ?";
		
		GetConnection gc = null;
		try {
			gc = new GetConnection();
			gc.ps = GetConnection.getMySqlConnection().prepareStatement(sql);
			
			gc.ps.setDouble(1,avgBalance);
			gc.ps.setInt(2, accID);
			
			return gc.ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				gc.ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public Account getAccount(int accID) {
		
		String sql = "select ID, Account_No, Balance, Avg_Balance from Account where ID = ?";
		GetConnection gc = null;
		
		try {
			gc = new GetConnection();
			gc.ps = GetConnection.getMySqlConnection().prepareStatement(sql);
			gc.ps.setInt(1, accID);
			gc.rs = gc.ps.executeQuery();
			
			if(gc.rs.next()) {
				Account acc = new Account();
				acc.setAccID(gc.rs.getInt(1));
				acc.setAccNo(gc.rs.getInt(2));
				acc.setAccBalance(gc.rs.getDouble(3));
				acc.setAccAvgBalance(gc.rs.getDouble(4));
				
				return acc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				gc.ps.close();
				gc.rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public List<Account> getAllAccounts() {
		String sql = "select ID, Account_No, Balance, Avg_Balance from Account";
		GetConnection gc = new GetConnection();
		List<Account> accList = new ArrayList<Account>();
		
		try {
			gc.ps = GetConnection.getMySqlConnection().prepareStatement(sql);
			
			// there might be more than 1 records
			gc.rs = gc.ps.executeQuery();
			
			while (gc.rs.next()) {
				
				Account acc = new Account();
				acc.setAccID(gc.rs.getInt(1));
				acc.setAccNo(gc.rs.getInt(2));
				acc.setAccBalance(gc.rs.getDouble(3));
				acc.setAccAvgBalance(gc.rs.getDouble(4));
				
				accList.add(acc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				gc.ps.close();
				gc.rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return accList;
	}
	

}
