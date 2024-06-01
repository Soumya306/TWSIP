package internship;

import java.util.Scanner;

class ATM {
	float Balance = 10000;
	int pin = 1234;
	int Accountno = 123456;
	Scanner sc = new Scanner(System.in);

	public void cheakPin() {
		System.out.print("ENTER ACCOUNT NUMBER: ");
		int entAccountno = sc.nextInt();
		System.out.print("ENTER THE PIN: ");
		int entPIN = sc.nextInt();
		System.out.println();
		if (entAccountno == Accountno) {

			if (entPIN == pin) {
				menu();
			} else {
				System.out.println("WRONG PIN ENTERED.");
				cheakPin();
			}
		} else {
			System.out.println("ENTER A VALID ACCOUNT NUMBER.");
			cheakPin();
		}
	}

	public void menu() {
		System.out.println("1: CHECK A/C BALANCE");
		System.out.println("2: WITHDRAW MONEY");
		System.out.println("3: DEPOSIT MONEY");
		System.out.println("4: TRANSFER MONEY");
		System.out.println("5: EXIT");
		System.out.print("ENTER YOUR CHOICE: ");

		int Option = sc.nextInt();

		if (Option == 1) {// check balance
			System.out.println("AVAILABLE BALANCE: " + Balance);
			menu();
		} else if (Option == 2) {// money withdraw
			System.out.print("ENTER AMOUNT TO WITHDRAW: ");
			int amount = sc.nextInt();
			if (amount <= Balance) {
				System.out.println("MONEY WITHDRAW SUCCESSFUL");
				Balance = Balance - amount;
				System.out.println("AVAILABLE BALANCE: " + Balance);
				menu();
			} else {
				System.out.println("INSUFFICIENT FUND");
				menu();
			}
		} else if (Option == 3) {// money deposit
			System.out.println("ENTER THE AMOUNT: ");
			int amount = sc.nextInt();
			Balance = Balance + amount;
			System.out.println("MONEY DEPOSITED SUCCESSFUL");
			System.out.println("AVAILABLE BALANCE: " + Balance);
			menu();
		} else if (Option == 4) {
			System.out.println("ENTER ACCOUNT NUMBER: ");
			int acc = sc.nextInt();
			System.out.println("ENTER AMOUNT: ");
			int trans = sc.nextInt();
			if (acc == Accountno) {
				System.out.println("MONEY CAN'T TRANSFER TO SAME ACCOUNT.");
				menu();
			} else if (trans <= Balance) {
				Balance = Balance - trans;
				System.out.println("MONEY TRANFERRED SUCCESSFUL.");
				System.out.println("AVAILABLE BALANCE: " + Balance);
				menu();
			} else {
				System.out.println("INSUFFICIENT FUND");
				menu();
			}
		} else if (Option == 5) {// exit
			System.out.println("EXIT SUCCESSFUL.");
			return;
		} else {
			System.out.println("ENTER A VALID CHOICE.");
			menu();
		}
	}
}

public class ATMMachine {

	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.cheakPin();
	}
}
