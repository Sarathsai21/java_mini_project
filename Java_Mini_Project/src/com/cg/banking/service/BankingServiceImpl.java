package com.cg.banking.service;

import com.cg.banking.dao.BankingDAO;
import com.cg.banking.dao.BankingDaoImpl;
import com.cg.banking.exception.BankingException;

public class BankingServiceImpl implements BankingService {
	BankingDAO bankingDao = new BankingDaoImpl();

	@Override
	public boolean validateFields(Long username, String password) throws BankingException {

		return bankingDao.validateFields(username, password);
	}

}
