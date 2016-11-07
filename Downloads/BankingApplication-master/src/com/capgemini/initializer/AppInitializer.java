package com.capgemini.initializer;

import java.util.Scanner;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.ServerDowntimeException;
import com.capgemini.model.Customer;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

public class AppInitializer {

	public AppInitializer() {
		// TODO Auto-generated constructor stub
	}

	private static Scanner sc = new Scanner(System.in);
	private AccountService accountService;
	Customer customer1 = new Customer("Poonam", "Kumari");
	Customer customer2 = new Customer("Rama", "Devi");

	public void showMenu() throws Exception {
		int choice;
		while (true) {
			System.out.println("1.create new account");
			System.out.println("2.money deposit");
			System.out.println("3.cash withdraw");
			System.out.println("4.fund transfer");
			System.out.println("5.show balance");
			System.out.println("6.exit");
			System.out.println("Enter your choice");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				createAccount();
				break;
			case 2:
				depositAmount();
				break;
			case 3:
				withdrawAmount();
				break;
			case 4:
				fundTransfer();
				break;
			case 5:
				showAccountBalance();
				break;
			case 6:
				System.exit(0);
			}
		}
	}

	
	private void createAccount() throws InsufficientInitialBalanceException, ServerDowntimeException, InvalidAccountNumberException {
		accountService = new AccountServiceImpl();
		System.out.println("Enter the account number you wish to have : ");
		int accountNumber = sc.nextInt();
		System.out.println("Please enter the initial amount for your account : ");
		int initialAmount = sc.nextInt();
		accountService.createAccount(accountNumber, initialAmount, customer1);
	}

	private void depositAmount() throws InvalidAccountNumberException, ServerDowntimeException, InsufficientBalanceException {
		System.out.println("Please enter your account number : ");
		int accountNumber = sc.nextInt();
		System.out.println("Please enter the amount to deposit : ");
		int amountToDeposit = sc.nextInt();
		accountService.depositAmount(accountNumber, amountToDeposit);
	}

	private void withdrawAmount()
			throws InvalidAccountNumberException, InsufficientBalanceException, ServerDowntimeException {
		System.out.println("Please enter your account number : ");
		int accountNumber = sc.nextInt();
		System.out.println("Please enter the amount to withdraw : ");
		int amountToWithdraw = sc.nextInt();
		accountService.withdrawAmount(accountNumber, amountToWithdraw);
		}

	private void fundTransfer() throws InvalidAccountNumberException, InsufficientBalanceException {
		System.out.println("Please enter source account number : ");
		int fromAccount = sc.nextInt();
		System.out.println("Please enter destination account number : ");
		int toAccount = sc.nextInt();
		System.out.println("Please enter the amount to transfer : ");
		int amountToTransfer = sc.nextInt();
		accountService.fundTransfer(fromAccount, toAccount, amountToTransfer);
	}

	private void showAccountBalance() throws InvalidAccountNumberException {
		System.out.println("Please enter your account number : ");
		int accountNumber = sc.nextInt();
		accountService.showBalance(accountNumber);
	}
}
