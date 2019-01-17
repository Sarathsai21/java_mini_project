package com.cg.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.banking.exception.BankingException;
import com.cg.banking.model.Banking;
import com.cg.banking.utility.JdbcUtility;

public class BankingDaoImpl implements BankingDAO {

	PreparedStatement statement = null;
	Connection connection = null;

	@Override
	public boolean validateFields(Long username, String password) throws BankingException {
		List<Banking> list = new ArrayList<>();
		ResultSet resultSet = null;
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
				Banking banking = new Banking();
				banking.setUserName(user);
				banking.setPassword(password1);
				list.add(banking);
			}
			for (Banking banking : list) {
				System.out.println(banking.getUserName());
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

}
