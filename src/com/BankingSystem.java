package com;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
public class BankingSystem {

	public static void main(String[] args) {
		
		int balance, accno;
		String acc_type, password, name; 
		Scanner scn = new Scanner(System.in);
		
		ArrayList<AccountDetails> list = new ArrayList<>();
		list.add(new AccountDetails("Vinay", "Saving", 12000, "admin123"));
		list.add(new AccountDetails("Rahul", "Current", 25000, "admin"));
		list.add(new AccountDetails("Sagar", "Fixed", 35000, "admin12345"));
		
		System.out.println();
		System.out.println("******Select operation****");
		System.out.println("1. Login as a Administrator");
		System.out.println("2. Login as a Customer");
		System.out.println("3. Signup");
		System.out.println("4. Exit");
		
		int ch1;
		do{
			System.out.println("\nEnter choice here -> ");
			ch1=scn.nextInt();
			switch(ch1) {
			case 1:
				AdminMenu(list);
				break;
			case 2:
				String n, pwd;
				boolean flag=false;
				System.out.println();
				System.out.println("******Select operation****");
				System.out.println("1. Login");
				System.out.println("2. Back");
				
				int ch2;
				do {
					System.out.println("\nEnter choice here -> ");
					ch2=scn.nextInt();
					switch(ch2) {
					case 1:
						System.out.println("Enter your user name: ");
						n = scn.next();
						System.out.println("Enter your password: ");
						pwd = scn.next();
					
						Iterator<AccountDetails> itr = list.iterator();
						while(itr.hasNext())
						{
							AccountDetails obj = itr.next();
								if(obj.getName().equals(n) && obj.getPassword().equals(pwd))
								{
									flag =true;
									System.out.println("You are Login Successfully");
									usermenu(list,obj.getAccno());
					
								}
						}	
						if(flag==false)
							{
								System.out.println("Please check your name and passoword OR Create new account!");
							}
						break;
					case 2:
						System.out.println("*****Now you are in previous menu****");
						System.out.println();
						System.out.println("******Select operation****");
						System.out.println("1. Login as a Administrator");
						System.out.println("2. Login as a Customer");
						System.out.println("3. Signup");
						System.out.println("4. Exit");
						break;
					default:
						System.out.println(" Invaid choice, Select again ");	
					}	
				}while(ch2!=2);
				break;
			case 3: 
					System.out.print("Enter your name: ");
					name = scn.next();
					System.out.print("Enter your account type: ");
					acc_type = scn.next();
					System.out.print("Enter amount: ");
					balance = scn.nextInt();
					System.out.print("Set Password: ");
					password = scn.next();
					list.add(new AccountDetails(name, acc_type, balance, password));
					System.out.println("*******ACCOUNT CREATED SUCCESSFULLY*********");
				break;	
			case 4:
				System.out.println("******Thanks for visiting us******");
				break;	
			default:
				System.out.println("******Invalid choice, Select again*******");
				break;
			}
		  }while(ch1!=4);

	}
	public static void AdminMenu(ArrayList<AccountDetails> list) {
		Scanner scn = new Scanner(System.in);
		System.out.println("1. List all accounts");
		System.out.println("2. Logout");
		
		int ch2;
		do {
			System.out.println("\nEnter choice here -> ");
			ch2=scn.nextInt();
			switch(ch2) {
			case 1:
				System.out.println("******List of all accounts********");
				for(AccountDetails ac:list)
				{
					System.out.println(ac);
				}
				break;
			case 2:
				System.out.println("*****You are successfully logout****");
				System.out.println();
				System.out.println("******Select operation****");
				System.out.println("1. Login as a Administrator");
				System.out.println("2. Login as a Customer");
				System.out.println("3. Signup");
				System.out.println("4. Exit");
				break;
			default:
				System.out.println(" Invaid choice, Select again ");	
			}
			
		}while(ch2!=2);
	
	}
	
		public static void usermenu(ArrayList<AccountDetails> list,int accno) {
			 
			Scanner scn = new Scanner(System.in);
			
			System.out.println();
			System.out.println("Select Operations");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Transfer Money");
			System.out.println("4. Balance Enquiry");
			System.out.println("5. Back");
			
			int ch;
			do {
					System.out.println("\nEnter choice here -> ");
					ch=scn.nextInt();
					switch(ch) {
					case 1:
						deposit(list,accno);	
						break;
					case 2:
						try {
							withdraw(list,accno);
						} catch (InsufficientBalance e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 3:
						try {
							transferMoney(list, accno);
						} catch (InsufficientBalance e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 4:
						balance(list, accno);
						break;
					case 5:
						System.out.println();
						System.out.println("******Select operation****");
						System.out.println("1. Login");
						System.out.println("2. Back");
						break;
					default:
						System.out.println(" Invaid choice, Select again ");		
				}		
			}
			while(ch!=5);
		}
		
		public static void deposit(ArrayList<AccountDetails> list, int accno){
			int deposit;
			Scanner scn = new Scanner(System.in);
			Iterator<AccountDetails> itr = list.iterator();
			while(itr.hasNext())
			{
				AccountDetails obj = itr.next();
				if(obj.getAccno() == accno){
					System.out.println("Account Type: " +obj.getAcc_type());
					System.out.println("Current balance: " +obj.getBalance());
					System.out.print("Enter Deposit Amount: ");
					deposit=scn.nextInt();
					obj.setBalance(obj.getBalance()+deposit);
					System.out.println("*******Amount Deposited Successfully*******");
					System.out.println("Updated Balance: " +obj.getBalance());
				}		
			}
		}
		public static void withdraw(ArrayList<AccountDetails> list, int accno) throws InsufficientBalance
		{
			Scanner scn = new Scanner(System.in);
			int withdraw;
			Iterator<AccountDetails> itr = list.iterator();
			while(itr.hasNext())
			{
				AccountDetails obj = itr.next();
				if(obj.getAccno() == accno) {
					System.out.print("Enter Withdraw Amount: ");
					withdraw=scn.nextInt();
					
					if(obj.getBalance()<withdraw)
					{
						throw new InsufficientBalance("Insufficient balance");
					}
					obj.setBalance(obj.getBalance()-withdraw);
					System.out.println("*******Amount Withdraw Successfully*******");
					System.out.println("Updated Balance: " +obj.getBalance());
				}		
			}
		}
		
		public static void transferMoney(ArrayList<AccountDetails> list, int accno) throws InsufficientBalance {
			Scanner scn = new Scanner(System.in);
			int sender_money, tranfer_acc;
			Iterator<AccountDetails> itr = list.iterator();
			while(itr.hasNext())
			{
				AccountDetails obj = itr.next();	
				if(obj.getAccno() == accno) {
					System.out.printf("Enter the amount you want to transfer: ");
					sender_money = scn.nextInt();
					if(obj.getBalance()<sender_money)
					{
						throw new InsufficientBalance("Insufficient balance");
					}
					System.out.println("Enter Receiver Account Number: ");
					tranfer_acc=scn.nextInt();
					obj.setBalance(obj.getBalance()-sender_money);
					while(itr.hasNext())
					{
						AccountDetails obj1 = itr.next();	
					if(obj1.getAccno() == tranfer_acc) {
						obj1.setBalance(obj1.getBalance()+sender_money);
						System.out.println("*******Amount Transfer Successfully*******");
					}
					}
				 break;	
				}
			}		
		}
		
		public static void balance(ArrayList<AccountDetails> list, int accno) {
			for(AccountDetails ac:list)
			{
				if(ac.getAccno() == accno)
					System.out.println("Your current balance is " +ac.getBalance());
			}
		}

}
