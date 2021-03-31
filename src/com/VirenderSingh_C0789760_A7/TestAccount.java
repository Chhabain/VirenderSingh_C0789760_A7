package com.VirenderSingh_C0789760_A7;

import java.util.ArrayList;
import java.util.Scanner;

public class TestAccount {
    static ArrayList<Account> accounts = new ArrayList();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int option = 0;
        while (option != 5) {
            System.out.println("1. Create Your Account.");
            System.out.println("2. Deposit Your money.");
            System.out.println("3. Withdraw Your money.");
            System.out.println("4. Check Your Balance.");
            System.out.println("5. Exit");
            System.out.print("Choose an option from above : ");
            option = s.nextInt();
            switch (option) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3 : withdrawMoney();
                     break;
                case 4 : checkBalance();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid attempt, Kindly select a valid option: ");
                    break;
            }
        }
    }

    public static void createAccount() {
        long accountNo;
        String name;
        boolean exists = false;
        System.out.print("Enter the account number : ");
        accountNo = s.nextLong();
        while (String.valueOf(accountNo).length() < 0 || accountNo < 0) {
            System.out.println("Enter a valid account number.");
            System.out.print("Enter the account number : ");
            accountNo = s.nextLong();
        }
        System.out.print("Enter account owner name : ");
        s.nextLine();
        name = s.nextLine();
        if (accounts.size() > 0) {
            for (Account a : accounts) {
                if (a.accountNo == accountNo) {
                    exists = true;
                    System.out.println("Account already exists");
                }
            }
            if (!exists) {
                accounts.add(new Account(accountNo, name));
                System.out.println("Account created successfully");
            }
        } else {
            accounts.add(new Account(accountNo, name));
            System.out.println("Account created successfully");
        }
    }

    public static void depositMoney() {
        double amount;
        long accountNo;
        boolean exists = false;
        if (accounts.size() > 0) {
            System.out.print("Enter account number : ");
            accountNo = s.nextLong();
            for (Account a : accounts) {
                if (a.accountNo == accountNo) {
                    exists = true;
                    System.out.print("Enter amount to deposit : ");
                    amount = s.nextDouble();
                    while (amount <= 0) {
                        System.out.println("Please enter amount more than 0.");
                        System.out.print("Enter amount to deposit : ");
                        amount = s.nextDouble();
                    }
                    a.deposit(amount);
                    //System.out.println(a.toString());
                    System.out.println("Amount deposited successfully ");
                }
            }
        }
    }

    private static void withdrawMoney() {
        double amount;
        System.out.print("Enter account number : ");
        long accountNo = s.nextLong();
        for (Account a : accounts) {
            if (a.accountNo == accountNo) {
                System.out.println(a.toString());
                System.out.print("Enter amount to withdraw : ");
                amount = s.nextDouble();
                a.withdraw(amount);
                System.out.println(a.toString());
            }
        }
    }

    private static void checkBalance() {
        System.out.print("Enter account number : ");
        long accountNo = s.nextLong();
        for (Account a : accounts) {
            if (a.accountNo == accountNo) {
                System.out.println(a.toString());
            }
        }
    }

}