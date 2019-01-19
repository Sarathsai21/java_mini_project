package com.cg.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cg.banking.exception.BankingException;
import com.cg.banking.model.Banking;
import com.cg.banking.model.CustomerTable;
import com.cg.banking.model.ServiceTracker;
import com.cg.banking.model.Transactions;
import com.cg.banking.utility.JdbcUtility;

public class BankingDaoImpl implements BankingDAO {

	PreparedStatement statement = null;
	Connection connection = null;

	ResultSet resultSet = null;
	ResultSet resultSet1 = null;
	Long accountNumber = 0l;

	@Override
	public boolean validateFields(Long username, String password) throws BankingException {
		List<Banking> list = new ArrayList<>();

		connection = JdbcUtility.getConnection();
		boolean flag = false;
		try {
			statement = connection.prepareStatement(QueryMapper.usercheck);
			statement.setLong(1, username);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Long user = resultSet.getLong("user_id");
				String password1 = resultSet.getString("login_password");
				accountNumber = resultSet.getLong("account_id");
				System.out.println(accountNumber);
				Banking banking = new Banking();
				banking.setUserName(user);
				banking.setPassword(password1);
				list.add(banking);

				Transactions transactions = new Transactions();
				transactions.setAccountId(accountNumber);

			}

			if (list.isEmpty()) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (SQLException e) {
			throw new BankingException("no data found for sql fault");
		}

		return flag;

	}

	@Override
	public List<Transactions> transactionDetails(Long accountId) throws BankingException {

		connection = JdbcUtility.getConnection();
		List<Transactions> list1 = new ArrayList<>();
		try {

			statement = connection.prepareStatement(QueryMapper.selectTransactions);
			statement.setLong(1, accountId);
			resultSet = statement.executeQuery();
			System.out.println("Transaction Details ");
			while (resultSet.next()) {
				long transactionId = resultSet.getLong(1);
				String transactionDescription = resultSet.getString(2);
				LocalDate dateOfTransaction = resultSet.getDate(3).toLocalDate();
				String transactionType = resultSet.getString(4);
				long totalAmount = resultSet.getLong(5);

				Transactions transactions = new Transactions();
				transactions.setTransactionId(transactionId);
				transactions.setTransactionDescription(transactionDescription);
				transactions.setDateOfTransction(dateOfTransaction);
				transactions.setTransactionType(transactionType);
				transactions.setTransactionAmount(totalAmount);

				list1.add(transactions);
			}

		} catch (SQLException e) {
			throw new BankingException("sql exception");
		}

		return list1;
	}

	@Override
	public boolean validationPassword(String oldPassword) throws BankingException {
		connection = JdbcUtility.getConnection();
		boolean result = false;
		try {
			statement = connection.prepareStatement(QueryMapper.oldPasswordCheck);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String password = resultSet.getString("login_password");

				if (password.equals(oldPassword)) {
					result = true;
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean changePassword(String newPassword1) throws BankingException {

		connection = JdbcUtility.getConnection();
		int result = 1;
		boolean flag = false;

		try {

			statement = connection.prepareStatement(QueryMapper.updatePassword);

			statement.setString(1, newPassword1);
			System.out.println(accountNumber);
			statement.setLong(2, accountNumber);

			result = statement.executeUpdate();

			if (result == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public CustomerTable getAddressAndMobileNumber() throws BankingException {

		connection = JdbcUtility.getConnection();
		CustomerTable customerTable = new CustomerTable();

		try {
			statement = connection.prepareStatement(QueryMapper.getAddressAndNumber);
			statement.setLong(1, accountNumber);
			resultSet = statement.executeQuery();
			resultSet.next();
			String address = resultSet.getString("address");
			long number = resultSet.getLong("mobile_number");

			customerTable.setAddress(address);
			customerTable.setMobileNumber(number);

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
		return customerTable;
	}

	@Override
	public int updateAddressAndMobile(CustomerTable customerTable) throws BankingException {
		connection = JdbcUtility.getConnection();
		int updateResult = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.updateAddressAndNumber);
			statement.setString(1, customerTable.getAddress());
			statement.setLong(2, customerTable.getMobileNumber());
			statement.setLong(3, accountNumber);
			updateResult = statement.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
		return updateResult;
	}

	@Override
	public int requestForCheckBook() throws BankingException {

		connection = JdbcUtility.getConnection();
		int checkBookRequest = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.checkBookRequest);
			statement.setLong(1, accountNumber);
			checkBookRequest = statement.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return checkBookRequest;
	}

	@Override
	public List<ServiceTracker> requestStatus() throws BankingException {

		connection = JdbcUtility.getConnection();
		List<ServiceTracker> serviceTrackerList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(QueryMapper.requestStatus);
			statement.setLong(1, accountNumber);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				Long serviceId = resultSet.getLong("service_id");
				String serviceDescription = resultSet.getString("service_description");
				long accountId = resultSet.getLong("account_id");
				LocalDate requestRaisedDate = resultSet.getDate("service_raised_date").toLocalDate();
				String requestStatus = resultSet.getString("service_status");
				ServiceTracker tracker = new ServiceTracker();
				tracker.setAccountId(accountId);
				tracker.setRequestDate(requestRaisedDate);
				tracker.setServiceId(serviceId);
				tracker.setServiceDescription(serviceDescription);
				tracker.setServiceStatus(requestStatus);
				serviceTrackerList.add(tracker);

			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		
		return serviceTrackerList;
	}

	@Override
	public int FundTransferToSameBank(Long payeeAccountId, Long amount) throws BankingException {

		connection = JdbcUtility.getConnection();
		int fundTransferStatus = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.fundTransferSameBankPayee);
			statement.setLong(1, amount);
			statement.setLong(2, accountNumber);
			fundTransferStatus = statement.executeUpdate();

			statement = connection.prepareStatement(QueryMapper.fundTransferSameBankPayeeBalance);
			statement.setLong(1, amount);
			statement.setLong(2, payeeAccountId);
			statement.executeUpdate();

		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		
		return fundTransferStatus;
	}

	@Override
	public int FundTransferToOtherBank(long payeeAccountNumber, long fundAmount) throws BankingException {

		connection = JdbcUtility.getConnection();
		int fundAmountStatus = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.fundTransferOtherBankPayee);
			statement.setLong(1, fundAmount);
			statement.setLong(2, accountNumber);
			fundAmountStatus = statement.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		
		return fundAmountStatus;
	}

}
