package com.cg.banking.service;

import java.util.List;

import com.cg.banking.dao.BankingDAO;
import com.cg.banking.dao.BankingDaoImpl;
import com.cg.banking.exception.BankingException;
import com.cg.banking.model.CustomerTable;
import com.cg.banking.model.ServiceTracker;
import com.cg.banking.model.Transactions;

public class BankingServiceImpl implements BankingService {
	BankingDAO bankingDao = new BankingDaoImpl();

	@Override
	public boolean validateFields(Long username, String password) throws BankingException {

		return bankingDao.validateFields(username, password);
	}

	@Override
	public List<Transactions> transactionDetails(Long accountId) throws BankingException {

		return bankingDao.transactionDetails(accountId);
	}

	@Override
	public boolean validationPassword(String oldPassword) throws BankingException {

		return bankingDao.validationPassword(oldPassword);
	}

	@Override
	public boolean changePassword(String newPassword1) throws BankingException {

		return bankingDao.changePassword(newPassword1);
	}

	@Override
	public CustomerTable getAddressAndMobileNumber() throws BankingException {

		return bankingDao.getAddressAndMobileNumber();
	}

	@Override
	public int updateAddressAndMobile(CustomerTable customerTable) throws BankingException {

		return bankingDao.updateAddressAndMobile(customerTable);
	}

	@Override
	public int requestForCheckBook() throws BankingException {

		return bankingDao.requestForCheckBook();
	}

	@Override
	public List<ServiceTracker> requestStatus() throws BankingException {

		return bankingDao.requestStatus();
	}

	@Override
	public int FundTransferToSameBank(Long payeeAccountId, Long amount) throws BankingException {

		return bankingDao.FundTransferToSameBank(payeeAccountId, amount);
	}

	@Override
	public int FundTransferToOtherBank(long payeeAccountNumber, long fundAmount) throws BankingException {

		return bankingDao.FundTransferToOtherBank(payeeAccountNumber, fundAmount);
	}

}
