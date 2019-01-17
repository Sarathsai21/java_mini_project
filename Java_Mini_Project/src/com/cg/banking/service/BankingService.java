package com.cg.banking.service;

import com.cg.banking.exception.BankingException;

public interface BankingService {
	boolean validateFields(Long username, String password) throws BankingException;

}
