package com.cg.banking.dao;

import com.cg.banking.exception.BankingException;

public interface BankingDAO {
	boolean validateFields(Long username, String password) throws BankingException;

}
