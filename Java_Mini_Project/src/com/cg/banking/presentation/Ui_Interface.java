package com.cg.banking.presentation;

import java.util.Scanner;

import com.cg.banking.exception.BankingException;
import com.cg.banking.service.BankingService;
import com.cg.banking.service.BankingServiceImpl;

public class Ui_Interface {

	public static void option(int optionSelect) {

		// int optionselect;

	}

	public static void main(String[] args) throws BankingException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("******Welcome to Citi Bank**********");
		boolean result = false;
		System.out.println("enter username");
		Long username = scanner.nextLong();
		scanner.nextLine();
		System.out.println("enter password");
		String password = scanner.nextLine();
		do {

			BankingService service = new BankingServiceImpl();
			try {
				boolean result1 = service.validateFields(username, password);

				if (result1 == true) {

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
					// Ui_Interface.option(optionSelect);

					switch (optionSelect) {
					case 1:
						// view mini statement
						System.out.println("hello all");
						result = false;

						break;

					case 2:
						// request to change communication address
						System.out.println(1);

						break;
					case 3:
						System.out.println(1);
						// request for check book
						break;
					case 4:
						System.out.println(1);
						// Track service Request

						break;
					case 5:
						System.out.println(1);
						// Fund Transfer

						break;
					case 6:
						System.out.println(1);
						// change password

						break;
					default:
						System.out.println("choose a valid option");
						result = true;

						break;

					}

				} else {
					System.out.println("username /password wrong");
				}
			} catch (BankingException e) {
				throw new BankingException("services doesnt established");
			}

		} while (result == true);
	}

}
