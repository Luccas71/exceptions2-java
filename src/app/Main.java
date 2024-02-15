package app;

import java.util.Locale;
import java.util.Scanner;

import javax.security.auth.login.AccountException;

import model.entities.Account;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data:");

			System.out.print("Number: ");
			int number = sc.nextInt();

			sc.nextLine();

			System.out.print("Holder: ");
			String holder = sc.nextLine();

			System.out.print("Initial Balance: ");
			double balance = sc.nextDouble();

			System.out.print("Withdraw Limit: ");
			double withdrawLimit = sc.nextDouble();
			sc.nextLine();

			Account account = new Account(number, holder, balance, withdrawLimit);
			
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();

			account.withdraw(amount);

			System.out.println("New Balance: " + String.format("%.2f", account.getBalance()));
		}
		catch (AccountException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

		sc.close();
	}

}
