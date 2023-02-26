package com.atm;


import java.util.*;

public class AtmInterface {
	static int amount = 0;
	static Map <Integer ,String> history=new HashMap<>();
	void transactionHistory() {
		System.out.println("Transaction History: ");
		for(Map.Entry<Integer,String> entry:history.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
	void withdrawAmount(int withdraw) {
		if (amount >= withdraw) {
			history.put(withdraw, "(-)withdrawal Amount by Cash");
			amount = amount - withdraw;
			System.out.println("please collect your cash ");
		} else {
			System.out.println("Insufficient Balance");
		}
	}

	static void depositAmount(int deposit) {
		history.put(deposit, "(+)deposit Amount");
		amount = amount + deposit;
		System.out.println("" + amount);
	}

	void transferAmount(int transfer_amount) {
		if (amount >= transfer_amount) {
			history.put(transfer_amount, "(-)transfer Amount");
			amount = amount - transfer_amount;
			System.out.println("Amount Transfer Sucessfully ");
		} else {
			System.out.println("Insufficient Balance");
		}
	}
	
	public static void main(String args[]) {
		AtmInterface atm = new AtmInterface();
		Scanner sc = new Scanner(System.in);
		String user_id;
		String user_pin;
		System.out.println("*********---Welcome to ABC bank---***********");
		System.out.println("Enter User ID : ");
		user_id = sc.nextLine();

		System.out.println("Enter Pin");
		user_pin = sc.nextLine();

		if (user_id.equals("harsh") && user_pin.equals("harsh@25")) {
			int choice;
			do {
				System.out.println("Welcome to ABC bank");
				System.out.println("What can i help You");
				System.out.println(" 1.Transaction History\n 2. Withdraw\n 3. Deposit\n 4. Transfer \n 5. Quit");

				choice = sc.nextInt();

				switch (choice) {
				case 1: {
						atm.transactionHistory();
					break;
				}
				case 2: {
					System.out.println("Please Enter Withdrawal amount");
					int withdraw = sc.nextInt();
					atm.withdrawAmount(withdraw);
					break;
				}
				case 3: {
					System.out.println(" How much amount to deposit");
					int deposit;
					deposit = sc.nextInt();
					depositAmount(deposit);
					break;
				}
				case 4: {
					System.out.println("Enter Account Number ");
					int aacount_number;
					aacount_number = sc.nextInt();
					System.out.println("how much amount to transfer : ");
					int transfer = sc.nextInt();
					atm.transferAmount(transfer);
					break;
				}
				case 5: {
					System.out.println("please collect your ATM Card \n Thnaks you for using our Services");
					System.exit(0);

				}
				default: {
					System.out.println("Please Enter correct choices");
				}
				}
			} while (choice != 5);
		} else {
			System.out.println("Invaild user ID and pin ");

		}

	}
}
