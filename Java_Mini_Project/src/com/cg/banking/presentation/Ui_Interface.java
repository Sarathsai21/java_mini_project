package com.cg.banking.presentation;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.banking.exception.BankingException;
import com.cg.banking.model.CustomerTable;
import com.cg.banking.model.ServiceTracker;
import com.cg.banking.model.Transactions;
import com.cg.banking.service.BankingService;
import com.cg.banking.service.BankingServiceImpl;

public class Ui_Interface {

	public static void main(String[] args) throws BankingException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("******Welcome to Citi Bank**********");
		boolean result = false;
		System.out.println("enter username");
		Long username = scanner.nextLong();
		scanner.nextLine();
		System.out.println("enter password");
		String password = scanner.nextLine();
		BankingService service = new BankingServiceImpl();
		boolean result1 = service.validateFields(username, password);
		if (result1 == true) {

			do {

				try {

					System.out.println("Home");
					System.out.println("1.View Mini/Detailed statement of Account");
					System.out.println("2.Request to change communication address/mobile number");
					System.out.println("3.Request for check book");
					System.out.println("4.Track service request");
					System.out.println("5.Fund Transfer");
					System.out.println("6.Change Password");
					System.out.println("select a choice from the options");
					int optionSelect = scanner.nextInt();
					result = true;
					

					switch (optionSelect) {
					case 1:
						System.out.println("confirm your account ID");
						Long accountId = scanner.nextLong();
						System.out.println("statement Options");
						System.out.println("1.view Mini-statement");
						System.out.println("2.Detailed Statement");
						System.out.println("All account Details");
						System.out.println("Enter an option to view statement details");
						int statementOption = scanner.nextInt();
						switch (statementOption) {
						case 1:
							
							break;
						case 2:
							BankingService bankingService = new BankingServiceImpl();
							List<Transactions> list = bankingService.transactionDetails(accountId);
							for (Transactions transactions : list) {
								System.out.println(transactions.getTransactionId()
										+ transactions.getTransactionDescription() + transactions.getDateOfTransction()
										+ transactions.getTransactionType() + transactions.getTransactionAmount());
							}
							break;

						default:
							break;
						}
						
						result = false;

						break;

					case 2:
						// request to change communication address
						scanner.nextLine();
						CustomerTable customerTable = service.getAddressAndMobileNumber();
						System.out.println("Your current address is" + customerTable.getAddress());
						System.out.println("Your current mobile number is" + customerTable.getMobileNumber());
						System.out.println("Enter new address:");
						String newAddress = scanner.nextLine();
						System.out.println("Enter new mobile number");
						Long newMobileNumber = scanner.nextLong();
						customerTable = new CustomerTable();
						customerTable.setAddress(newAddress);
						customerTable.setMobileNumber(newMobileNumber);

						int updateResult = service.updateAddressAndMobile(customerTable);
						System.out.println(updateResult + "updated mobile number and address");
						System.out.println("Customer Details have been Updated");

						break;
					case 3:

						int checkBookRequest = service.requestForCheckBook();
						System.out.println(checkBookRequest + "request has been placed");
						System.out.println("Cheque Book Request has been placed");
						// request for check book
						break;
					case 4:

						ServiceTracker serviceTracker = new ServiceTracker();
						List<ServiceTracker> serviceTrackerList = new ArrayList<>();
						serviceTrackerList = service.requestStatus();
						for (ServiceTracker tracker : serviceTrackerList) {
							System.out.println(tracker.getServiceId() + "  " + tracker.getAccountId() + "   "
									+ tracker.getServiceDescription() + "  " + tracker.getRequestDate() + "   "
									+ tracker.getServiceStatus());
						}

						// Track service Request

						break;
					case 5:

						System.out.println("1.Fund Transfer to same bank account");
						System.out.println("2.Fund Transfer to other bank account");
						System.out.println("Enter your fund transfer:");
						int fundTransferChoice = scanner.nextInt();

						switch (fundTransferChoice) {
						case 1:
							System.out.println("Enter the account number for the payee");
							long payeeAccountId = scanner.nextLong();
							System.out.println("Enter Fund Amount to be transferred");
							long amount = scanner.nextLong();
							int transferStatus = service.FundTransferToSameBank(payeeAccountId, amount);
							System.out.println("Fund has been Transferred");

							break;
						case 2:
							System.out.println("Make a Transfer by selecting an Option");
							System.out.println("1.NEFTS");
							System.out.println("2.IMPS");
							System.out.println("ENter a Transfer choice");
							int fundTransferOption = scanner.nextInt();
							switch (fundTransferOption) {
							case 1:
								System.out.println("Enter the account number for the payee");
								long payeeAccountNumber1 = scanner.nextLong();
								System.out.println("Enter Fund Amount to be transferred");
								long fundAmount1 = scanner.nextLong();
								int fundTransferStatus1 = service.FundTransferToOtherBank(payeeAccountNumber1,
										fundAmount1);
								break;
							case 2:
								System.out.println("Enter the account number for the payee");
								long payeeAccountNumber2 = scanner.nextLong();
								System.out.println("Enter Fund Amount to be transferred");
								long fundAmount2 = scanner.nextLong();
								int fundTransferStatus2 = service.FundTransferToOtherBank(payeeAccountNumber2,
										fundAmount2);
								System.out.println("Fund has been Transferred");
								break;

							default:
								System.out.println(
										"fundTransferOption is Invalid Please Select a valid fundTransferOption");
								break;
							}

							break;

						default:
							System.out.println("optionSelect is Invalid Please Select a valid Option");
							break;
						}

						break;
					case 6:
						System.out.println(1);
						scanner.nextLine();
						System.out.println("Enter old password:");
						String oldPassword = scanner.nextLine();
						boolean oldPasswordCheck = service.validationPassword(oldPassword);
						if (oldPasswordCheck) {
							System.out.println("Enter new password");
							String newPassword1 = scanner.nextLine();
							System.out.println("Enter new password again");
							String newPassword2 = scanner.nextLine();
							if (newPassword1.equals(newPassword2)) {

								boolean changePassword = service.changePassword(newPassword1);
								System.out.println(changePassword + "password has been updated ");
							} else {
								System.out.println("both new passwords are not matching");
							}

						}

						break;
					default:
						System.out.println("choose a valid option");
						result = true;

						break;

					}

				} catch (Exception e) {
					e.printStackTrace();

				}

			} while (result == true);
		} else {
			System.out.println("username/password wrong");
		}
	}

}
