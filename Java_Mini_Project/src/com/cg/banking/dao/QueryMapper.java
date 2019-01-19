package com.cg.banking.dao;

public interface QueryMapper {
	public static final String usercheck = "select * from User_Table where user_Id=? and login_password=?";
	public static final String selectTransactions = "select * from Transactions where Account_id = ?";
	public static final String selectTransactions1 = "select * from Transactions where Account_id = ?";
	public static final String changePassword = "UPDATE User_table set LoginPassword =? where Account_id = ?";
	public static final String oldPasswordCheck="select login_password from user_table";
	public static final String updatePassword="update user_table set login_password=? where account_id=?";
	public static final String getAddressAndNumber="select address,mobile_number from customer where account_id=?";
	public static final String updateAddressAndNumber="update customer set address=?,mobile_number=? where account_id=?";
	public static final String checkBookRequest="insert into service_tracker values(service_id_sequence.nextval,'cheque book request',?,sysdate,'false')";
	
	public static final String requestStatus="select * from service_tracker where account_id=?";
	
	 public static final String fundTransferSameBankPayee="update account_master set account_balance=account_balance-? where account_id=?";
	 public static final String fundTransferSameBankPayeeBalance="update account_master set account_balance=account_balance+? where account_id=?";
	 public static final String fundTransferOtherBankPayee="update account_master set account_balance=account_balance-? where account_id=?";
	 
	/*public static final String createQuery = "create table Mobiles_Table(mobile_id number primary key, name varchar2(20), price number(10,2), quantity number)";
	public static final String insertQuery = "insert into mobiles_table values(?,?,?,?)";
	public static final String checkMobileid = "select * from Mobiles_Table";
	public static final String insertPurchaseDetails = "insert into purchaseDetails_table values(purchase_id_sequence.nextval,?,?,?,sysdate,?)";
	
	public static final String updateQuantity = "update Mobiles_table set quantity = ? where mobile_id = ?";
	
	
	public static final String deleteMobile = "delete from Mobiles_table where mobile_id=?";

	public static final String searchMobileBasedOnRange = "select *from Mobiles_Table where price between ? and ?";*/

}
