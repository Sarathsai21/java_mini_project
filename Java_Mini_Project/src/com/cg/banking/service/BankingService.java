package com.cg.banking.service;

import java.util.List;

import com.cg.banking.exception.BankingException;
import com.cg.banking.model.Transactions;
import com.cg.banking.model.CustomerTable;
import com.cg.banking.model.ServiceTracker;

public interface BankingService {
	boolean validateFields(Long username, String password) throws BankingException;

	List<Transactions> transactionDetails(Long accountId) throws BankingException;

	boolean validationPassword(String oldPassword) throws BankingException;

	boolean changePassword(String newPassword1) throws BankingException;

	CustomerTable getAddressAndMobileNumber() throws BankingException;

	int updateAddressAndMobile(CustomerTable customerTable) throws BankingException;

	int requestForCheckBook() throws BankingException;

	List<ServiceTracker> requestStatus() throws BankingException;

	int FundTransferToSameBank(Long payeeAccountId,Long amount) throws BankingException;

	int FundTransferToOtherBank(long payeeAccountNumber, long fundAmount) throws BankingException;

}
