package com.VirenderSingh_C0789760_A7;

import java.util.ArrayList;
import java.util.Scanner;

public class Account {

    long accountNo;
    String accountHolder;
    double balance;


    public Account(long accountNo, String accountHolder) {
        this.accountNo = accountNo;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    public long getAccountNo() { return accountNo; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }


    public void setAccountNo(long accountNo) { this.accountNo = accountNo; }
    public void setAccountHolder(String accountHolder) { this.accountHolder = accountHolder; }
    public void setBalance(double balance) { this.balance = balance; }


    void deposit(double money){ this.balance += money; }

    void withdraw(double money){ this.balance -= money; }
    @Override
    public String toString(){

        return String.format("Account No. \t" + accountNo +"\nAccount Holder \t" + accountHolder + "\nBalance \t\t" + this.balance);
    }
}