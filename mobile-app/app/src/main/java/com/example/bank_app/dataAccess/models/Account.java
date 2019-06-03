package com.example.bank_app.dataAccess.models;

public class Account {
    private int accountNumber;
    private float balance;

    public Account(){
        this.accountNumber=0;
        this.balance=0;
    }
    public Account(int accountNumber, float balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
